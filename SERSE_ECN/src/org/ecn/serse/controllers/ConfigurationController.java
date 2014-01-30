/**
 * Project: SERSE_ECN
 * Creation date: 30 janv. 2014
 * Author: Audrey
 */

package org.ecn.serse.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe de gestion des paramètres de l'application (adresse des serveurs distants, etc.)
 * @author Audrey
 *
 */
public class ConfigurationController {
	
	protected static final String CONFIG_FILENAME = "serse_config.xml"; 
	protected static final Properties properties = new Properties();
	protected static boolean propertiesLoaded = false;
	
	/**
	 * Ensemble des entrées de préférences gérées par l'application
	 *
	 */
	public enum SerseConfiguration {
		/** URL du serveur PostgreSQL pour JDBC, clé pgsql_jdbc_url du fichier de configuration */
		PGSQL_JDBC_URL("pgsql_jdbc_url"),
		
		/** Nom d'utilisateur du serveur PostgreSQL, clé pgsql_user du fichier de configuration */
		PGSQL_USER("pgsql_user"),
		
		/** Mot de passe du serveur PostgreSQL, clé pgsql_pass du fichier de configuration */
		PGSQL_PASS("pgsql_pass"),
		
		/** Adresse du serveur LDAP, clé ldap_host du fichier de configuration */
		LDAP_HOST("ldap_host"),
		
		/** Port du serveur LDAP, clé ldap_port du fichier de configuration */
		LDAP_PORT("ldap_port"),
		
		/** Indique si la connexion au serveur LDAP doit utiliser SSL, clé ldap_use_ssl du fichier de configuration */
		LDAP_USE_SSL("ldap_use_ssl");
		
		
		private String key;

		SerseConfiguration(String key) {
			this.key = key;
		}
		
		/**
		 * Récupération de la clé du fichier de configuration correspondant à la préférence
		 * @return La clé
		 */
		public String getKey() {
			return key;
		}
	}
	
	/**
	 * Chargement des configurations depuis le fichier {@link ConfigurationController#CONFIG_FILENAME}
	 * N'effectue le chargement qu'une fois par chargement de la classe
	 */
	protected static synchronized void loadConfigurations() {
		if(propertiesLoaded) {
			return;
		}
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILENAME);
			properties.loadFromXML(is);
			propertiesLoaded = true;
		} catch (IOException e) {
			String message = "Erreur de chargement du fichier de configuration " + CONFIG_FILENAME + " ; l'application ne peut pas s'exécuter correctement";
			throw new RuntimeException(message, e);
		}	
	}
	
	/**
	 * Récupération d'une valeur de configuration de l'application
	 * @param configuration Clé de la configuration stockée
	 * @return Valeur de la configuration
	 */
	public static String getConfiguration(SerseConfiguration configuration) {
		loadConfigurations();
		String value = properties.getProperty(configuration.getKey());
		
		if(value == null) {
			return "undefined";
		}
		
		return value;
	}
}
