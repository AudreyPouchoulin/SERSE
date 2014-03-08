/**
 * Project: SERSE_ECN
 * Creation date: 8 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.controllers;

/**
 * @author Audrey
 *
 */
public class VerificationController {

	/** Controleur de base de données */
	protected BddController bdd;
	
	/**
	 * Initialise un controlleur de vérification
	 * @param bdd : Base de données à utiliser
	 */
	public VerificationController(BddController bdd) {
		this.bdd = bdd;
	}
	
	public boolean isUniversite(String universiteNom){
		//TODO
		return false;	
	}
	
	public boolean isEntreprise(String entrepriseNom){
		//TODO
		return false;
	}
	
}
