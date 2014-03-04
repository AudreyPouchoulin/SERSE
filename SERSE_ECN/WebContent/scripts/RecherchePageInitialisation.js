/**
 * Project: SERSE_ECN
 * Creation date: 4 mar. 2014
 * Author: Audrey
 * Initialisation de la page de recherche 
 * (remplissage des listes déroulantes d'options, des résultats avec tous les filtres sélectionnés)
 */

	$(document).ready(function() { 
		remplissageContinent();
		remplissagePays(false);
		remplissageVille(false);
		remplissageUniversiteEntreprise(false);
		remplissageDomaineActivite(false);
		remplissageLangue(false);
		recherche();
	});