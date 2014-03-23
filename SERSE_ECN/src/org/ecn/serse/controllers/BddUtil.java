/**
 * Project: SERSE_ECN
 * Creation date: 20 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe contenant des requêtes en base de données fréquemment utilisées
 * @author Audrey
 *
 */
public class BddUtil {

	/**
	 * Obtenir l'id de l'utilisateur à partir de son nom et de son prénom
	 * @param bdd contrôleur de base de données
	 * @param nom nom de l'utilisateur
	 * @param prenom prénom de l'utilisateur
	 * @return id de l'utilisateur en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getUserId(BddController bdd, String nom, String prenom) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT utilisateur_id "
				+ "FROM serse.utilisateur "
				+ "WHERE utilisateur_nom = ? "
				+ "AND utilisateur_prenom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, nom);
		statement.setString(2, prenom);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id du séjour à partir de son libellé (entreprise, université)
	 * @param bdd contrôleur de base de données
	 * @param sejour libellé du séjour
	 * @return id du séjour en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getSejourId(BddController bdd, String sejour) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT typesejour_id "
				+ "FROM serse.typesejour "
				+ "WHERE typesejour_libelle = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, sejour);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id de la mobilité en fonction de son libellé (CME, STING, ...)
	 * @param bdd contrôleur de base de données
	 * @param mobilite libellé de la mobilité
	 * @return id de la mobilité en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getMobiliteId(BddController bdd, String mobilite) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT typemobilite_id "
				+ "FROM serse.typemobilite "
				+ "WHERE typemobilite_libelle = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, mobilite);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id de l'experience à partir de son libellé (académique, professionnel)
	 * @param bdd contrôleur de base de données
	 * @param experience libellé de l'experience
	 * @return id de l'experience en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getExperienceId(BddController bdd, String experience) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT typeexperience_id "
				+ "FROM serse.typeexperience "
				+ "WHERE typeexperience_libelle = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, experience);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id de l'université en fonction de son nom
	 * @param bdd contrôleur de base de données
	 * @param universite nom de l'université
	 * @param createIfNotExisting true si on veut créer l'université en base de données si elle n'existe pas, false sinon
	 * @param villeId id de la ville (utile si il faut entrer l'université en base de données)
	 * @return id de l'université en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getUniversiteId(BddController bdd, String universite, boolean createIfNotExisting, int villeId) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT universite_id "
				+ "FROM serse.universite "
				+ "WHERE universite_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, universite);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id==-1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.universite "
					+ "(universite_nom, ville_id) "
					+ "VALUES (?, ?) "
					+ "RETURNING universite_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, universite);
			statement.setInt(2, villeId);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id de l'entreprise à partir de son nom
	 * @param bdd contrôleur de base de données
	 * @param entreprise nom de l'entreprise
	 * @param createIfNotExisting true si on veut créer l'entreprise en base de données si elle n'existe pas, false sinon
	 * @return id de l'entreprise en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getEntrepriseId(BddController bdd, String entreprise, boolean createIfNotExisting) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT entreprise_id "
				+ "FROM serse.entreprise "
				+ "WHERE entreprise_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, entreprise);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id==-1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.entreprise "
					+ "(entreprise_nom) "
					+ "VALUES (?) "
					+ "RETURNING entreprise_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, entreprise);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id du continent à partir de son nom
	 * @param bdd contrôleur de base de données
	 * @param continent nom du continent
	 * @return id du continent en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getContinentId(BddController bdd, String continent) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT continent_id "
				+ "FROM serse.continent "
				+ "WHERE continent_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, continent);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id du pays en fonction de son nom
	 * @param bdd contrôleur de base de données
	 * @param pays nom du pays
	 * @param createIfNotExisting true si on veut créer le pays en base de données si elle n'existe pas, false sinon
	 * @param continentId id du continent correspondant au pays (utile si création du pays en BD)
	 * @return id du pays en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getPaysId(BddController bdd, String pays, boolean createIfNotExisting, int continentId) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT pays_id "
				+ "FROM serse.pays "
				+ "WHERE pays_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, pays);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id==-1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.pays "
					+ "(pays_nom, continent_id) "
					+ "VALUES (?, ?) "
					+ "RETURNING pays_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, pays);
			statement.setInt(2, continentId);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Obtenir de la ville en fonction de son nom
	 * @param bdd contrôleur de base de données
	 * @param ville nom de la ville
	 * @param createIfNotExisting true si on veut créer la ville en base de données si elle n'existe pas, false sinon
	 * @param paysId id du pays correspondant à la ville (utile si on crée la ville en base de données)
	 * @return id de la ville en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getVilleId(BddController bdd, String ville, boolean createIfNotExisting, int paysId) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT ville_id "
				+ "FROM serse.ville "
				+ "WHERE ville_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, ville);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id == -1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.ville "
					+ "(ville_nom, pays_id) "
					+ "VALUES (?, ?) "
					+ "RETURNING ville_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, ville);
			statement.setInt(2, paysId);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id de la langue à partir de son nom
	 * @param bdd contrôleur de base de données
	 * @param langue nom de la langue
	 * @param createIfNotExisting true si on veut créer la langueen base de données si elle n'existe pas, false sinon
	 * @return id de la langue en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getLangueId(BddController bdd, String langue, boolean createIfNotExisting) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT langue_id "
				+ "FROM serse.langue "
				+ "WHERE langue_nom = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, langue);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id == -1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.langue "
					+ "(langue_nom) "
					+ "VALUES (?) "
					+ "RETURNING langue_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, langue);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Obtenir l'id du domaine d'activité en fonction de son nom
	 * @param bdd contrôleur de base de données
	 * @param domaine nom du domaine d'activité
	 * @param createIfNotExisting true si on veut créer le domaine en base de données si elle n'existe pas, false sinon
	 * @return id du domaine en base de données (-1 si non trouvé)
	 * @throws SQLException
	 */
	public static int getDomaineId(BddController bdd, String domaine, boolean createIfNotExisting) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT domaineactivite_id "
				+ "FROM serse.domaineactivite "
				+ "WHERE domaineactivite_libelle = ?;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setString(1, domaine);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id == -1 && createIfNotExisting){
			// TODO: modifier pour pouvoir envoyer une requête d'ajout de nouvelle option
			String requeteCreate = 
					"INSERT INTO serse.domaineactivite "
					+ "(domaineactivite_libelle) "
					+ "VALUES (?) "
					+ "RETURNING domaineactivite_id;";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setString(1, domaine);
			if (statement.execute()){
				ResultSet resultSet = statement.getResultSet();
				if(resultSet.next()){
					id = resultSet.getInt(1);
				}
			}
		}
		return id;
	}
	
	/**
	 * Test si l'entreprise est associé au pays en base de données, si ce n'est pas le cas réalise l'association
	 * @param bdd contrôleur de base de données
	 * @param entrepriseId id de l'entreprise
	 * @param paysId id du pays
	 * @throws SQLException
	 */
	public static void associateEntreprisePays(BddController bdd, int entrepriseId, int paysId) throws SQLException{
		int id = -1;
		String requeteId = 
				"SELECT entreprise_id "
				+ "FROM serse.entreprise_pays "
				+ "WHERE pays_id=? "
				+ "AND entreprise_id= ?;";	
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteId);
		statement.setInt(1, paysId);
		statement.setInt(2, entrepriseId);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		if (id==-1){
			String requeteCreate = 
					"INSERT INTO serse.entreprise_pays "
					+ "(entreprise_id, pays_id) "
					+ "VALUES (?, ?);";
			statement = bdd.getConnection().prepareStatement(requeteCreate);
			statement.setInt(1, entrepriseId);
			statement.setInt(2, paysId);
			statement.execute();
		}
	}
	
	/**
	 * Crée l'association entre la langue et le rapport en base de données
	 * @param bdd contôleur de base de données
	 * @param rapportId id du rapport
	 * @param langueId id de la langue
	 * @throws SQLException
	 */
	public static void associateRapportLangue(BddController bdd, int rapportId, int langueId) throws SQLException{
		String requeteCreate = 
				"INSERT INTO serse.rapport_langue "
				+ "(rapport_id, langue_id) "
				+ "VALUES (?, ?);";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteCreate);
		statement.setInt(1, rapportId);
		statement.setInt(2, langueId);
		statement.execute();
	}
	
	/**
	 * Crée l'association entre l'état 'soumis' et le rapport en base de données
	 * @param bdd contrôleur de base de données
	 * @param rapportId id du rapport
	 * @throws SQLException
	 */
	public static void associateRapportEtat(BddController bdd, int rapportId) throws SQLException{
		String requeteCreate = 
				"INSERT INTO serse.rapport_etat "
				+ "(etat_id, dri_id, rapport_id, rapport_etat_dateheure) "
				+ "VALUES (?, 1, ?, ?);";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteCreate);
		statement.setInt(1, 1);
		statement.setInt(2, rapportId);
		statement.setTimestamp(3, new java.sql.Timestamp(System.currentTimeMillis()));
		statement.execute();
	}
	
	/**
	 * Obtenir l'id du lieu en base de données à partir de la ville, l'entreprise ou l'université, si jon existant, crée le lieu
	 * @param bdd contrôleur de base de données
	 * @param villeId id de la ville
	 * @param adresse libellé de l'adresse
	 * @param codePostal code postal
	 * @param entrepriseId id de l'entreprise (pouvant être égal à -1)
	 * @param universiteId id de l'université (pouvant être égal à -1)
	 * @return id du lieu en base de données (correspondant aux critères ou crée)
	 * @throws SQLException
	 */
	public static int insertLieu(BddController bdd, int villeId, String adresse, String codePostal, int entrepriseId, int universiteId) throws SQLException{
		/* TODO: vérifier qu'un lieu de séjour similaire n'est pas déjà présent (même ville, même université => même lieu séjour) 7
		pas besoin d'en ajouter un nouveau */
		int id = -1;
		String requeteInsert = "INSERT INTO serse.lieuSejour "
			+ "(ville_id, lieuSejour_adresse, lieuSejour_codePostal, "
			+ "lieuSejour_GPSlatitude, lieuSejour_GPSlongitude) "
			+ "VALUES (?, ?, ?, ?, ?) "
			+ "RETURNING lieuSejour_id;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteInsert);
		statement.setInt(1, villeId);
		statement.setString(2, adresse);
		statement.setString(3, codePostal);
		//TODO: insérer les coordonnées GPS
		statement.setInt(4, 0);
		statement.setInt(5, 0);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}

	/**
	 * Insère un rapport en base de données
	 * @param bdd contrôleur de base de données
	 * @param rapportNom nom du rapport (suivant la convention définie dans le cahier des charges)
	 * @param dateDebut date de début du séjour
	 * @param dateFin date de fin du séjour
	 * @param tailleFichier taille du document contenant le rapport
	 * @param mobiliteId id de la mobilité
	 * @param sejourId id du séjour
	 * @param experienceId id de l'expérience
	 * @param lieuId id du lieu de séjour
	 * @param utilisateurId id de l'utilisateur
	 * @param universiteId id de l'université
	 * @param entrepriseId id de l'entreprise
	 * @param domaineId id du domaine d'activité
	 * @return id du rapport crée
	 * @throws SQLException
	 */
	public static int insertRapport(BddController bdd, String rapportNom, java.util.Date dateDebut, java.util.Date dateFin, String tailleFichier, 
			int mobiliteId, int sejourId, int experienceId, int lieuId, int utilisateurId, 
			int universiteId, int entrepriseId, int domaineId) throws SQLException{
		int id = -1;
		String requeteInsert = 
				"INSERT INTO  serse.rapport "
				+ "(rapport_nom, rapport_datedebut, rapport_datefin, rapport_numeroversion, rapport_taillefichier, "
				+ "typemobilite_id, typesejour_id, typeexperience_id, lieusejour_id, utilisateur_id, dri_id, domaineactivite_id, ";	
		if (universiteId!=-1){
			requeteInsert = requeteInsert + "universite_id) ";
		} else if (entrepriseId!=-1){
			requeteInsert = requeteInsert + "entreprise_id) ";
		}
		requeteInsert = requeteInsert + "VALUES (?, ?, ?, 1, ?, ?, ?, ?, ?, ?, 1, ?, ?) RETURNING rapport_id;";
		PreparedStatement statement = bdd.getConnection().prepareStatement(requeteInsert);
		if (universiteId!=-1){
			statement.setInt(11, universiteId);
		} else if (entrepriseId!=-1){
			statement.setInt(11, entrepriseId);
		}
		statement.setString(1, rapportNom);
		statement.setDate(2, new java.sql.Date(dateDebut.getTime()));
		statement.setDate(3, new java.sql.Date(dateFin.getTime()));
		statement.setString(4, tailleFichier);
		statement.setInt(5, mobiliteId);
		statement.setInt(6, sejourId);
		statement.setInt(7, experienceId);
		statement.setInt(8, lieuId);
		statement.setInt(9, utilisateurId);
		statement.setInt(10, domaineId);
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if(resultSet.next()){
				id = resultSet.getInt(1);
			}
		}
		return id;
	}
}