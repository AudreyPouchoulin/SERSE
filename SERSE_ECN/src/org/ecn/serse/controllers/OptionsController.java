/**
 * Project: SERSE_ECN
 * Creation date: 13 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

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

}
