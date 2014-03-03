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
		if ($('#pays').val() == 'Autre'){
			$('#autrePays').show();
		} else {
			$('#autrePays').hide();
		}
	});
});