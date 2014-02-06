/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */

package org.ecn.serse.servlets;

import java.io.IOException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ecn.serse.json.ResponseController;
import org.ecn.serse.models.Utilisateur;
import org.ecn.serse.controllers.BddController;
import org.ecn.serse.controllers.UtilisateurController;
import org.ecn.serse.exceptions.IdentificationException;
import org.ecn.serse.exceptions.ResultCode;
import org.ecn.serse.exceptions.SerseException;

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// Retour sous forme JSON
			resp.setContentType("application/json");
			resp.setCharacterEncoding("utf-8");
		
		// Identifiants passés en paramètre
			String username = req.getParameter("username");
			String password = req.getParameter("password");
		
		//Réponse
			String reponse;
		
		// Paramètres incomplets
		if(username == null && password == null) { 
			reponse = ResponseController.generateResponse(ResultCode.WRONG_PARAMETERS_FOR_REQUEST, "Nom d'utilisateur et mot de passe manquant", null);
		} else if (username == null){
			reponse = ResponseController.generateResponse(ResultCode.WRONG_PARAMETERS_FOR_REQUEST, "Nom d'utilisateur manquant", null);
		} else if (password == null){
			reponse = ResponseController.generateResponse(ResultCode.WRONG_PARAMETERS_FOR_REQUEST, "Mot de passe manquant", null);
		}
		else {
			
			ResultCode result;
			
			try {
				BddController bddController = new BddController();
				UtilisateurController utilisateurController = new UtilisateurController(bddController);
				
				Utilisateur utilisateur = utilisateurController.seConnecter(username, password);
				result = ResultCode.SUCCESS;
				
				bddController.close();
				
				JsonObject data = Json.createObjectBuilder()
						.add("token", utilisateur.getToken())
						.add("userId", utilisateur.getId())
						.build();
				
				reponse = ResponseController.generateResponse(result, "", data);
			} catch(IdentificationException e) {
				reponse = ResponseController.generateResponse(e.getResultCode(), e.getMessage(), null);
			} catch (SerseException e) {
				reponse = ResponseController.generateResponse(e.getResultCode(), e.getMessage(), null);
			}
		}
		
		resp.getWriter().print(reponse);
	}
}
