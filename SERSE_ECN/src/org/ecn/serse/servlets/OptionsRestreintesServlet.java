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
 * Servlet implementation class OptionsRestreintesServlet
 */
public class OptionsRestreintesServlet extends HttpServlet {
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
			String continent = request.getParameter("continent");
			String pays = request.getParameter("pays");
			String ville = request.getParameter("ville");
			switch (nomListe){
				case "pays":
					ArrayList<String> listePays = optionsController.getPaysByContinent(continent);
					ServletUtil.sendOptions(listePays, messageDefaut, response);
					break;
				case "ville":
					ArrayList<String> listeVilles = new ArrayList<String>();
					if (pays!=null){
						listeVilles = optionsController.getVillesByPays(pays);
					} else {
						listeVilles = optionsController.getVillesByContinent(continent);
					}
					ServletUtil.sendOptions(listeVilles, messageDefaut, response);
					break;
				case "université":
					ArrayList<String> listeUniversites = new ArrayList<String>();
					if (ville!=null){
						listeUniversites = optionsController.getUniversitesByVille(ville);
					} else if (pays!=null){
						listeUniversites = optionsController.getUniversitesByPays(pays);
					} else {
						listeUniversites = optionsController.getUniversitesByContinent(continent);
					}
					ServletUtil.sendOptions(listeUniversites, null, response);
					break;
				case "entreprise":
					ArrayList<String> listeEntreprises = new ArrayList<String>();
					if (ville!=null){
						listeEntreprises = optionsController.getEntreprisesByVille(ville);
					} else if (pays!=null){
						listeEntreprises = optionsController.getEntreprisesByPays(pays);
					} else {
						listeEntreprises = optionsController.getEntreprisesByContinent(continent);
					}
					ServletUtil.sendOptions(listeEntreprises, null, response);
					break;
				default:
					Map<String, String> erreur = new LinkedHashMap<String, String>();
					erreur.put("erreur", "Problem when calling for updating the lists");
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
}
