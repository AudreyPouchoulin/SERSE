package org.ecn.serse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheServlet
 */
public class RechercheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retour sous forme JSP
			response.setContentType("text/hmtl");
			response.setCharacterEncoding("utf-8");
				
		// Informations passées en paramètre
			String continent = request.getParameter("continent");
			String pays = request.getParameter("pays");
			String ville = request.getParameter("ville");
			// ... TODO complete
			
		// Recherche des rapports correspondants aux critères
			//TODO
	}

}
