/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */

package org.ecn.serse.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.ecn.serse.controllers.BddController;
//import org.ecn.serse.controllers.UtilisateurController;

/**
 * Servlet pour accéder à la la page de recherche de rapports existants
 */
public class AccesRapportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO: add v�rification connexion
		
		// Connexion � la base de donn�es de SERSE
		/*BddController bddController = new BddController();
		UtilisateurController utilisateurController = new UtilisateurController(bddController);
		int idUtilisateur = utilisateurController.verifierConnexion(token);*/
		
		try {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/AccesRapport.jsp").forward( request, response );
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
