/**
 * Project: SERSE_ECN
 * Creation date: 18 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.ecn.serse.exceptions.DatabaseException;

/**
 * @author Audrey
 *
 */
public class SoumissionController {
	/** Controleur de base de données */
	protected BddController bdd;
	
	/**
	 * Initialise un controlleur d'options
	 * @param bdd : Base de données à utiliser
	 */
	public SoumissionController(BddController bdd) {
		this.bdd = bdd;
	}
	
	public boolean soumettreRapport(String nom, String prenom, String sexe, 
			Date dateDebut, Date dateFin, 
			String continent, String pays, String ville, 
			String sejour, String mobilite, String experience, 
			String universite, String entreprise, 
			String langue, String domaine, String adresse, String codePostal) throws DatabaseException, SQLException{
		boolean soumissionAccomplie = true;
		
		// création d'un nouveau lieu de séjour
			/* TODO: vérifier qu'un lieu de séjour similaire n'est pas déjà présent (même ville, même université => même lieu séjour) 7
				pas besoin d'en ajouter un nouveau */
			int villeId = getVilleId(ville);
			creerLieu(villeId, adresse, codePostal);
		
		// création d'une nouvelle association entreprise-pays si nécessaire
			if (entreprise !=""){
				if(!isEntrepriseInPays(entreprise, pays)){
					// TODO creerLienEntreprisePays();
				}
			}
			
		// création d'un nouveau rapport
		
		
		// création d'une nouvelle association rapport-langue
		
				return soumissionAccomplie;

	}
	
	private boolean isEntrepriseInPays(String entreprise, String pays){
		//TODO
		boolean lienExistant = false ;
		return lienExistant;
		
	}
	private void creerLieu(int villeId, String adresse, String codePostal) throws SQLException{
		String requeteInsertLieu = "INSERT INTO  serse.lieuSejour "
				+ "(ville_id, lieuSejour_adresse, lieuSejour_codePostal, "
				+ "lieuSejour_GPSlatitude, lieuSejour_GPSlongitude) "
				+ "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement statementInsertLieu = bdd.getConnection().prepareStatement(requeteInsertLieu);
			statementInsertLieu.setInt(1, villeId);
			statementInsertLieu.setString(2, adresse);
			statementInsertLieu.setString(3, codePostal);
			
			//TODO: insérer les coordonnées GPS
			statementInsertLieu.setInt(4, 0);
			statementInsertLieu.setInt(5, 0);
			statementInsertLieu.execute();
	}
	
	private int getVilleId(String ville) throws SQLException{
		int villeId = -1;
		String requeteVilleId = "SELECT ville_id "
				+ "FROM serse.ville "
				+ "WHERE ville_nom = ?";
		PreparedStatement statementVille = bdd.getConnection().prepareStatement(requeteVilleId);
		statementVille.setString(1, ville);
		if (statementVille.execute()){
			ResultSet resultSet = statementVille.getResultSet();
			villeId = resultSet.getInt(1);
		}
		return villeId;
	}
	

}
