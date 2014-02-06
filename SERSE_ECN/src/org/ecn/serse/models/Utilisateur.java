/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */
package org.ecn.serse.models;

/**
 * Classe modèle d'un utilisateur
 * @author Audrey
 */
public class Utilisateur {

	/** Nom de l'utilisateur */
	private String nom;

	/** Préom de l'utilisateur */
	private String prenom;

	/** Email de l'utilisateur */
	private String email;

	/** Catégorie d'utilisateur */
	private Categorie categorie; // étudiant, administrateur, DRI, DRI_admin
	
	/** Préférences */
	private boolean notificationNouveauRapport;
	private boolean notificationNouvelleAssignation;
	private boolean notificationNouvelleOption;
	
	/** Token de connexion */
	private String token;
	
	/** Identifiant de l'utilisateur dans la base de données SERSE*/
	private Integer id;
	
	/**
	 * Constructeur utilisant les paramètres indispensables
	 * @param nom Nom de l'utilisateur
	 * @param prenom Prénom de l'utilisateur
	 * @param email Email de l'utilisateur
	 * @param categorie Type de l'utilisateur (étudiant, administrateur, DRI, visiteur
	 */
	public Utilisateur(Integer id, String nom, String prenom, String email, Categorie categorie, String token) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.categorie = categorie;
		this.token = token;
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
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Définit les différentes catégories d'utilisateurs: étudiant, administrateur, dri, dri et administrateur, visiteur
	 * @author Audrey
	 */
	public static enum Categorie {
		ETUDIANT, DRI, ADMINISTRATEUR, DRI_ADMIN, VISITEUR
	}
}
