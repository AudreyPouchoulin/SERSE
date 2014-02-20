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
	 * Permet d'obtenir l'ensemble des pays possibles
	 * @return liste de pays en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getVilles() throws DatabaseException, SQLException{
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
	 * Permet d'obtenir l'ensemble des pays possibles
	 * @return liste de pays en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getUniversites() throws DatabaseException, SQLException{
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
	 * Permet d'obtenir l'ensemble des pays possibles
	 * @return liste de pays en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getDomainesActivite() throws DatabaseException, SQLException{
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
	 * Permet d'obtenir l'ensemble des pays possibles
	 * @return liste de pays en base de données
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getLangues() throws DatabaseException, SQLException{
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

}
