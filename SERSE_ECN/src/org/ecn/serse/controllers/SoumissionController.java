/**
 * Project: SERSE_ECN
 * Creation date: 18 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.SQLException;
import java.text.Normalizer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.ecn.serse.exceptions.DatabaseException;
/**
 * Classe pour déposer un rapport dans la base de données
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
	
	/**
	 * Enregistre un nouveau rapport en base de données
	 * @param nom nom de l'utilisateur déposant le rapport
	 * @param prenom prénom de l'utilisateur déposant le rapport
	 * @param dateDebut date de début du séjour
	 * @param dateFin date de fin du séjour
	 * @param continent nom du continent de séjour
	 * @param pays nom du pays de séjour
	 * @param ville nom de la ville de séjour
	 * @param sejour type de séjour (entreprise, université)
	 * @param mobilite type de mobilité (STING, Césure, ...)
	 * @param experience type d'expérience (académique, professionnelle)
	 * @param universite nom de l'université (peut-être vide)
	 * @param entreprise nom de l'entreprise (peut-être vide)
	 * @param langue langue parlée pendant le séjour
	 * @param domaine domaine d'activité du séjour
	 * @param adresse adresse de l'netreprise ou de l'université de séjour
	 * @param codePostal code postale de l'université ou de l'entreprise de séjour
	 * @return true si le rapport a été soumis avec succès, false sinon
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public boolean soumettreRapport(String nom, String prenom,
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
				
				String rapportNom = makeNomRapport(pays, mobilite, domaine, dateDebut, prenom, nom);
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
	
	/**
	 * Crée le nom du rapport à partir des informations utiles
	 * @param pays nom du pays
	 * @param mobilite type de mobilité: CME, STING, ...
	 * @param domaine domaine d'activité
	 * @param dateDebut date de début de sjéour à l'étranger
	 * @param prenom prénom de la personne déposant le rapport
	 * @param nom nom de la personne déposant le rapport
	 * @return nom du rapport sans accents
	 */
	private String makeNomRapport(String pays, String mobilite, String domaine, Date dateDebut, String prenom, String nom){
		mobilite = mobilite.replace(" ", "");
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDebut);
		String annee =  Integer.toString(calendar.get(Calendar.YEAR));
		String nomRapport = pays + "_" + mobilite + "_" + domaine + "_" + annee + "_" + prenom.substring(0,1).toLowerCase() + nom.substring(0,7).toLowerCase();
		nomRapport = Normalizer.normalize(nomRapport, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return nomRapport;
	}

}
