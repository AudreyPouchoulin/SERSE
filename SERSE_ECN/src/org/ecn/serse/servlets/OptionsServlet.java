
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
 * Servlet implementation class ContinentServlet
 */
public class OptionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connexion à la base de données de SERSE
		BddController bddController;
		try {
			bddController = new BddController();
			OptionsController optionsController = new OptionsController(bddController);
			String nomListe = request.getParameter("nom_liste");
			String messageDefaut = request.getParameter("message_defaut");
			switch (nomListe){
				case "continent":
					ArrayList<String> continents = optionsController.getContinents();
					ServletUtil.sendOptions(continents, messageDefaut, response);
					break;
				case "pays":
					ArrayList<String> pays = optionsController.getPays();
					ServletUtil.sendOptions(pays, messageDefaut, response);
					break;
				case "ville":
					ArrayList<String> villes = optionsController.getVilles();
					ServletUtil.sendOptions(villes, messageDefaut, response);
					break;
				case "université":
					ArrayList<String> universites = optionsController.getUniversites();
					ServletUtil.sendOptions(universites, null, response);
					break;
				case "entreprise":
					ArrayList<String> entreprises = optionsController.getEntreprises();
					ServletUtil.sendOptions(entreprises, null, response);
					break;
				case "domaine":
					ArrayList<String> domainesActivite = optionsController.getDomainesActivite();
					ServletUtil.sendOptions(domainesActivite, messageDefaut, response);
					break;
				case "langue":
					ArrayList<String> langues = optionsController.getLangues();
					ServletUtil.sendOptions(langues, messageDefaut, response);
					break;
				case "sejour":
					ArrayList<String> sejours = optionsController.getSejours();
					ServletUtil.sendOptions(sejours, messageDefaut, response);
					break;
				case "mobilite":
					ArrayList<String> mobilites = optionsController.getMobilites();
					ServletUtil.sendOptions(mobilites, messageDefaut, response);
					break;
				case "experience":
					ArrayList<String> experiences = optionsController.getExperiences();
					ServletUtil.sendOptions(experiences, messageDefaut, response);
					break;
				default:
					ServletUtil.sendNoOption("Problem when calling for updating the lists", messageDefaut, response);
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
