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
	private boolean isPremierCritere;
	
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
			boolean CME, boolean STING, boolean TFE, boolean semestre, boolean annee, boolean cesure, boolean doubleDiplome,
			String universiteNom, String entrepriseNom, String langueNom, String domaineActiviteNom, String date) 
					throws DatabaseException, SQLException{
		ArrayList<Rapport> listeRapports = new ArrayList<Rapport>();
		ArrayList<String> listeCriteres= new ArrayList<String>();
		this.isPremierCritere = true;
		String requete = "SELECT rapport_nom, rapport_datedebut, rapport_datefin, pays_nom, ville_nom, universite_nom, entreprise_nom, domaineActivite_libelle, typeMobilite_libelle, langue_nom "
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
				+ "LEFT JOIN serse.entreprise ON serse.rapport.entreprise_id = serse.entreprise.entreprise_id ";
		
		if(continentNom !=""){
			requete = addCritereRechercheToRequete("continent_nom = ? ", requete);
			listeCriteres.add(continentNom);
		}
		requete = requete +  "ORDER BY rapport_nom;";
		
		PreparedStatement statement = bdd.getConnection().prepareStatement(requete);
		for (int i=0; i<listeCriteres.size(); i++){
			statement.setString(i+1, listeCriteres.get(i));
		}
			
		if (statement.execute()){
			ResultSet resultSet = statement.getResultSet();
			while(resultSet.next()){
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
				listeRapports.add(rapportTrouve);
			}
		}
		return listeRapports;
	}
	
	private String addCritereRechercheToRequete(String nouvelleRestriction, String requete){
		if (this.isPremierCritere){
			this.isPremierCritere = false;
			requete = requete + "WHERE " + nouvelleRestriction;
		} else {
			requete = requete + "AND " + nouvelleRestriction;
		}
		return requete;
	}
}
