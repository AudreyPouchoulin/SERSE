/**
 * Project: SERSE_ECN
 * Creation date: 4 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Classes contenant des méthodes utilitaires pour envoyer les réponses au format JSon au client
 * @author Audrey
 *
 */
public class ServletUtil {
	
	/**
	 * Envoie une liste d'options pour insérer dans un select
	 * @param listeObjets liste d'éléments à mettre au format JSON pour envoie
	 * @param messageDefaut message défaut pour le liste d'options
	 * @param response réponse à envoyer au client
	 * @throws IOException
	 */
	public static void sendOptions(ArrayList<String> listeObjets, String messageDefaut, HttpServletResponse response) throws IOException  {
		Map<String, String> listeOptions = new LinkedHashMap<>();
		if (messageDefaut!=null){
			listeOptions.put("defaut", messageDefaut);
		}
		for (int i=0; i<listeObjets.size(); i++){
			listeOptions.put(listeObjets.get(i), listeObjets.get(i));
		}
		
		String jsonResponse = new Gson().toJson(listeOptions);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse);
	}
	
	/**
	 * Envoie une liste d'options pour insérer dans un select (cas ou la liste d'options est vide, envoyer une option informant de l'absence de résultats)
	 * @param messageNoOption message comme quoi il n'y a pas eu de résultats correspondants aux critèrespour cette liste
	 * @param messageDefaut message défaut pour le liste d'options
	 * @param response réponse à envoyer au client
	 * @throws IOException
	 */
	public static void sendNoOption(String messageNoOption, String messageDefaut, HttpServletResponse response) throws IOException  {
		Map<String, String> listeOptions = new LinkedHashMap<>();
		if (messageDefaut!=null){
			listeOptions.put("defaut", messageDefaut);
		}
		listeOptions.put("noOption", messageNoOption);
		
		String jsonResponse = new Gson().toJson(listeOptions);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse);
	}

}
