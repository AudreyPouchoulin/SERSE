package org.ecn.serse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccueilAdminServlet extends HttpServlet {
	
public void doGet( HttpServletRequest request, HttpServletResponse response )   throws ServletException, IOException {
		
		Integer nbrOptionsValider = 3; // nombre d'option a valider
		
		request.setAttribute( "nbrOptionsValider", nbrOptionsValider);
		this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilAdmin.jsp" ).forward( request, response );
	}

}
