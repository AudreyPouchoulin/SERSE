
/**
 * Project: SERSE_ECN
 * Creation date: 13 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ecn.serse.exceptions.DatabaseException;

/**
 * @author Audrey
 *
 */
public class OptionsController {
	
	/** Controleur de base de données */
	protected BddController bdd;
	
	/**
	 * Initialise un controlleur d'options
	 * @param bdd : Base de données à utiliser
	 */
	public OptionsController(BddController bdd) {
		this.bdd = bdd;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des continents possibles
	 * @return liste de continents en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getContinents() throws DatabaseException, SQLException{
		ArrayList<String> listeContinents = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT continent_nom "
				+ "FROM serse.continent "
				+ "ORDER BY continent_nom;");
	
		while(resultSet.next()){
			listeContinents.add(resultSet.getString(1));
		}	
		return listeContinents;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des pays possibles
	 * @return liste de pays en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getPays() throws DatabaseException, SQLException{
		ArrayList<String> listePays = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT pays_nom "
				+ "FROM serse.pays "
				+ "ORDER BY pays_nom;");
		while(resultSet.next()){
			listePays.add(resultSet.getString(1));
		}
		return listePays;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des pays possibles dans un continent donné
	 * @param continentNom nom du continent
	 * @return liste de pays dans le continent
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getPaysByContinent(String continentNom) throws DatabaseException, SQLException{
		ArrayList<String> listePays = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT pays_nom "
				+ "FROM serse.pays "
				+ "INNER JOIN serse.continent ON serse.continent.continent_id = serse.pays.continent_id "
				+ "WHERE continent_nom=? "
				+ "ORDER BY pays_nom;");
		statement.setString(1, continentNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listePays.add(resultSet.getString(1));
			}
		}
		return listePays;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des villes possibles
	 * @return liste de villes en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getVilles() throws DatabaseException, SQLException{
		ArrayList<String> listeVilles = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT ville_nom "
				+ "FROM serse.ville "
				+ "ORDER BY ville_nom;");
		while(resultSet.next()){
			listeVilles.add(resultSet.getString(1));
		}
		return listeVilles;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des villes dans un continent donné
	 * @param continentNom nom du continent
	 * @return liste de villes dans le continent
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getVillesByContinent(String continentNom) throws DatabaseException, SQLException{
		ArrayList<String> listeVilles = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT ville_nom "
				+ "FROM serse.ville "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.ville.pays_id "
				+ "INNER JOIN serse.continent ON serse.continent.continent_id = serse.pays.continent_id "
				+ "WHERE continent_nom=? "
				+ "ORDER BY ville_nom;");
		statement.setString(1, continentNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeVilles.add(resultSet.getString(1));
			}
		}
		return listeVilles;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des villes dans un pays donné
	 * @param PaysNom nom du pays
	 * @return liste de villes dans le pays
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getVillesByPays(String paysNom) throws DatabaseException, SQLException{
		ArrayList<String> listeVilles = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT ville_nom "
				+ "FROM serse.ville "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.ville.pays_id "
				+ "WHERE pays_nom=? "
				+ "ORDER BY ville_nom;");
		statement.setString(1, paysNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeVilles.add(resultSet.getString(1));
			}
		}
		return listeVilles;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des universites possibles
	 * @return liste d'universités en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getUniversites() throws DatabaseException, SQLException{
		ArrayList<String> listeUniversites = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT universite_nom "
				+ "FROM serse.universite "
				+ "ORDER BY universite_nom;");
		while(resultSet.next()){
			listeUniversites.add(resultSet.getString(1));
		}
		return listeUniversites;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des universités dans un continent
	 * @param continentNom nom du continent
	 * @return liste d'universités dans le continent
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getUniversitesByContinent(String continentNom) throws DatabaseException, SQLException{
		ArrayList<String> listeUniversites = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT universite_nom "
				+ "FROM serse.universite "
				+ "INNER JOIN serse.ville ON serse.ville.ville_id = serse.universite.ville_id "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.ville.pays_id "
				+ "INNER JOIN serse.continent ON serse.continent.continent_id = serse.pays.continent_id "
				+ "WHERE continent_nom=?"
				+ "ORDER BY universite_nom;");
		statement.setString(1, continentNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeUniversites.add(resultSet.getString(1));
			}
		}
		return listeUniversites;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des universités dans un pays
	 * @param paysNom nom du pays
	 * @return liste d'universités dans le pays
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getUniversitesByPays(String paysNom) throws DatabaseException, SQLException{
		ArrayList<String> listeUniversites = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT universite_nom "
				+ "FROM serse.universite "
				+ "INNER JOIN serse.ville ON serse.ville.ville_id = serse.universite.ville_id "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.ville.pays_id "
				+ "WHERE pays_nom=?"
				+ "ORDER BY universite_nom;");
		statement.setString(1, paysNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeUniversites.add(resultSet.getString(1));
			}
		}
		return listeUniversites;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des universités dans une ville
	 * @param villeNom nom de la ville
	 * @return liste d'universités dans la ville
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getUniversitesByVille(String villeNom) throws DatabaseException, SQLException{
		ArrayList<String> listeUniversites = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT universite_nom "
				+ "FROM serse.universite "
				+ "INNER JOIN serse.ville ON serse.ville.ville_id = serse.universite.ville_id "
				+ "WHERE ville_nom=?"
				+ "ORDER BY universite_nom;");
		statement.setString(1, villeNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeUniversites.add(resultSet.getString(1));
			}
		}
		return listeUniversites;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des entreprises possibles
	 * @return liste des entreprises en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getEntreprises() throws DatabaseException, SQLException{
		ArrayList<String> listeEntreprises = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT entreprise_nom "
				+ "FROM serse.entreprise "
				+ "ORDER BY entreprise_nom;");
		while(resultSet.next()){
			listeEntreprises.add(resultSet.getString(1));
		}
		return listeEntreprises;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des entreprises dans un continent
	 * @param continentNom nom du continent
	 * @return liste d'entreprises dans le continent
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getEntreprisesByContinent(String continentNom) throws DatabaseException, SQLException{
		ArrayList<String> listeEntreprises = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT entreprise_nom "
				+ "FROM serse.entreprise "
				+ "INNER JOIN serse.entreprise_pays ON serse.entreprise_pays.entreprise_id = serse.entreprise.entreprise_id "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.entreprise_pays.pays_id "
				+ "INNER JOIN serse.continent ON serse.continent.continent_id = serse.pays.continent_id "
				+ "WHERE continent_nom=?"
				+ "ORDER BY entreprise_nom;");
		statement.setString(1, continentNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeEntreprises.add(resultSet.getString(1));
			}
		}
		return listeEntreprises;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des entreprises dans un pays
	 * @param paysNom nom du pays
	 * @return liste d'entreprises dans le pays
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getEntreprisesByPays(String paysNom) throws DatabaseException, SQLException{
		ArrayList<String> listeEntreprises = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT entreprise_nom "
				+ "FROM serse.entreprise "
				+ "INNER JOIN serse.entreprise_pays ON serse.entreprise_pays.entreprise_id = serse.entreprise.entreprise_id "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.entreprise_pays.pays_id "
				+ "WHERE pays_nom=?"
				+ "ORDER BY entreprise_nom;");
		statement.setString(1, paysNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeEntreprises.add(resultSet.getString(1));
			}
		}
		return listeEntreprises;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des entreprises dans une ville
	 * @param villeNom nom de la ville
	 * @return liste d'entreprises dans la ville
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getEntreprisesByVille(String villeNom) throws DatabaseException, SQLException{
		ArrayList<String> listeEntreprises = new ArrayList<String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT entreprise_nom "
				+ "FROM serse.entreprise "
				+ "INNER JOIN serse.entreprise_pays ON serse.entreprise_pays.entreprise_id = serse.entreprise.entreprise_id "
				+ "INNER JOIN serse.pays ON serse.pays.pays_id = serse.entreprise_pays.pays_id "
				+ "INNER JOIN serse.ville ON serse.ville.pays_id = serse.pays.pays_id "
				+ "WHERE ville_nom=?"
				+ "ORDER BY entreprise_nom;");
		statement.setString(1, villeNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeEntreprises.add(resultSet.getString(1));
			}
		}
		return listeEntreprises;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des domaines d'activité possibles
	 * @return liste de domaines d'activité en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getDomainesActivite() throws DatabaseException, SQLException{
		ArrayList<String> listeDomainesActivite = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT domaineactivite_libelle "
				+ "FROM serse.domaineactivite "
				+ "ORDER BY domaineactivite_libelle;");
		while(resultSet.next()){
			listeDomainesActivite.add(resultSet.getString(1));
		}
		return listeDomainesActivite;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des langues possibles
	 * @return liste de langues en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getLangues() throws DatabaseException, SQLException{
		ArrayList<String> listeLangues = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT langue_nom "
				+ "FROM serse.langue "
				+ "ORDER BY langue_nom;");
		while(resultSet.next()){
			listeLangues.add(resultSet.getString(1));
		}
		return listeLangues;
	}

	/**
	 * Permet d'obtenir l'ensemble des séjours possibles
	 * @return liste de séjours en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getSejours() throws DatabaseException, SQLException{
		ArrayList<String> listeSejours = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT typesejour_libelle "
				+ "FROM serse.typesejour "
				+ "ORDER BY typesejour_libelle;");
		while(resultSet.next()){
			listeSejours.add(resultSet.getString(1));
		}
		return listeSejours;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des mobilités possibles
	 * @return liste de mobilités en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getMobilites() throws DatabaseException, SQLException{
		ArrayList<String> listeMobilites = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT typemobilite_libelle "
				+ "FROM serse.typemobilite "
				+ "ORDER BY typemobilite_libelle;");
		while(resultSet.next()){
			listeMobilites.add(resultSet.getString(1));
		}
		return listeMobilites;
	}
	
	/**
	 * Permet d'obtenir l'ensemble des expériences possibles
	 * @return liste des expériences en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getExperiences() throws DatabaseException, SQLException{
		ArrayList<String> listeExperiences = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT typeexperience_libelle "
				+ "FROM serse.typeexperience "
				+ "ORDER BY typeexperience_libelle;");
		while(resultSet.next()){
			listeExperiences.add(resultSet.getString(1));
		}
		return listeExperiences;
	}
}
