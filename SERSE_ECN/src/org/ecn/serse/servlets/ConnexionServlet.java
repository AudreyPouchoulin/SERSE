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

		// Paramètres incomplets
		if(username.isEmpty() || password.isEmpty()) { 
			String message = "Identifiant et/ou mot de passe manquant";
			request.setAttribute( "erreur_information", message );
			// Affichage de l'erreur sur la page de login
			try {
				this.getServletContext().getRequestDispatcher( "/index.jsp").forward( request, response );
			} catch (ServletException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				// Connexion à la base de données de SERSE
				BddController bddController = new BddController();

				// Connexion d'un utilisateur sous LDAP et récupération d'informations
				UtilisateurController utilisateurController = new UtilisateurController(bddController);
				Utilisateur utilisateur = utilisateurController.seConnecter(username, password);
				
				//Connexion réussie
				String prenomNom = utilisateur.getPrenom() + " " + utilisateur.getNom();
				String role = utilisateur.getCategorie().toString();
				String message = "Bienvenue " + prenomNom + ", vous êtes connecté comme " + role + ".";
				request.setAttribute( "message_bienvenue", message);
				
				bddController.close();
				
				// Affichage de la page suivante
				try {
					switch (utilisateur.getCategorie()){
					case ETUDIANT:
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilEtudiants.jsp").forward( request, response );
						break;
					case DRI:
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilDri.jsp").forward( request, response );
						break;
					default:
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilAdmin.jsp").forward( request, response );
						break;
					}
					
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (DatabaseException e) {
				/*message = "Erreur lors de la connexion à la base de données de SERSE : veuillez contacter votre administrateur de service.";
				request.setAttribute( "erreur", message );*/
				String logError = e.getResultCode() + " " + e.getMessage();
				System.out.println(logError);
				e.printStackTrace();
			} catch(IdentificationException e) {
				/*message = "Erreur lors de l'identification.";
				request.setAttribute( "erreur", message );*/
				String logError = e.getResultCode() + " " + e.getMessage();
				System.out.println(logError);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String token = request.getParameter("token_connexion");
			String categorieUtilisateur = request.getParameter("utilisateur");
			if (categorieUtilisateur==null){
				//TODO: erreur
				this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilEtudiants.jsp").forward( request, response );
			} else {
				switch (categorieUtilisateur){
					case "étudiant":
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilEtudiants.jsp").forward( request, response );
						break;
					case "admin":
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilAdmin.jsp").forward( request, response );
						break;
					case "dri":
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilDri.jsp").forward( request, response );
						break;
					case "admin_dri":
						this.getServletContext().getRequestDispatcher( "/WEB-INF/AccueilAdminDri.jsp").forward( request, response );
						break;
					default:
						//TODO: erreur
				}
			}
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
}
