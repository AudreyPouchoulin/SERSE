/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */
package org.ecn.serse.models;

/**
 * Classe modèle d'un utiliateur
 * 
 * @author Audrey
 */
public class Utilisateur {

	/** Nom de l'utilisateur */
	private String nom;

	/** Préom de l'utilisateur */
	private String prenom;

	/** Email de l'utilisateur */
	private String email;

	/** Type d'utilisateur */
	private String type; // étudiant, administrateur, DRI, visiteur
	
	/** Préférences */
	private boolean notificationNouveauRapport;
	private boolean notificationNouvelleAssignation;
	private boolean notificationNouvelleOption;
	
	/**
	 * Constructeur utilisant les paramètres indispensables
	 * @param nom Nom de l'utilisateur
	 * @param prenom Prénom de l'utilisateur
	 * @param email Email de l'utilisateur
	 * @param type Type de l'utilisateur (étudiant, administrateur, DRI, visiteur
	 */
	public Utilisateur(String nom, String prenom, String email, String type) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.setType(type);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the notificationNouveauRapport
	 */
	public boolean isNotificationNouveauRapport() {
		return notificationNouveauRapport;
	}

	/**
	 * @param notificationNouveauRapport the notificationNouveauRapport to set
	 */
	public void setNotificationNouveauRapport(boolean notificationNouveauRapport) {
		this.notificationNouveauRapport = notificationNouveauRapport;
	}

	/**
	 * @return the notificationNouvelleAssignation
	 */
	public boolean isNotificationNouvelleAssignation() {
		return notificationNouvelleAssignation;
	}

	/**
	 * @param notificationNouvelleAssignation the notificationNouvelleAssignation to set
	 */
	public void setNotificationNouvelleAssignation(
			boolean notificationNouvelleAssignation) {
		this.notificationNouvelleAssignation = notificationNouvelleAssignation;
	}

	/**
	 * @return the notificationNouvelleOption
	 */
	public boolean isNotificationNouvelleOption() {
		return notificationNouvelleOption;
	}

	/**
	 * @param notificationNouvelleOption the notificationNouvelleOption to set
	 */
	public void setNotificationNouvelleOption(boolean notificationNouvelleOption) {
		this.notificationNouvelleOption = notificationNouvelleOption;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
