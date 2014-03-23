/**
 * Project: SERSE_ECN
 * Author: Clara
 */
package org.ecn.serse.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ecn.serse.exceptions.DatabaseException;

/**
 * @author Audrey + Clara
 *
 */
public class RecherchesRequetesController {

	/** Controleur de base de données */
	protected BddController bdd;
	
	/**
	 * Initialise un controlleur d'options
	 * @param bdd : Base de données à utiliser
	 */
	public RecherchesRequetesController(BddController bdd) {
		this.bdd = bdd;
	}
	
	/**
	 * Permet d'obtenir le nombre de rapports venant d'être mis en lignes
	 * @return integer
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	
	public Integer getNombreRapportsSoumis() throws DatabaseException, SQLException{
		Integer nbreRapport = new Integer(0);
		ResultSet resultSet = bdd.executeRequest(
				"SELECT count(DISTINCT rapport.rapport_id) " +
				"FROM serse.rapport, serse.rapport_etat " +
				"WHERE (serse.rapport.rapport_id=serse.rapport_etat.rapport_id AND rapport_etat.etat_id=1);") ;
		resultSet.next();
		nbreRapport=resultSet.getInt(1);
		return nbreRapport;
	}
	
	/**
	 * Permet d'obtenir le nombre de rapports valides et devant etres mis en lignes
	 * @return integer
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	
	public Integer getNombreRapportsAMettreEnLigne() throws DatabaseException, SQLException{
		Integer nbreRapport = new Integer(0);
		ResultSet resultSet = bdd.executeRequest(
				"SELECT count(DISTINCT rapport.rapport_id) " +
				"FROM serse.rapport, serse.rapport_etat " +
				"WHERE (serse.rapport.rapport_id=serse.rapport_etat.rapport_id AND rapport_etat.etat_id=3);" );
				
		resultSet.next();
		nbreRapport=resultSet.getInt(1);
		return nbreRapport;
	}
	
	
	/**
	 * Permet d'obtenir les rapports à valider
	 * @return integer
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	
	public ArrayList<String> getRapportsAValider() throws DatabaseException, SQLException{
		ArrayList<String> listeRapports = new ArrayList<String>();
		ResultSet resultSet = bdd.executeRequest(	
				"SELECT rapport.rapport_nom, fichier.fichier_dateHeure, pays.pays_nom, etat.etat_libelle, typeExperience.typeExperience_libelle, dri.dri_id "+
				"from serse.rapport, serse.lieuSejour, serse.ville, serse.pays, serse.rapport_etat, serse.etat, serse.fichier, serse.typeExperience, " +
				"serse.dri " +
				"where (rapport.rapport_id=fichier.rapport_id " +
					"AND rapport.lieuSejour_id=lieuSejour.lieuSejour_id " +
					"AND lieuSejour.ville_id=ville.ville_id "+
					"AND ville.pays_id=pays.pays_id "+
					"AND rapport.rapport_id=rapport_etat.rapport_id "+
					"AND rapport_etat.etat_id=etat.etat_id "+
					"AND rapport.typeExperience_id=typeExperience.typeExperience_id "+
					"AND rapport.dri_id=dri.dri_id "+
					"AND etat_libelle='soumis'); ");
		
		while(resultSet.next()){
			listeRapports.add(resultSet.getString(1));
		}	
		return listeRapports;
		
	}

}
