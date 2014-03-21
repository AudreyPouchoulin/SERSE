/**
 * Project: SERSE_ECN
 * Creation date: 1 fev. 2014
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
import org.ecn.serse.controllers.RechercheController;
//
import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.models.Rapport;

import com.google.gson.Gson;
/**
 * Servlet de recherche de rappports 
 */
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Méthode post de la servlet de recherche de rapports
	 * @param request requête contenant des données au format JSON: 
	 * {'continent':'x', 'pays':'x', 'ville':'x', 'universite':'x', 'entreprise':'x', professionnel':'x', 'academique':'x'
	 * 'CME:'x', 'STING':'x', 'TFE':'x', 'pSemestre':'x', 'pCesure':'x', 
	 * 'aSemestre':'x', 'aCesure':'x', 'annee':'x', 'doubleDiplome':'x', 
	 * 'universiteNom':'x', 'entrepriseNom':'x', 'langue':'x', 'domaineActivite':'x', 'date:'x'}
	 * @param response réponse contenant la liste de rapports correspondants aux critères
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			boolean pSemestre = Boolean.valueOf(request.getParameter("pSemestre"));
			boolean pCesure = Boolean.valueOf(request.getParameter("pCesure"));
			boolean aSemestre = Boolean.valueOf(request.getParameter("aSemestre"));
			boolean aCesure = Boolean.valueOf(request.getParameter("aCesure"));
			boolean annee = Boolean.valueOf(request.getParameter("annee"));
			boolean doubleDiplome = Boolean.valueOf(request.getParameter("doubleDiplome"));
			String universiteNom = request.getParameter("universiteNom");
			String entrepriseNom = request.getParameter("entrepriseNom");
			String langueNom = request.getParameter("langue");
			String domaineActiviteNom = request.getParameter("domaineActivite");
			String date = request.getParameter("date");

			try {
				BddController bddController = new BddController();
				RechercheController rechercheController = new RechercheController(bddController);
				ArrayList<Rapport> listeRapports = rechercheController.getRapports(continentNom, paysNom, villeNom, 
						universite, entreprise, professionnel, academique, 
						CME, STING, TFE, pSemestre, pCesure,
						aSemestre, aCesure, doubleDiplome, annee,
						universiteNom, entrepriseNom, langueNom, domaineActiviteNom, date);
				String jsonResponse = new Gson().toJson(listeRapports);
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