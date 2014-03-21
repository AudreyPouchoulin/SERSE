/**
 * Project: SERSE_ECN
 * Creation date: 15 mars 2014
 * Author: Audrey
 */

package org.ecn.serse.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet d'accès à la page permettant de remplir un formulaire pour déposer un rapport
 */
public class SoumissionFormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/SoumissionRapport.jsp").forward( request, response );
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
