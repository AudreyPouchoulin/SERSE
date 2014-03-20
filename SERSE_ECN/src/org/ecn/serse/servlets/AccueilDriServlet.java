package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.RechercheController;
import org.ecn.serse.controllers.RecherchesRequetesController;
import org.ecn.serse.exceptions.DatabaseException;

public class AccueilDriServlet extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
	
		Integer nbrRapportsValider = 10; // nombre de rapports a valider
		Integer nbrRapportsLigne = 10; // nombre de rapports à mettre en ligne
		BddController bddController;
		try {
			bddController = new BddController();
			RecherchesRequetesController rechercheController = new RecherchesRequetesController(bddController);
			nbrRapportsValider = rechercheController.getNombreRapportsSoumis();
			nbrRapportsLigne = rechercheController.getNombreRapportsAMettreEnLigne();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute( "nbrRapportsValider", nbrRapportsValider);
		request.setAttribute( "nbrRapportsLigne", nbrRapportsLigne);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilDri.jsp" ).forward( request, response );
		
		// Recherche du nombre de rapports soumis en attente de validation

	}
	
}
