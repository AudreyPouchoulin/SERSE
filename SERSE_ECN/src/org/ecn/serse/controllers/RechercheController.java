/**
 * Project: SERSE_ECN
 * Creation date: 28 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.models.Rapport;

/**
 * Classes pour chercher les rapports en base de données
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
	 * * Permet d'obtenir les rapports correspondants aux critères de recherche
	 * @param continentNom
	 * @param paysNom
	 * @param villeNom
	 * @param universite
	 * @param entreprise
	 * @param professionnel
	 * @param academique
	 * @param CME
	 * @param STING
	 * @param TFE
	 * @param pSemestre
	 * @param pCesure
	 * @param aSemestre
	 * @param aCesure
	 * @param doubleDiplome
	 * @param annee
	 * @param universiteNom
	 * @param entrepriseNom
	 * @param langueNom
	 * @param domaineActiviteNom
	 * @param date
	 * @return liste de rapports
	 * @throws DatabaseException
	 * @throws SQLException
	 */
	public ArrayList<Rapport> getRapports(String continentNom, String paysNom, String villeNom, 
			boolean universite, boolean entreprise, boolean professionnel, boolean academique, 
			boolean CME, boolean STING, boolean TFE, boolean pSemestre,  boolean pCesure,
			boolean aSemestre,  boolean aCesure, boolean doubleDiplome, boolean annee,
			String universiteNom, String entrepriseNom, String langueNom, String domaineActiviteNom, String date) 
					throws DatabaseException, SQLException{
		
		ArrayList<Rapport> listeRapports = new ArrayList<Rapport>();
		
		ArrayList<String> listeRequeteCriteres = new ArrayList<String>();
		ArrayList<String> listeRequeteCriteresProfessionnel = new ArrayList<String>();
		ArrayList<String> listeRequeteCriteresAcademique = new ArrayList<String>();
		
		ArrayList<String> listeCriteres = new ArrayList<String>();
		ArrayList<String> listeCriteresProfessionnelAcademique = new ArrayList<String>();
		
		String requeteDeBase = getRequeteDeBase();
		
		// critères de géographie
		if(villeNom !=""){
			listeRequeteCriteres. add("ville_nom = ? ");
			listeCriteres.add(villeNom);
		} else if(paysNom !=""){
			listeRequeteCriteres. add("pays_nom = ? ");
			listeCriteres.add(paysNom);
		} else if(continentNom !=""){
			requeteDeBase = requeteDeBase + "LEFT JOIN serse.continent ON serse.pays.continent_id = serse.continent.continent_id ";
			listeRequeteCriteres.add("continent_nom = ? ");
			listeCriteres.add(continentNom);
		}
		
		// critères de type de séjour
		if (!(universite && entreprise)){
			requeteDeBase = requeteDeBase + "LEFT JOIN serse.typeSejour ON serse.rapport.typeSejour_id = serse.typeSejour.typeSejour_id ";
			if (universite){
				listeRequeteCriteres.add("typesejour_libelle = ? ");
				listeCriteres.add("université");
			}
			if (entreprise){
				listeRequeteCriteres.add("typesejour_libelle = ? ");
				listeCriteres.add("entreprise");
			}
		}
		
		boolean isTousCriteresProfessionnels = false;
		boolean isTousCriteresAcademiques = false;
		// critères de type d'expérience et de mobilité
		if (!(academique && professionnel && CME && STING && TFE && pSemestre && pCesure && aSemestre && aCesure && annee && doubleDiplome)){
			requeteDeBase = requeteDeBase + "LEFT JOIN serse.typeExperience ON serse.rapport.typeExperience_id = serse.typeExperience.typeExperience_id ";
			if (professionnel && CME && STING && TFE && pSemestre && pCesure){ // tous les sous critères de professionnel sont cochés
				isTousCriteresProfessionnels = true;
			} else if (professionnel && !(CME && STING && TFE && pSemestre && pCesure)){
				if (CME){
					listeRequeteCriteresProfessionnel.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("CME");
				}
				if (STING){
					listeRequeteCriteresProfessionnel.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("STING");
				}
				if (TFE){
					listeRequeteCriteresProfessionnel.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("TFE");
				}
				if (pCesure){
					listeRequeteCriteresProfessionnel.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Césure");
				}
				if (pSemestre){
					listeRequeteCriteresProfessionnel.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Semestre");
				}
			}
			if (academique && aSemestre && aCesure && annee && doubleDiplome){ // tous les sous critères de académique sont cochés
				isTousCriteresAcademiques = true ;
			} else if (academique && !(aSemestre && aCesure && annee && doubleDiplome)){
				if (aCesure){
					listeRequeteCriteresAcademique.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Césure");
				}
				if (aSemestre){
					listeRequeteCriteresAcademique.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Semestre");
				}
				if (annee){
					listeRequeteCriteresAcademique.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Année");
				}
				if (doubleDiplome){
					listeRequeteCriteresAcademique.add("typemobilite_libelle = ? ");
					listeCriteresProfessionnelAcademique.add("Double diplôme");
				}
			}
		}
		
		// critères de nom d'université ou entreprise
		if(universiteNom != null){
			listeRequeteCriteres.add("universite_nom = ? ");
			listeCriteres.add(universiteNom);
		} else if(entrepriseNom != null){
			listeRequeteCriteres.add("entreprise_nom = ? ");
			listeCriteres.add(entrepriseNom);
		}
		
		// critères de langue et domaine
		if(langueNom !=""){
			listeRequeteCriteres.add("langue_nom = ? ");
			listeCriteres.add(langueNom);
		}
		if(domaineActiviteNom !=""){
			listeRequeteCriteres.add("domaineactivite_libelle = ? ");
			listeCriteres.add(domaineActiviteNom);
		}
		
		// critere de date
		if(date != ""){
			listeRequeteCriteres.add("rapport_datedebut > '01-01-" + date + "' ");
		}
		
		String requeteCriteres = "WHERE rapport_etat.etat_id = 4 ";
		if (listeRequeteCriteres.size()!=0){
			for (int i=0; i<listeRequeteCriteres.size(); i++){
				requeteCriteres = requeteCriteres + "AND " + listeRequeteCriteres.get(i);
			}
		}
		
		String requeteCriteresProfessionnelEtAcademique = "";
		if (isTousCriteresProfessionnels){
			requeteCriteresProfessionnelEtAcademique = "AND (typeexperience_libelle = 'professionnelle') ";
		} else if (listeRequeteCriteresProfessionnel.size() !=0){
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "AND (typeexperience_libelle = 'professionnelle' AND (" + listeRequeteCriteresProfessionnel.get(0);
			for (int i=1; i<listeRequeteCriteresProfessionnel.size(); i++){
				requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "OR " + listeRequeteCriteresProfessionnel.get(i);
			}
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "))";
		}
		if (isTousCriteresAcademiques){
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + beginWithAndOrOr(requeteCriteresProfessionnelEtAcademique);
			requeteCriteresProfessionnelEtAcademique =  requeteCriteresProfessionnelEtAcademique + "(typeexperience_libelle = 'académique') ";
		} else if (listeRequeteCriteresAcademique.size() !=0){
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + beginWithAndOrOr(requeteCriteresProfessionnelEtAcademique);
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "(typeexperience_libelle = 'académique' AND (" + listeRequeteCriteresAcademique.get(0);
			for (int i=1; i<listeRequeteCriteresAcademique.size(); i++){
				requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "OR " + listeRequeteCriteresAcademique.get(i);
			}
			requeteCriteresProfessionnelEtAcademique = requeteCriteresProfessionnelEtAcademique + "))";
		}
		
		String requete = requeteDeBase + requeteCriteres + requeteCriteresProfessionnelEtAcademique +  "ORDER BY rapport_nom;";
		// DEBUG
		/*System.out.println(requeteCriteres + requeteCriteresProfessionnelEtAcademique);*/
		
		PreparedStatement statement = bdd.getConnection().prepareStatement(requete);
		
		for (int i=0; i<listeCriteres.size(); i++){
			statement.setString(i+1, listeCriteres.get(i));
		}
		for (int j=0; j<listeCriteresProfessionnelAcademique.size(); j++){
			statement.setString(listeCriteres.size()+1+j, listeCriteresProfessionnelAcademique.get(j));
		}
			
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeRapports.add(extraireRapportFromResultSet(resultSet));
			}
		}
		return listeRapports;
	}
	
	/**
	 * Construction de la requête de base (jonction des tables)
	 * @return requête de base
	 */
	private String getRequeteDeBase(){
		return "SELECT rapport_nom, rapport_datedebut, rapport_datefin, pays_nom, ville_nom, universite_nom, entreprise_nom, domaineActivite_libelle, typeMobilite_libelle, langue_nom "
				+ "FROM serse.rapport "
				+ "LEFT JOIN serse.lieuSejour ON serse.rapport.lieuSejour_id = serse.lieuSejour.lieuSejour_id "
				+ "LEFT JOIN serse.ville ON serse.lieuSejour.ville_id = serse.ville.ville_id "
				+ "LEFT JOIN serse.pays ON serse.ville.pays_id = serse.pays.pays_id "
				+ "LEFT JOIN serse.domaineActivite ON serse.rapport.domaineActivite_id = serse.domaineActivite.domaineActivite_id "
				+ "LEFT JOIN serse.typeMobilite ON serse.rapport.typeMobilite_id = serse.typeMobilite.typeMobilite_id "
				+ "LEFT JOIN serse.rapport_langue ON serse.rapport.rapport_id = serse.rapport_langue.rapport_id "
				+ "LEFT JOIN serse.langue ON serse.rapport_langue.langue_id = serse.langue.langue_id "
				+ "LEFT JOIN serse.universite ON serse.rapport.universite_id = serse.universite.universite_id "
				+ "LEFT JOIN serse.entreprise ON serse.rapport.entreprise_id = serse.entreprise.entreprise_id "
				+ "INNER JOIN serse.rapport_etat ON serse.rapport_etat.rapport_id = serse.rapport.rapport_id "
				+ "INNER JOIN serse.etat ON serse.etat.etat_id = serse.rapport_etat.etat_id ";
	}
	
	/**
	 * Crée un rapport à partir d'un Result Set d'excutuion de la requête en base de données
	 * @param resultSet résultat de l'exécution de la requête en base de données
	 * @return un rapport
	 * @throws SQLException
	 */
	private Rapport extraireRapportFromResultSet(ResultSet resultSet) throws SQLException{
		String universiteEntreprise;
		if (resultSet.getString(6)==null && resultSet.getString(7)==null){
			universiteEntreprise = null;
		} else if (resultSet.getString(6)==null){
			universiteEntreprise = resultSet.getString(7);
		} else {
			universiteEntreprise = resultSet.getString(6);
		}
		Rapport rapportTrouve = new Rapport(
				resultSet.getString(1), 
				getPeriod(resultSet), 
				resultSet.getString(4),
				resultSet.getString(5),
				universiteEntreprise,
				resultSet.getString(8),
				resultSet.getString(9),
				resultSet.getString(10));
		return rapportTrouve;
	}
	
	/**
	 * Renvoie 'Or' or 'And' en fonction du contenu de la requête précédente (vide ou non)
	 * @param requeteCriteresOr requete à tester (vide ou non)
	 * @return Début de requête avec 'Or' or 'And'
	 */
	private String beginWithAndOrOr(String requeteCriteresOr){
		String suiteRequeteCriteres ="";
		if (requeteCriteresOr == "") {
			suiteRequeteCriteres = "AND ";
		} else {
			suiteRequeteCriteres = "OR ";
		}
		return suiteRequeteCriteres;
	}
	
	/**
	 * Crée la période à enregistrer avec le rapport à partir des daates 
	 * contenues dans le Result Set de l'exécution de la requête en base de données
	 * @param resultSet résultat de l'exécution de la requête en base de données
	 * @return période de temps (entre deux année ou une seule année)
	 * @throws SQLException
	 */
	private String getPeriod(ResultSet resultSet) throws SQLException{
		String year;
		Date date1 = resultSet.getDate(2);
		Date date2 = resultSet.getDate(3);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date1);
		String year1 =  Integer.toString(calendar.get(Calendar.YEAR));
		calendar.setTime(date2);
		String year2 =  Integer.toString(calendar.get(Calendar.YEAR));
		if (year1.equals(year2)){
			year = year1;
		} else {
			year = year1 + " - " + year2;
		}
		return year;
	}
}

