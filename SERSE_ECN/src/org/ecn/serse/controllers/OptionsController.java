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
				+ "FROM serse.continent;");
		
		int i = 0;
		while(resultSet.next()){
			listeContinents.add(resultSet.getString(i));
			i++;
		}
		
		return listeContinents;
		
	}

}
