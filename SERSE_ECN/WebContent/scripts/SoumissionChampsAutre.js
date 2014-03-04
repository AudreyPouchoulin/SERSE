/**
 * Project: SERSE_ECN
 * Creation date: 3 mar. 2014
 * Author: Audrey
 * Affichage du champs d'écriture lors de la soumission des rapports pour les champs "Autre" de:
 * - pays
 * - ville
 * - université
 * - entreprise
 * - langue
 * - domaine d'activité
 */

$(document).ready(function() {
	$('#pays').change(function() {
		gestionAutre($('#pays'), $('#autrePays'));
	});
	
	$('#ville').change(function() {
		gestionAutre($('#ville'), $('#autreVille'));
	});
	
	$('#universite_entreprise').change(function() {
		//TODO: différencier entre université et entreprise
		if ($('#universite_entreprise').val() == 'Autre'){
			$('#autreUniversite').show();
		} else {
			$('#autreUniversite').hide();
		}
	});
	
	$('#langue').change(function() {
		gestionAutre($('#langue'), $('#autreLangue'));
	});
	
	$('#domaine').change(function() {
		gestionAutre($('#domaine'), $('#autreDomaine'));
	});
	
});

function gestionAutre($champs, $autreChamps){
	if ($champs.val() == 'Autre'){
		$autreChamps.show();
	} else {
		$autreChamps.hide();
	}
}