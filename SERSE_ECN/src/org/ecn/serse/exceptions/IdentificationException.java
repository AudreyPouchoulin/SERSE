/**
 * Project: SERSE_ECN
 * Creation date: 6 févr. 2014
 * Author: Audrey
 */
package org.ecn.serse.exceptions;

import org.ecn.serse.exceptions.SerseException;
import org.ecn.serse.exceptions.ResultCode;

/**
 * Erreur d'identification : accès à LDAP ou du à l'utilisateur (mauvais mot de passe)
 * @author Audrey
 */
public class IdentificationException extends SerseException {

	private static final long serialVersionUID = -1631399657774715243L;

	public IdentificationException(ResultCode resultCode, String message) {
		super(resultCode, message);
	}
	
	public IdentificationException(ResultCode resultCode, String message, Throwable e) {
		super(resultCode, message, e);
	}
}
