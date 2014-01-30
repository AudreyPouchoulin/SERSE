///**
// * Project: SERSE_ECN
// * Creation date: 30 janv. 2014
// * Author: Audrey
// */
//
//package org.ecn.serse.servlets;
//
//import java.io.IOException;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Servlet de connexion
// * 
// * @author Audrey
// */
//public class ConnexionServlet extends HttpServlet {
//
//	private static final long serialVersionUID = -4108350698688202053L;
//	
//	/**
//	 * Connection d'un utilisateur
//	 */
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		
//		// Retour sous forme JSON
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("utf-8");
//		
//		// Identifiants passés en paramètre
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		
//		String reponse;
//		
//		if(username == null || password == null) { // Paramètres incomplets
//			reponse = ResponseManager.generateResponse(ResultCode.WRONG_PARAMETERS_FOR_REQUEST, "Nom d'utilisateur ou mot de passe manquant", null);
//		}
//		else {
//			
//			ResultCode result;
//			
//			try {
//				BddController bddGestion = new BddController();
//				UtilisateurGestion utilisateurGestion = new UtilisateurGestion(bddGestion);
//				
//				ObjetRetourMethodeConnexion retourConnexion = utilisateurGestion.seConnecter(username, password);
//				result = ResultCode.SUCCESS;
//				
//				bddGestion.close();
//				
//				JsonObject data = Json.createObjectBuilder()
//						.add("token", retourConnexion.getToken())
//						.add("userId", retourConnexion.getUserId())
//						.add("actionsAutorisees", JSONUtils.getJsonIntArray(retourConnexion.getActionsAutorisees()))
//						.build();
//				
//				reponse = ResponseManager.generateResponse(result, "", data);
//			} catch(IdentificationErrorException e) {
//				reponse = ResponseManager.generateResponse(e.getResultCode(), e.getMessage(), null);
//				logger.error("Erreur lors de l'identification d'un utilisateur", e);
//			} catch(IdentificationException e) {
//				reponse = ResponseManager.generateResponse(e.getResultCode(), e.getMessage(), null);
//				logger.debug("Token d'identification invalide ou expiré pour un utilisateur, code : " + e.getMessage(), e);
//			} catch (SerseException e) {
//				reponse = ResponseManager.generateResponse(e.getResultCode(), e.getMessage(), null);
//				logger.error("Erreur lors de la vérification de la connexion d'un utilisateur", e);
//			}
//		}
//		
//		resp.getWriter().print(reponse);
//	}
//}
