/**
 * Project: SERSE_ECN
 * Creation date: 6 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.ecn.serse.controllers.ConfigurationController.SerseConfiguration;
import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.exceptions.IdentificationException;
import org.ecn.serse.exceptions.ResultCode;
import org.ecn.serse.models.Utilisateur;
import org.ecn.serse.models.Utilisateur.Categorie;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 * Classe de gestion des utilisateurs
 * @author Audrey
 */
public class UtilisateurController {
	
	/** Controleur de base de données */
	protected BddController bdd;

	/** Clé permettant de générer les jetons de connexion (token) */
	private static final String KEY_TOKENS = "F.Lecuyer,R.NguyenVan,A.Pouchoulin,J.Terrade,M.Terrade,R.Traineau,OnCrypteToutAvecNosNomsYeah";
	
	/**
	 * Initialise un controlleur d'utilisateurs
	 * @param bdd : Base de données à utiliser
	 */
	public UtilisateurController(BddController bdd) {
		this.bdd = bdd;
	}
	
	/**
	 * Connexion de l'utilisateur et création d'un token de connexion (inséré en base de données)
	 * @param login identifiant de l'utilisateur
	 * @param pass Mot de passe
	 * @return ObjetRetourMethodeConnexion qui contient le yoken de connexion créé et l'identifiant de l'utilisateur
	 * @throws IdentificationException Identifiants invalides ou erreur de connexion à LDAP
	 * @throws DatabaseException
	 */
	public Utilisateur seConnecter(String login, String password) throws IdentificationException, DatabaseException {
		// configurations LDAP (host, useSSL, port)
			String ldapHost = ConfigurationController.getConfiguration(SerseConfiguration.LDAP_HOST);
			boolean ldapUseSsl = Boolean.parseBoolean(ConfigurationController.getConfiguration(SerseConfiguration.LDAP_USE_SSL));
			int ldapPort;
			try {
				ldapPort = Integer.valueOf(ConfigurationController.getConfiguration(SerseConfiguration.LDAP_PORT));
			} catch(NumberFormatException e) {
				String message = "Valeur incorrecte pour le paramètre " + SerseConfiguration.LDAP_PORT.getKey() + ", vérifiez le fichier de configuration";
				throw new IdentificationException(ResultCode.LDAP_CONNECTION_ERROR, message, e);
			}

		try {	
			SocketFactory socketFactoryConnection = ldapUseSsl ? SSLSocketFactory.getDefault() : SocketFactory.getDefault();
			
			// Dn pour la requête de connexion
				String dn = "uid=" + login + ",ou=people,dc=ec-nantes,dc=fr";
				LDAPConnection connection = new LDAPConnection(socketFactoryConnection, ldapHost, ldapPort, dn, password);
			
			// Succès de la connexion : récupération des nom, prénom, mail de l'utilisateur depuis LDAP
				String filtre = "(uid=" + login + ")";
				SearchRequest request = new SearchRequest("ou=people, dc=ec-nantes, dc=fr", SearchScope.SUB, filtre, "uidNumber", "sn", "givenName", "mail");
				SearchResult searchResult = connection.search(request);
				List<SearchResultEntry> lstResults = searchResult.getSearchEntries();
				connection.close();
			
				if(lstResults.isEmpty()) {
					throw new IdentificationException(ResultCode.LDAP_CONNECTION_ERROR, "Impossible de récupérer les informations LDAP de l'utilisateur.");
				}
				
				Long uidNumber = lstResults.get(0).getAttributeValueAsLong("uidNumber");
				String nom = lstResults.get(0).getAttributeValue("sn");
				String prenom = lstResults.get(0).getAttributeValue("givenName");
				String mail = lstResults.get(0).getAttributeValue("mail");
				
				if(uidNumber == null) {
					throw new IdentificationException(ResultCode.LDAP_CONNECTION_ERROR, "Format d'uidNumber invalide sur le serveur LDAP");
				}

				String token = genererToken(uidNumber);
				Integer id = getUtilisateurIdFromUidLDAP(login);
			
			//Connexion à la base de données
				bdd.startTransaction();
				Connection conn = bdd.getConnection();
			
				// Utilisateur déjà présent en base
					if(id != null) { 
						/* Token valable 1h, heure du serveur de base de donnée. 
						 * Le token est constitué de caractères alphanumériques et de "_" : pas d'échappement nécessaire
						 */
						PreparedStatement statement = conn.prepareStatement(
								"UPDATE serse.utilisateur "
								+ "SET "
								+ "utilisateur_nom=?, "
								+ "utilisateur_prenom=?, " 
								+ "utilisateur_email=?, "
								+ "utilisateur_token=?, "
								+ "utilisateur_active=TRUE, "
								+ "utilisateur_token_expire=now() + interval '1 hour' "
								+ "WHERE utilisateur_id=?");
						statement.setString(1, nom);
						statement.setString(2, prenom);
						statement.setString(3, mail);
						statement.setString(4, token);
						statement.setInt(5, id);				
						
						statement.execute();
					// Utilisateur absent de la base : insertion
					} else { 	
						PreparedStatement statement = conn.prepareStatement(
								"INSERT INTO serse.utilisateur"
								+ "(utilisateur_nom, "
								+ "utilisateur_prenom, " 
								+ "utilisateur_email, "
								+ "utilisateur_token, "
								+ "utilisateur_active=TRUE, "
								+ "utilisateur_token_expire) "
								+ "VALUES(?, ?, ?, ?, now() + interval '1 hour') "
								+ "RETURNING utilisateur_id");
						statement.setString(1, nom);
						statement.setString(2, prenom);
						statement.setString(3, mail);
						statement.setString(4, token);
						
						ResultSet reponse = statement.executeQuery();
						// Récupération de l'identifiant de l'utilisateur ajouté
							reponse.next();
							id = reponse.getInt(1);
							reponse.close();
					}
					bdd.commit();
			
			Categorie categorie = getUtilisateurCategorieFromId(id);
			return new Utilisateur(id, nom, prenom, mail, categorie, token);
			
		} catch (com.unboundid.ldap.sdk.LDAPException e) {
			if(e.getResultCode() == com.unboundid.ldap.sdk.ResultCode.INVALID_CREDENTIALS) {
				throw new IdentificationException(ResultCode.IDENTIFICATION_ERROR, "Identifiants LDAP invalides.");
			} else {
				throw new IdentificationException(ResultCode.LDAP_CONNECTION_ERROR, "Erreur de connexion à LDAP : " + e.getResultCode().getName(), e);
			}
		} catch (InvalidKeyException | NoSuchAlgorithmException e) {
			throw new IdentificationException(ResultCode.CRYPTOGRAPHIC_ERROR, "Erreur de génération de token : machine Java hôte incompatible");
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	/**
	 * Déconnexion d'un utilisateur
	 * @param idUtilisateur ID de l'utilisateur à déconnecter
	 * @throws DatabaseException
	 */
	public void seDeconnecter(int idUtilisateur) throws DatabaseException {
		// Invalidation du token
		bdd.executeUpdate(
				"UPDATE serse.utilisateur "
				+ "SET utilisateur_token=NULL, "
				+ "utilisateur_token_expire=NULL "
				+ "WHERE utilisateur_id=" + idUtilisateur);
	}
	
	
	/**
	 * Génération d'un token de connexion pour l'utilisateur. Les tokens générés sont aléatoires.
	 * Algorithme : 
	 * - Générer une chaîne de 10 caractères alphanumériques aléatoires (exemple 1b483A5e35) qu’on appelle s
	 * - Définir t = s + id LDAP d’utilisateur.
	 * - Calculer le hmac_sha256 de t, au format base64. On le note h. La clé du hmac_sha256 est un mot de passe stocké sur le serveur.
	 * - Renvoyer t + h
	 * 
	 * Le token généré permet d'identifier l'utilisateur (contient son ID Ldap en clair), change à chaque connexion (partie aléatoire),
	 * n'est pas falsifiable (besoin de la clé du serveur pour générer le hmac de vérification), et est vérifiable par le serveur
	 * (il suffit de recalculer le hmac à partir de la 1ère partie de la chaîne et de le comparer à la 2ème partie).
	 * 
	 * En pratique on effectue la vérification en comparant avec le token stocké en base.
	 * 
	 * @param idUtilisateur ID LDAP de l'utilisateur pour lequel générer un token
	 * @return token généré (non inséré en BDD), qui est une chaîne alphanumérique
	 * @throws InvalidKeyException Clé serveur invalide (ne devrait jamais se produire)
	 * @throws NoSuchAlgorithmException La machine Java hôte est incapable de produire un HMAC_SHA256 (ne devrait jamais se produire)
	 */
	public static String genererToken(long idUtilisateur) throws InvalidKeyException, NoSuchAlgorithmException {
		// Génération de 10 caractères aléatoires
		String randomSeed = RandomStringUtils.randomAlphanumeric(10);
		String tokenHeader = randomSeed + idUtilisateur;
		
		String res = hmac_sha256(KEY_TOKENS, tokenHeader);
		
		return tokenHeader + res;
	}
	
	/**
	 * Calcul du HMAC_SHA256 d'une chaîne avec un mot de passe donné.
	 * Voir : http://fr.wikipedia.org/wiki/Keyed-Hash_Message_Authentication_Code (accédé 11/10/2013)
	 * 
	 * @param password clé à utiliser pour le calcul du HMAC
	 * @param input Chaîne dont le hash est à calculer
	 * @return hmac_sha256 calculé (mot de passe encrypté)
	 * @throws InvalidKeyException Clé fournie de format invalide
	 * @throws NoSuchAlgorithmException La machine Java hôte est incapable de produire un HMAC_SHA256 (ne devrait jamais se produire)
	 */
	public static String hmac_sha256(String password, String input) throws NoSuchAlgorithmException, InvalidKeyException {
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "HmacSHA256");

		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(keySpec);
		byte[] result = mac.doFinal(input.getBytes());
		
		// Conversion en une chaîne base64
		String strResult = "";
        for (final byte element : result)
        {
        	// Conversion du byte en byte non signé, affichage en base 16 
        	strResult += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }

		return strResult;
	}
	
	/**
	 * Vérifie la validité d'un token de connexion fourni par un utilisateur
	 * @param token Token à vérifier
	 * @return ID de l'utilisateur si le token est valide
	 * @throws IdentificationException Token de l'utilisateur invalide ou expiré
	 * @throws DatabaseException
	 */
	public int verifierConnexion(String token) throws IdentificationException, DatabaseException {
		
		if(!StringUtils.isAlphanumeric(token))
			throw new IdentificationException(ResultCode.IDENTIFICATION_ERROR, "Format de token invalide");

		try {
		
			PreparedStatement req = bdd.getConnection().prepareStatement("SELECT utilisateur_id FROM edt.utilisateur WHERE utilisateur_token=? AND utilisateur_token_expire > now()");
			req.setString(1, token);
			
			int id = bdd.recupererId(req, "utilisateur_id");
		
			if(id != -1) {
				return id;
			}
			else {
				throw new IdentificationException(ResultCode.IDENTIFICATION_ERROR, "Token invalide ou expiré");
			}
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	/**
	 * Récupération de l'id d'un utilisateur connu dans la base de données depuis son uiD LDAP.
	 * (L'utilisateur doit déjà avoir été enregistré sur le système emploi du temps pour que le résultat soit non nul)
	 * @param uid LDAP de l'utilisateur
	 * @return id de l'utilisateur dans la base de données SERSE, ou null si il n'est pas présent dans la base
	 * @throws DatabaseException
	 */
	private Integer getUtilisateurIdFromUidLDAP(String uidLDAP) throws DatabaseException {
		
		try {
			String request = "SELECT utilisateur_id FROM serse.utilisateur WHERE utilisateur_login=?";
			PreparedStatement statement = bdd.getConnection().prepareStatement(request);
			statement.setString(1, uidLDAP);
			
			ResultSet results = statement.executeQuery();	
			Integer id = null;

			if(results.next()) {
				id = results.getInt(1);
			}
			results.close();

			return id;
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	/** Récupération de la catégorie d'un utilisateur à partir de son identifiant en base de données
	 * @param id identifiant de l'utilisateur dans la base de données SERSE
	 * @return categorie de l'utilisation
	 * @throws DatabaseException
	 */
	private Categorie getUtilisateurCategorieFromId(Integer id) throws DatabaseException{
		Categorie categorieUtilisateur = Utilisateur.Categorie.ETUDIANT;
		boolean isDRI = false;
		boolean isAdmin = false;
		try {
			
			// test if DRI member
				String request = 
						"SELECT dri_id "
						+ "FROM serse.dri "
						+ "WHERE utilisateur_id="+id;
				PreparedStatement statement = bdd.getConnection().prepareStatement(request);
				ResultSet results = statement.executeQuery();	
	
				if(results.next()) {
					isDRI = true;
				}
				
			// test if ADMIN member
				request = 
						"SELECT administrateur_id "
						+ "FROM serse.administrateur "
						+ "WHERE utilisateur_id="+id;
				statement = bdd.getConnection().prepareStatement(request);
				results = statement.executeQuery();
				if(results.next()) {
					isAdmin = true;
				}
				
			results.close();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		
		if (isAdmin && isDRI) {
			categorieUtilisateur = Utilisateur.Categorie.DRI_ADMIN;
		} else if (isAdmin){
			categorieUtilisateur = Utilisateur.Categorie.ADMINISTRATEUR;
		} else if (isDRI){
			categorieUtilisateur = Utilisateur.Categorie.DRI;
		}
		return categorieUtilisateur;
	}
}
