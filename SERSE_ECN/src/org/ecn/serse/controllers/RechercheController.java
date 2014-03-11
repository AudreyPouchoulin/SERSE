/**
 * Project: SERSE_ECN
 * Creation date: 28 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.models.Rapport;

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
		
		// critères de type d'expérience et de mobilité
		if (!(academique && professionnel && CME && STING && TFE && pSemestre && pCesure && aSemestre && aCesure && annee && doubleDiplome)){
			requeteDeBase = requeteDeBase + "LEFT JOIN serse.typeExperience ON serse.rapport.typeExperience_id = serse.typeExperience.typeExperience_id ";
			if (professionnel && CME && STING && TFE && pSemestre && pCesure){ // tous les sous critères de professionnel sont cochés
				listeRequeteCriteres.add("typeexperience_libelle = ? ");
				listeCriteres.add("professionnel");
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
				listeRequeteCriteres.add("typeexperience_libelle = ? ");
				listeCriteresProfessionnelAcademique.add("académique");
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
			listeCriteres.add(continentNom);
		}
		
		String requeteCriteres = "";
		if (listeRequeteCriteres.size()!=0){
			requeteCriteres = "WHERE " + listeRequeteCriteres.get(0);
			for (int i=1; i<listeRequeteCriteres.size(); i++){
				requeteCriteres = requeteCriteres + "AND " + listeRequeteCriteres.get(i);
			}
		}
		
		String requeteCriteresProfessionnel = "";
		if (listeRequeteCriteresProfessionnel.size() !=0){
			if (requeteCriteres ==""){
				requeteCriteresProfessionnel = "WHERE ";
			} else {
				requeteCriteresProfessionnel = "AND ";
			}
			requeteCriteresProfessionnel = requeteCriteresProfessionnel + "(typeexperience_libelle = 'professionnel' AND (" + listeRequeteCriteresProfessionnel.get(0);
			for (int i=1; i<listeRequeteCriteresProfessionnel.size(); i++){
				requeteCriteresProfessionnel = requeteCriteresProfessionnel + "OR " + listeRequeteCriteresProfessionnel.get(i);
			}
			requeteCriteresProfessionnel = requeteCriteresProfessionnel + ")) ";
		}
		
		String requeteCriteresAcademique = "";
		if (listeRequeteCriteresAcademique.size() !=0){
			if (requeteCriteres =="" && requeteCriteresProfessionnel == ""){
				requeteCriteresAcademique = "WHERE ";
			} else {
				requeteCriteresAcademique = "AND ";
			}
			requeteCriteresAcademique = requeteCriteresAcademique + "(typeexperience_libelle = 'académique' AND (" + listeRequeteCriteresProfessionnel.get(0);
			for (int i=1; i<listeRequeteCriteresAcademique.size(); i++){
				requeteCriteresAcademique = requeteCriteresAcademique + "OR " + listeRequeteCriteresAcademique.get(i);
			}
			requeteCriteresAcademique = requeteCriteresAcademique + ")) ";
		}
		
		String requete = requeteDeBase + requeteCriteres + requeteCriteresProfessionnel + requeteCriteresAcademique +  "ORDER BY rapport_nom;";
		// DEBUG
		System.out.println(requeteCriteres + requeteCriteresProfessionnel + requeteCriteresAcademique);
		
		PreparedStatement statement = bdd.getConnection().prepareStatement(requete);
		
		for (int i=0; i<listeCriteres.size(); i++){
			statement.setString(i+1, listeCriteres.get(i));
		}
		// DEBUG
		//System.out.println(listeCriteres.size());
		//System.out.println(listeCriteresProfessionnelAcademique.size());
		for (int j=listeCriteres.size(); j<(listeCriteres.size() + listeCriteresProfessionnelAcademique.size()); j++){
			statement.setString(j+1, listeCriteresProfessionnelAcademique.get(j));
		}
			
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
				listeRapports.add(extraireRapportFromResultSet(resultSet));
			}
		}
		return listeRapports;
	}
	
	
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
				+ "LEFT JOIN serse.entreprise ON serse.rapport.entreprise_id = serse.entreprise.entreprise_id ";
	}
	
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
				resultSet.getDate(2) + " - " + resultSet.getDate(3), 
				resultSet.getString(4),
				resultSet.getString(5),
				universiteEntreprise,
				resultSet.getString(8),
				resultSet.getString(9),
				resultSet.getString(10));
		return rapportTrouve;
	}
}
