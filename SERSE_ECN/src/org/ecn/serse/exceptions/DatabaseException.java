/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */
package org.ecn.serse.exceptions;

/**
 * Exception des méthodes accédant à la base de données
 * @author Audrey
 */
public class DatabaseException extends SerseException {

	private static final long serialVersionUID = 3116816893227762498L;

	public DatabaseException() {
		super(ResultCode.DATABASE_ERROR);
	}

	public DatabaseException(String message) {
		super(ResultCode.DATABASE_ERROR, message);
	}

	public DatabaseException(Throwable e) {
		super(ResultCode.DATABASE_ERROR, e);
	}
}