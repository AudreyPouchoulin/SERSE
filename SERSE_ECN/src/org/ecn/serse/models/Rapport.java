/**
 * Project: SERSE_ECN
 * Creation date: 7 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.models;


/**
 * @author Audrey
 *
 */
public class Rapport {
	private String nom;
	private String date;
	private String pays;
	private String ville;
	private String lieux;
	private String domaine;
	private String mobilite;
	private String langue;
	
	
	/** Constructor */
	public Rapport(String nom, String date, String pays, String ville, String lieux, String domaine, String mobilite, String langue){
		this.nom = nom;
		this.date = date;
		this.pays = pays;
		this.ville = ville;
		this.lieux = lieux;
		this.domaine = domaine;
		this.mobilite = mobilite;
		this.langue = langue;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the lieux
	 */
	public String getLieux() {
		return lieux;
	}
	/**
	 * @param lieux the lieux to set
	 */
	public void setLieux(String lieux) {
		this.lieux = lieux;
	}
	/**
	 * @return the domaine
	 */
	public String getDomaine() {
		return domaine;
	}
	/**
	 * @param domaine the domaine to set
	 */
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	/**
	 * @return the mobilite
	 */
	public String getMobilite() {
		return mobilite;
	}
	/**
	 * @param mobilite the mobilite to set
	 */
	public void setMobilite(String mobilite) {
		this.mobilite = mobilite;
	}
	/**
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}
	/**
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}

}
