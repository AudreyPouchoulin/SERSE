/**
 * Project: SERSE_ECN
 * Creation date: 6 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

import org.ecn.serse.exceptions.ResultCode;

/**
 * Classe permettant de générer des réponses JSON à partir d'objets à transmettre
 * @author Audrey
 */
public class ResponseController {

	/**
	 * Génération d'une réponse sous forme de texte à partir des éléments nécessaires 
	 * @param repCode: code de réponse à la requête
	 * @param message: message à indiquer, souvent une chaîne vide si pas d'erreur
	 * @param data: Données à transmettre, ou null si non nécessaire
	 * @return chaîne de réponse JSON générée
	 */
	public static String generateResponse(ResultCode repCode, String message, JsonValue data) {
		
		JsonObjectBuilder builder = Json.createObjectBuilder()
				.add("resultCode", repCode.getCode())
				.add("message", message);
		
		if(data == null){
			builder.addNull("data");
		} else {
			builder.add("data", data);
		}
				
		JsonObject res = builder.build();
		
		// Représentation JSON de l'objet
		return res.toString();
	}
}

