package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.RechercheController;
//
import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.models.Rapport;

import com.google.gson.Gson;
/**
 * Servlet implementation class RechercheServlet
 */
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// Récupération des informations (critères de recherche) envoyées
			String continentNom = request.getParameter("continent");
			String paysNom = request.getParameter("pays");
			String villeNom = request.getParameter("ville");
			boolean universite = Boolean.valueOf(request.getParameter("universite"));
			boolean entreprise = Boolean.valueOf(request.getParameter("entreprise"));
			boolean professionnel = Boolean.valueOf(request.getParameter("professionnel"));
			boolean academique = Boolean.valueOf(request.getParameter("academique"));
			boolean CME = Boolean.valueOf(request.getParameter("CME"));
			boolean STING = Boolean.valueOf(request.getParameter("STING"));
			boolean TFE = Boolean.valueOf(request.getParameter("TFE"));
			boolean semestre = Boolean.valueOf(request.getParameter("semestre"));
			boolean annee = Boolean.valueOf(request.getParameter("annee"));
			boolean cesure = Boolean.valueOf(request.getParameter("cesure"));
			boolean doubleDiplome = Boolean.valueOf(request.getParameter("doubleDiplome"));
			String universiteNom = request.getParameter("universiteNom");
			String entrepriseNom = request.getParameter("entrepriseNom");
			String langueNom = request.getParameter("langueNom");
			String domaineActiviteNom = request.getParameter("domaineActiviteNom");
			String date = request.getParameter("date");

			
		// Recherche des rapports correspondants aux critères
			BddController bddController;
			try {
				bddController = new BddController();
				RechercheController rechercheController = new RechercheController(bddController);
				ArrayList<Rapport> listeRapports = rechercheController.getRapports(continentNom, paysNom, villeNom, 
						universite, entreprise, professionnel, academique, 
						CME, STING, TFE, semestre, annee, cesure, doubleDiplome,
						universiteNom, entrepriseNom, langueNom, domaineActiviteNom, date);
				String jsonResponse = new Gson().toJson(listeRapports);
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(jsonResponse);
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
