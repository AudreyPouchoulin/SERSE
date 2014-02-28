/**
 * Project: SERSE_ECN
 * Creation date: 28 févr. 2014
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
public class RechercheController {

	/** Controleur de base de données */
	protected BddController bdd;
	
	/**
	 * Initialise un controlleur d'options
	 * @param bdd : Base de données à utiliser
	 */
	public RechercheController(BddController bdd) {
		this.bdd = bdd;
	}
	
	/**
	 * Permet d'obtenir les rapports correspondants aux critères de recherche
	 * @return liste de rapports
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<String> getRapports(String continentNom, String paysNom, String villeNom, 
			boolean universite, boolean entreprise, boolean professionnel, boolean academique, 
			boolean CME, boolean STING, boolean TFE, boolean semestre, boolean annee, boolean cesure, boolean doubleDiplome,
			String universiteNom, String entrepriseNom, String langueNom, String domaineActiviteNom, String date) throws DatabaseException, SQLException{
		ArrayList<String> listeRapports = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(
				"SELECT rapport_nom "
				+ "FROM serse.rapport "
				+ "ORDER BY rapport_nom;");
	
		while(resultSet.next()){
			listeRapports.add(resultSet.getString(1));
		}	
		return listeRapports;
	}
}
