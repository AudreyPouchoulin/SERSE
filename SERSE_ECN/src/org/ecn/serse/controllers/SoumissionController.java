/**
 * Project: SERSE_ECN
 * Creation date: 18 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
			try {
				// TODO récupérer taille du fichier
				String tailleFichier = "2 Go";
				int utilisateurId = BddUtil.getUserId(bdd, nom, prenom);
				int continentId = BddUtil.getContinentId(bdd, ville);
				int paysId = BddUtil.getPaysId(bdd, pays, true, continentId);
				int villeId = BddUtil.getVilleId(bdd, ville, true, paysId);
				int sejourId = BddUtil.getSejourId(bdd, sejour);
				int mobiliteId = BddUtil.getMobiliteId(bdd, mobilite);
				int experienceId = BddUtil.getExperienceId(bdd, experience);
				int universiteId = -1;
				int entrepriseId = -1;
				if (universite!=""){
					universiteId = BddUtil.getUniversiteId(bdd, universite, true, villeId);
				}
				if (entreprise!=""){
					entrepriseId = BddUtil.getEntrepriseId(bdd, entreprise, true);
					BddUtil.associateEntreprisePays(bdd, entrepriseId, paysId);
				}
				int langueId = BddUtil.getLangueId(bdd, langue, true);
				int domaineId = BddUtil.getDomaineId(bdd, domaine, true);
				int lieuId = BddUtil.insertLieu(bdd, villeId, adresse, codePostal, entrepriseId, universiteId);
				
				GregorianCalendar calendar = new GregorianCalendar();
				calendar.setTime(dateDebut);
				String annee =  Integer.toString(calendar.get(Calendar.YEAR));
				String rapportNom = pays + "_" + mobilite + "_" + domaine + "_" + annee + "_" + prenom.substring(0,1) + nom.substring(0,7);
				int rapportId = BddUtil.insertRapport(bdd, rapportNom, dateDebut, dateFin, tailleFichier, 
						mobiliteId, sejourId, experienceId, lieuId, utilisateurId, 
						universiteId, entrepriseId, domaineId);
				BddUtil.associateRapportLangue(bdd, rapportId, langueId);
				BddUtil.associateRapportEtat(bdd, rapportId);
			} catch (Exception e){
				e.printStackTrace();
				soumissionAccomplie = false;
				return soumissionAccomplie;
			}
			return soumissionAccomplie;
	}

}
