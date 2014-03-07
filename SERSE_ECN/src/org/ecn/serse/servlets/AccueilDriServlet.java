package org.ecn.serse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccueilDriServlet extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		
		Integer nbrRapportsValider = 3; // nombre de rapports a valider
		Integer nbrRapportsLigne = 5; // nombre de rapports � mettre en ligne
		
		request.setAttribute( "nbrRapportsValider", nbrRapportsValider);
		request.setAttribute( "nbrRapportsLigne", nbrRapportsLigne);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilDri.jsp" ).forward( request, response );
	}
	
}