package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.OptionsController;
import org.ecn.serse.exceptions.DatabaseException;

import com.google.gson.Gson;

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
			switch (nomListe){
				case "continent":
					ArrayList<String> continents = optionsController.getContinents();
					sendOptions(continents, "Tous les continents", response);
					break;
				case "pays":
					ArrayList<String> pays = optionsController.getPays();
					sendOptions(pays, "Tous les pays", response);
					break;
				case "ville":
					ArrayList<String> villes = optionsController.getVilles();
					sendOptions(villes, "Toutes les villes", response);
					break;
				case "université":
					ArrayList<String> universites = optionsController.getUniversites();
					sendOptions(universites, null, response);
					break;
				case "entreprise":
					ArrayList<String> entreprises = optionsController.getEntreprises();
					sendOptions(entreprises, null, response);
					break;
				case "domaine":
					ArrayList<String> domainesActivite = optionsController.getDomainesActivite();
					sendOptions(domainesActivite, "Tous les domaines d'activité", response);
					break;
				case "langue":
					ArrayList<String> langues = optionsController.getLangues();
					sendOptions(langues, "Toutes les langues", response);
					break;
				default:
					Map<String, String> erreur = new LinkedHashMap<String, String>();
					erreur.put(Integer.toString(1), "Problem when calling for filling the lists");
					String jsonResponse = new Gson().toJson(erreur);
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    response.getWriter().write(jsonResponse);
					
			}
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void sendOptions(ArrayList<String> listeObjets, String messageDefaut, HttpServletResponse response) throws IOException  {
		Map<String, String> listeOptions = new LinkedHashMap<>();
		if (messageDefaut==null){
			for (int i=0; i<listeObjets.size(); i++){
				listeOptions.put(Integer.toString(i), listeObjets.get(i));
			}
		} else {
			listeOptions.put(Integer.toString(0), messageDefaut);
			for (int i=0; i<listeObjets.size(); i++){
				listeOptions.put(Integer.toString(i+1), listeObjets.get(i));
			}
		}
		
		String jsonResponse = new Gson().toJson(listeOptions);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse);
	}

}
