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
	remplissageUniversite(true);
	remplissageEntreprise(true);
	remplissageLangue(true);
	remplissageDomaineActivite(true);
	
	/** Dates de début et de fin **/
	$('#dateDebut').datepicker({
	      showOn: "button",
	      buttonImage: "images/iconeCalendrier.png",
	      buttonImageOnly: true,
	      dateFormat: "dd/mm/yy"
	});
	
	$('#dateFin').datepicker({
	      showOn: "button",
	      buttonImage: "images/iconeCalendrier.png",
	      buttonImageOnly: true,
	      dateFormat: "dd/mm/yy"
	});
});