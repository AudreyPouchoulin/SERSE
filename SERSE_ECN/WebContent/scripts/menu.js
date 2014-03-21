/**
 * Project: SERSE_ECN
 * Creation date: 15 mar. 2014
 * Author: Audrey
 * Pour mettre en surbrillance l'onglet adéquat en fonction de la page
 */

$(document).ready(function() { 
	if ($(document).attr("title") == 'SERSE'){
		$('#MenuAccueil').addClass('active');
		$('#MenuRecherche').removeClass('active');
		$('#MenuMesRapports').removeClass('active');
	} else if ($(document).attr("title") == 'SERSE Recherche de Rapports'){
		$('#MenuAccueil').removeClass('active');
		$('#MenuRecherche').addClass('active');
		$('#MenuMesRapports').removeClass('active');
	} else if ($(document).attr("title") == 'SERSE Soumission de Rapports'){
		$('#MenuAccueil').removeClass('active');
		$('#MenuRecherche').removeClass('active');
		$('#MenuMesRapports').addClass('active');
	}
});