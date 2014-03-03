/**
 * Project: SERSE_ECN
 * Creation date: 28 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	public Map<String, String> getRapports(String continentNom, String paysNom, String villeNom, 
			boolean universite, boolean entreprise, boolean professionnel, boolean academique, 
			boolean CME, boolean STING, boolean TFE, boolean semestre, boolean annee, boolean cesure, boolean doubleDiplome,
			String universiteNom, String entrepriseNom, String langueNom, String domaineActiviteNom, String date) 
					throws DatabaseException, SQLException{
		Map<String, String> listeRapports = new HashMap<String, String>();
		PreparedStatement statement = bdd.getConnection().prepareStatement(
				"SELECT rapport_nom, rapport_datedebut, rapport_datefin, pays_nom, ville_nom, domaineActivite_libelle, typeMobilite_libelle, langue_nom "
				+ "FROM serse.rapport "
				+ "LEFT JOIN serse.lieuSejour ON serse.rapport.lieuSejour_id = serse.lieuSejour.lieuSejour_id "
				+ "LEFT JOIN serse.ville ON serse.lieuSejour.ville_id = serse.ville.ville_id "
				+ "LEFT JOIN serse.pays ON serse.ville.pays_id = serse.pays.pays_id "
				+ "LEFT JOIN serse.continent ON serse.pays.continent_id = serse.continent.continent_id "
				+ "LEFT JOIN serse.domaineActivite ON serse.rapport.domaineActivite_id = serse.domaineActivite.domaineActivite_id "
				+ "LEFT JOIN serse.typeExperience ON serse.rapport.typeExperience_id = serse.typeExperience.typeExperience_id "
				+ "LEFT JOIN serse.typeMobilite ON serse.rapport.typeMobilite_id = serse.typeMobilite.typeMobilite_id "
				+ "LEFT JOIN serse.typeSejour ON serse.rapport.typeSejour_id = serse.typeSejour.typeSejour_id "
				+ "LEFT JOIN serse.rapport_langue ON serse.rapport.rapport_id = serse.rapport_langue.rapport_id "
				+ "LEFT JOIN serse.langue ON serse.rapport_langue.langue_id = serse.langue.langue_id "
				+ "LEFT JOIN serse.universite ON serse.rapport.universite_id = serse.universite.universite_id "
				+ "LEFT JOIN serse.entreprise ON serse.rapport.entreprise_id = serse.entreprise.entreprise_id "
				+ "WHERE continent_nom = ? "
				+ "ORDER BY rapport_nom;");
		// 				+ "AND pays_nom = ? + "AND ville_nom = ?"
	
		statement.setString(1, continentNom);
		
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			if (!resultSet.next()){
				listeRapports.put("rapport_nom", "pas de résultats correspondants aux critères");
			}
			while(resultSet.next()){
				listeRapports.put("rapport_nom", resultSet.getString(1));
			}	
			
		}
		
		return listeRapports;
	}
}
