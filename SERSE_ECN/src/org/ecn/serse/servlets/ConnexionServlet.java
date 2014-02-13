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

import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.UtilisateurController;
import org.ecn.serse.exceptions.DatabaseException;
import org.ecn.serse.exceptions.IdentificationException;
import org.ecn.serse.exceptions.ResultCode;
import org.ecn.serse.models.Utilisateur;

/**
 * Servlet de connexion
 * 
 * @author Audrey
 */
public class ConnexionServlet extends HttpServlet {

	private static final long serialVersionUID = -4108350698688202053L;
	
	/**
	 * Connexion d'un utilisateur
	 * @param requête contenant un identifiant et un mot de passe
	 * @param réponse contenant un message d'erreur ou une autorisation de connexion
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// Retour sous forme JSP
			response.setContentType("text/hmtl");
			response.setCharacterEncoding("utf-8");
		
		// Identifiants passés en paramètre
			String username = request.getParameter("username");
			String password = request.getParameter("password");
		
		//Réponse
			String message = "";
			
		
		// Paramètres incomplets
		if(username.isEmpty() && password.isEmpty()) { 
			message = "Nom d'utilisateur et mot de passe manquants";
			request.setAttribute( "erreur", message );
			// ResultCode.WRONG_PARAMETERS_FOR_REQUEST
		} else if (username.isEmpty()){
			message = "Nom d'utilisateur manquant";
			request.setAttribute( "erreur", message );
			// ResultCode.WRONG_PARAMETERS_FOR_REQUEST
		} else if (password.isEmpty()){
			message = "Mot de passe manquant";
			request.setAttribute( "erreur", message );
			// ResultCode.WRONG_PARAMETERS_FOR_REQUEST
		}
		else {
			
			ResultCode result;
			
			try {
				// Connexion à la base de données de SERSE
				BddController bddController = new BddController();

				// Connexion d'un utilisateur sous LDAP et récupération d'informations
				UtilisateurController utilisateurController = new UtilisateurController(bddController);
				Utilisateur utilisateur = utilisateurController.seConnecter(username, password);
				result = ResultCode.SUCCESS;
				message = "Connexion reussie, bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom();
				request.setAttribute( "erreur", message );
				
				bddController.close();
			} catch (DatabaseException e) {
				message = "Erreur lors de la connexion à la base de données de SERSE : veuillez contacter votre administrateur de service.";
				request.setAttribute( "erreur", message );
				String logError = e.getResultCode() + " " + e.getMessage();
				System.out.println(logError);
				e.printStackTrace();
			} catch(IdentificationException e) {
				message = "Erreur lors de l'identification.";
				request.setAttribute( "erreur", message );
				String logError = e.getResultCode() + " " + e.getMessage();
				System.out.println(logError);
				e.printStackTrace();
			}
		}
		
		// Génération de la page suivante
		try {
			this.getServletContext().getRequestDispatcher( "/WEB-INF/accueil.jsp").forward( request, response );
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
