/**
 * Project: SERSE_ECN
 * Creation date: 20 fev. 2014
 * Author: Audrey
 */

package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.OptionsController;
import org.ecn.serse.exceptions.DatabaseException;

/**
 * Servlet pour l'actualisation des listes d'options en fonctions des valeurs choisies dans d'autres listes d'options
 */
public class OptionsRestreintesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode post de la servlet d'actualisation du contenu de listes en fonction de la valeur d'autres listes
	 * @param request requête contenant des données au format JSON: 
	 * {'nom_liste':'x', 'message_defaut':'x', 'continent':'x'}
	 * ou {'nom_liste':'x', 'message_defaut':'x', 'pays':'x'}
	 * ou {'nom_liste':'x', 'message_defaut':'x', 'ville':'x'}
	 * @param response réponse les options des la liste
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connexion à la base de données de SERSE
		BddController bddController;
		try {
			bddController = new BddController();
			OptionsController optionsController = new OptionsController(bddController);
			String nomListe = request.getParameter("nom_liste");
			String messageDefaut = request.getParameter("message_defaut");
			String continent = request.getParameter("continent");
			String pays = request.getParameter("pays");
			String ville = request.getParameter("ville");
			switch (nomListe){
				case "pays":
					updatePays(optionsController, continent, messageDefaut, response);
					break;
				case "ville":
					updateVille(optionsController, pays, continent, messageDefaut, response);
					break;
				case "universite":
					updateUniversite(optionsController, ville, pays, continent, response);
					break;
				case "entreprise":
					updateEntreprise(optionsController, ville, pays, continent, response);
					break;
				default:
					ServletUtil.sendNoOption("Problem when calling for updating the lists", messageDefaut, response);
			}
			bddController.close();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Envoie au client de la liste de pays en fonction du continent, liste de pays obtenue à partir d'une reqiête en base de données
	 * @param optionsController contrôleur contenant la méthode permettant d'obtenir les pays en base de données dans ce continent
	 * @param continent nom du continent
	 * @param messageDefaut message défaut pour la liste de pays
	 * @param response
	 * @throws DatabaseException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void updatePays(OptionsController optionsController, String continent, String messageDefaut, HttpServletResponse response) throws DatabaseException, SQLException, IOException{
		ArrayList<String> listePays = optionsController.getPaysByContinent(continent);
		if (listePays.size()==0){
			ServletUtil.sendNoOption("Pas de pays dans ce continent", messageDefaut, response);
		} else {
			ServletUtil.sendOptions(listePays, messageDefaut, response);
		}
	}
	
	/**
	 * Envoie au client de la liste de ville en fonction du continent ou du pays, liste de villes obtenue à partir d'une reqiête en base de données
	 * @param optionsController contrôleur contenant la méthode permettant d'obtenir les villes en base de données présentes dans ce continent ou ce pays
	 * @param pays	nom du pays
	 * @param continent nom du continent
	 * @param messageDefaut message défaut pour la liste de ville
	 * @param response
	 * @throws DatabaseException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void updateVille(OptionsController optionsController, String pays, String continent, String messageDefaut, HttpServletResponse response) throws DatabaseException, SQLException, IOException{
		ArrayList<String> listeVilles = new ArrayList<String>();
		if (pays!=null){
			listeVilles = optionsController.getVillesByPays(pays);
		} else if (continent!=null){
			listeVilles = optionsController.getVillesByContinent(continent);
		}
		if (listeVilles.size()==0){
			if (pays!=null){
				ServletUtil.sendNoOption("Pas de ville dans ce pays", messageDefaut, response);
			} else {
				ServletUtil.sendNoOption("Pas de ville dans ce continent", messageDefaut, response);
			}
		} else {
			ServletUtil.sendOptions(listeVilles, messageDefaut, response);
		}
	}
	
	/**
	 * Envoie au client de la liste d'universités en fonction du continent, du pays ou de la ville, 
	 * liste d'universités obtenue à partir d'une reqiête en base de données
	 * @param optionsController contrôleur contenant la méthode permettant d'obtenir les universités en base de données présentes dans ce continent, ce pays ou cette ville
	 * @param ville nom de la ville
	 * @param pays nom du pays
	 * @param continent nom du continent
	 * @param response
	 * @throws DatabaseException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void updateUniversite(OptionsController optionsController, String ville, String pays, String continent, HttpServletResponse response) throws DatabaseException, SQLException, IOException{
		ArrayList<String> listeUniversites = new ArrayList<String>();
		if (ville!=null){
			listeUniversites = optionsController.getUniversitesByVille(ville);
		} else if (pays!=null){
			listeUniversites = optionsController.getUniversitesByPays(pays);
		} else {
			listeUniversites = optionsController.getUniversitesByContinent(continent);
		}
		if (listeUniversites.size()==0){
			if (ville!=null){
				ServletUtil.sendNoOption("Pas d'université dans cette ville", null, response);
			} else if (pays!=null){
				ServletUtil.sendNoOption("Pas d'université dans ce pays", null, response);
			} else {
				ServletUtil.sendNoOption("Pas d'université dans ce continent", null, response);
			}
		} else {
			ServletUtil.sendOptions(listeUniversites, null, response);
		}	
	}
	
	/**
	 * Envoie au client de la liste d'entreprises en fonction du continent, du paus ou de la ville, 
	 * liste d'entreprises obtenue à partir d'une reqiête en base de données
	 * @param optionsController contrôleur contenant la méthode permettant d'obtenir les entreprises en base de données présentes dans ce continent ou ce pays
	 * @param ville nom de la ville
	 * @param pays nom du pays
	 * @param continent nom du continent
	 * @param response
	 * @throws DatabaseException
	 * @throws SQLException
	 * @throws IOException
	 */
	private void updateEntreprise(OptionsController optionsController, String ville, String pays, String continent, HttpServletResponse response) throws DatabaseException, SQLException, IOException{
		ArrayList<String> listeEntreprises = new ArrayList<String>();
		if (ville!=null){
			listeEntreprises = optionsController.getEntreprisesByVille(ville);
		} else if (pays!=null){
			listeEntreprises = optionsController.getEntreprisesByPays(pays);
		} else {
			listeEntreprises = optionsController.getEntreprisesByContinent(continent);
		}
		if (listeEntreprises.size()==0){
			if (ville!=null){
				ServletUtil.sendNoOption("Pas d'entreprise dans cette ville", null, response);
			} else if (pays!=null){
				ServletUtil.sendNoOption("Pas d'entreprise dans ce pays", null, response);
			} else {
				ServletUtil.sendNoOption("Pas d'entreprise dans ce continent", null, response);
			}
		} else {
			ServletUtil.sendOptions(listeEntreprises, null, response);
		}	
	}
}