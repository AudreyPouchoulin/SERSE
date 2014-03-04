/**
 * Project: SERSE_ECN
 * Creation date: 4 mar. 2014
 * Author: Audrey
 * Initialisation de la page de soumission de rapports
 * (remplissage des listes déroulantes d'options, avec la possibilité Autre pour certains)
 */

$(document).ready(function() { 
	remplissageContinent();
	remplissagePays(true);
	remplissageVille(true);
	remplissageTypeSejour();
	remplissageTypeMobilite();
	remplissageTypeExperience();
	remplissageUniversiteEntreprise(true);
	remplissageLangue(true);
	remplissageDomaineActivite(true);
});