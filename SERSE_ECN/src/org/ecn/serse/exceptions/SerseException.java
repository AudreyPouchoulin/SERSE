/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */
package org.ecn.serse.exceptions;

/**
 * Classe générale pour les exceptions de l'application
 * @author Audrey
 */
public class SerseException extends Exception {

	private static final long serialVersionUID = -4822842236569206129L;

	private ResultCode resultCode;
	
	public SerseException(ResultCode resultCode) {
		super();
		this.resultCode = resultCode;
	}
	
	public SerseException(ResultCode resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}
	
	public SerseException(ResultCode resultCode, Throwable e) {
		super(e);
		this.resultCode = resultCode;
	}
	
	public SerseException(ResultCode resultCode, String message, Throwable e) {
		super(message, e);
		this.resultCode = resultCode;
	}
	
	public ResultCode getResultCode() {
		return resultCode;
	}
}
