package org.ecn.serse.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.OptionsController;
import org.ecn.serse.exceptions.DatabaseException;

/**
 * Servlet implementation class ContinentServlet
 */
public class ContinentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Connexion à la base de données de SERSE
		BddController bddController;
		try {
			bddController = new BddController();
			OptionsController optionsController = new OptionsController(bddController);
			ArrayList<String> continents = optionsController.getContinents();
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
