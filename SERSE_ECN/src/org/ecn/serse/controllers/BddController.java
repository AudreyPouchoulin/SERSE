/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */

package org.ecn.serse.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ecn.serse.controllers.ConfigurationController.SerseConfiguration;
import org.ecn.serse.exceptions.DatabaseException;

/**
 * Classe d'outils pour se connecter à la base de données et exécuter des requêtes
 * @author Audrey
 */
public class BddController {
	
	/** Interface de connexion à la base de données */
	private Connection _connection;
	
	/**
	 * Méthode de connexion à la base de données
	 * @return le connecteur
	 * @throws DatabaseException
	 */
	private static Connection connect() throws DatabaseException {
		Connection connection;
		try {
			// Chargement du driver
			Class.forName("org.postgresql.Driver");
			
			// Obtention des configurations pour la connexion
			String url = ConfigurationController.getConfiguration(SerseConfiguration.PGSQL_JDBC_URL);
			String user = ConfigurationController.getConfiguration(SerseConfiguration.PGSQL_USER);
			String passwd = ConfigurationController.getConfiguration(SerseConfiguration.PGSQL_PASS);
			System.out.println(url + " " + user + " " + passwd);
				
			// Connexion à la base de données
			connection = DriverManager.getConnection(url, user, passwd);
		} catch (Exception e) {
			throw new DatabaseException(e);
		}
		return connection;
	}
	
	/**
	 * Constructeur principale. Effectue une connection à la base de données
	 * @throws DatabaseException
	 */
	public BddController() throws DatabaseException {
		_connection = connect();
	}
	
	/**
	 * Fermeture de la connexion associée à cet objet
	 */
	public boolean close() {
		try {
			_connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	/**
	 * Démarre une transaction avec la connection associée à cet objet BddGestion 
	 * @throws DatabaseException
	 */
	public void startTransaction() throws DatabaseException {
		try {
			_connection.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	
	/**
	 * Commit une transaction associée à la connection de cet objet BddGestion
	 * @throws DatabaseException
	 */
	public void commit() throws DatabaseException {
		try {
			_connection.commit();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}
	
	
	/**
	 * Rollback une transaction associée à la connection de cet objet BddGestion
	 * @throws DatabaseException 
	 */
	public void rollback() throws DatabaseException {
		try {
			_connection.rollback();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
	}

	
	/**
	 * Récupération de l'objet Connection pour des usages plus avancées
	 * (requêtes préparées avec paramètres par exemple)
	 * 
	 * Ne PAS fermer cette connexion si le manager est encore utilisé ensuite
	 * @return Objet connection sur lequel est basé ce gestionnaire
	 */
	public Connection getConnection() {
		return _connection;
	}
	
	
	/**
	 * Exécuter une requête SQL
	 * @param request Requête à effectuer
	 * @return le résultat de la requête ou NULL si la requête ne renvoie rien ou si la requete est vide
	 * @throws DatabaseException
	 */
	public ResultSet executeRequest(String request) throws DatabaseException {

		ResultSet resultat = null;

		if (!request.isEmpty()) {
			try {

				// Préparation de la requête
				PreparedStatement requetePreparee = _connection.prepareStatement(request);
				
				// Exécute la requête et récupère le résultat s'il y en a un
				if (requetePreparee.execute()) {
					resultat = requetePreparee.getResultSet();
				}
			} catch (SQLException e) {
				throw new DatabaseException(e);
			}
		}

		return resultat;
	}

	
	/**
	 * Exécution d'une requête SQL de type INSERT ou UPDATE, indique le nombre de lignes insérées/mises à jour
	 * @param request Requête à exécuter
	 * @return Nombre de lignes mises à jour/insérées, 0 si la requête ne retourne rien, -1 si la requête est vide
	 * @throws DatabaseException 
	 */
	public int executeUpdate(String request) throws DatabaseException  {
		int count = -1;

		if (!request.isEmpty()) {
			try {

				// Préparation de la requête
				PreparedStatement requetePreparee = _connection.prepareStatement(request);

				// Exécute la requête et récupère le résultat s'il y en a un
				count = requetePreparee.executeUpdate();

			} catch (SQLException e) {
				throw new DatabaseException(e);
			}
		}

		return count;
	}


	
	/**
	 * Récupérer l'ID (contenu dans la colonne <nomColonne>) d'une ligne spécifique d'une table
	 * @param requete : requête préparée à effectuer, devant retourner une et une seule ligne 
	 * @param nomColonne : nom de la colonne contenant l'id
	 * @return id : id de la ligne cherchée ou -1 si le résultat n'existe pas / n'est pas unique
	 * @throws DatabaseException
	 */
	public int recupererId(PreparedStatement request, String nomColonne) throws DatabaseException {
		
		ArrayList<Integer> ids = recupererIds(request, nomColonne);
		
		if(ids.size() != 1) {
			return -1;
		}
		else {
			return ids.get(0);
		}
	}
	
	
	/**
	 * Récupération des IDs (contenus dans la colonne <nomColonne>) des éléments retournés par une requête
	 * @param request Requête préparée à effectuer
	 * @param nomColonne Colonne à examiner pour les IDs
	 * @return Liste des IDs trouvés
	 * @throws DatabaseException
	 */
	public ArrayList<Integer> recupererIds(PreparedStatement request, String nomColonne) throws DatabaseException {
		
		ArrayList<Integer> lstIds = new ArrayList<Integer>();
		
		try {
			// Execution requete de récupération de la ligne cherchée
			ResultSet resultat = request.executeQuery();
			// Parcourt du resultat
			while(resultat.next()){
				 lstIds.add(resultat.getInt(nomColonne));
			}
			
			resultat.close();
			
		} catch (SQLException e) {
			throw new DatabaseException(e);
		}
		
		return lstIds;
	}

}