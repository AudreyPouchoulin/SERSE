/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */
package org.ecn.serse.exceptions;

/**
 * Codes de retour des requêtes
 * 
 * @author Audrey
 */
public enum ResultCode {

	/** Requête effectuée avec succès */
	SUCCESS(0),
	
	/** Erreur d'identification : identifiants ou token incorrects ou expirés notamment */
	IDENTIFICATION_ERROR(1),
	LDAP_CONNECTION_ERROR(3),
	
	/** Erreur de connexion à la base de données */
	DATABASE_ERROR(4),
	CRYPTOGRAPHIC_ERROR(5),
	
	/** La requête a été effectuée sans tous les paramètres nécessaires */
	WRONG_PARAMETERS_FOR_REQUEST(6),
	
	/** Un objet invalide a été fourni à une méthode d'enregistrement */
	INVALID_OBJECT(7),

	/** Un objet du même nom est déjà en base de données */
	NAME_TAKEN(8),
	
	/** L'utilisateur n'est pas autorisé à effectuer cette action */
	AUTHORIZATION_ERROR(9),

	/** Une valeur alphanumérique est requise */
	ALPHANUMERIC_REQUIRED(10),
	
	/** Une requête a été annulée car le nombre de résultats était trop important */
	MAX_ROW_COUNT_EXCEEDED(11);

	private int code;
	
	ResultCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
}
