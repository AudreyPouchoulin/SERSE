/**
 * 
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