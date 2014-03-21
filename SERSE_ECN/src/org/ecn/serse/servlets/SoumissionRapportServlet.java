package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.SoumissionController;
import org.ecn.serse.exceptions.DatabaseException;

import com.google.gson.Gson;

/**
 * Servlet de dépôt d'un rapport en base de données
 */
public class SoumissionRapportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode post de la servlet de dépôt d'un rapport en base de données
	 * @param request requête contenant des données au format JSON: 
	 * {'Nom':'x', 'Prenom':'x', 'DateDebut':'x', 'DateFin':'x',
	 * 'Continent':'x', 'Pays':'x', 'Ville':'x', 
	 * 'Sejour':'x', 'Mobilite':'x', 'Experience':'x',
	 * 'Universite':'x', 'Entreprise':'x',
	 * 'Langue':'x', 'Domaine':'x', 'Adresse'}
	 * @param response réponse contenant la confirmation que le rapport a été enregistré ou une information sur une erreur interne au serveur
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nom = request.getParameter("Nom");
			String prenom = request.getParameter("Prenom");
			
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
			//String codePostal = request.getParameter("CodePostal");
			String codePostal = "notdone";

			try {
				BddController bddController = new BddController();
				SoumissionController soumissionController = new SoumissionController(bddController);
				boolean isSoumis = soumissionController.soumettreRapport(
						nom, prenom, 
						dateDebut, dateFin, 
						continent, pays, ville, 
						sejour, mobilite, experience, 
						universite, entreprise, 
						langue, domaine, adresse, codePostal);
				String jsonResponse = new Gson().toJson(isSoumis);
				response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(jsonResponse);
			    bddController.close();
			} catch (DatabaseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}