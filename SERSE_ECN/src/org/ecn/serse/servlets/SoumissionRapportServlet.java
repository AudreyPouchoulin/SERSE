package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.RechercheController;
import org.ecn.serse.controllers.SoumissionController;
import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.models.Rapport;

import com.google.gson.Gson;

/**
 * Servlet implementation class SoumissionRapportServlet
 */
public class SoumissionRapportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations du rapport à enregistrer
			String nom = request.getParameter("Nom");
			String prenom = request.getParameter("Prenom");
			String sexe = request.getParameter("Sexe");
			
			Date dateDebut = new Date();
			Date dateFin = new Date();
			String dateDebutString = request.getParameter("DateDebut");
			String dateFinString = request.getParameter("DateFin");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			try {
				dateDebut = formatter.parse(dateDebutString);
				dateFin = formatter.parse(dateFinString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String continent = request.getParameter("Continent");
			String pays = request.getParameter("Pays");
			String ville = request.getParameter("Ville");
			String sejour = request.getParameter("Sejour");
			String mobilite = request.getParameter("Mobilite");
			String experience = request.getParameter("Experience");
			String universite = request.getParameter("Universite");
			String entreprise = request.getParameter("Entreprise");
			String langue = request.getParameter("Langue");
			String domaine = request.getParameter("Domaine");
			String adresse = request.getParameter("Adresse");
			
			// TODO: récupérer le code postal à partir de l'adresse
			String codePostal = "notdone";
			//String codePostal = request.getParameter("CodePostal");
			
			String fichier = request.getParameter("CheminFichier");
			
			BddController bddController;
			try {
				bddController = new BddController();
				SoumissionController soumissionController = new SoumissionController(bddController);
				boolean isSoumis = soumissionController.soumettreRapport(
						nom, prenom, sexe, 
						dateDebut, dateFin, 
						continent, pays, ville, 
						sejour, mobilite, experience, 
						universite, entreprise, 
						langue, domaine, adresse, codePostal);
				String jsonResponse = new Gson().toJson(isSoumis);
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
