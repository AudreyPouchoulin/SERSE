package org.ecn.serse.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MesRapportsServlet
 */
public class MesRapportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/MesRapportsEtudiants.jsp").forward( request, response );
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
