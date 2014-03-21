/**
 * Project: SERSE_ECN
 * Creation date: 07 mar. 2014
 * Author: Audrey
 * Lancement de l'actualisation des listes suivantes (si nécessaires) et de la vérification du remplissage des champs précédents (à faire)
 * lors de la sélection d'un des choix dans les listes déroulantes de la page de soumission d'un nouveau rapport
 */

$(document).ready(function() {

/** Géographie */
	$('#continent').change(function() {
		updatePaysAccordingToContinent(true);
		updateVilleAccordingToContinent(true);
		updateUniversiteAccordingToContinent(true);
	});
	
	$('#pays').change(function() {
		gestionAutre($('#pays'), $('#autrePays'));
		if ($('#pays').val() != 'Autre'){
			updateVilleAccordingToPays(true);
			updateUniversiteAccordingToPays(true);
		}
	});
	
	$('#ville').change(function() {
		gestionAutre($('#ville'), $('#autreVille'));
		if ($('#ville').val() != 'Autre'){
			updateUniversiteAccordingToVille(true);
		}
	});
	
/**Type de séjour*/
	$('#typeSejour').change(function() {
		var $selection = $('#typeSejour option:selected').text();
		if ($selection=='entreprise'){
			$('#universiteGroup').remove();
			$("#universite_entreprise option[value='defaut']").text('Choisissez une entreprise');
			ajoutOptionsEntrepriseSiNecessaire(true);
		} else if ($selection=='université'){
			$('#entrepriseGroup').remove();
			$("#universite_entreprise option[value='defaut']").text('Choisissez une université');
			ajoutOptionsUniversiteSiNecessaire(true);
		}
	});
	
/**Type de mobilité */
	$('#typeMobilite').change(function() {
		//TODO
	});
	
/** Type d'expérience*/
	$('#typeExperience').change(function() {
		//TODO
	});

/** Nom de l'université ou de l'entreprise */
	$('#universite_entreprise').change(function() {
		if ($('#universite_entreprise #universiteGroup option:selected').text() == 'Autre'){
			$('#autreUniversite').show();
			$('#autreEntreprise').hide();
		} else if ($('#universite_entreprise #entrepriseGroup option:selected').text() == 'Autre'){
			$('#autreEntreprise').show();
			$('#autreUniversite').hide();
		} else {
			$('#autreUniversite').hide();
			$('#autreEntreprise').hide();
		}
	});

/** langue */
	$('#langue').change(function() {
		gestionAutre($('#langue'), $('#autreLangue'));
	});
	
/** domaine */	
	$('#domaine').change(function() {
		gestionAutre($('#domaine'), $('#autreDomaine'));
	});
	
/** adresse et coordonnées GPS*/

/** chemin du fichier */

/** Bouton valider */
	$('#valider').click(function(){
		valider();
	});

/** Bouton reset */
	$('#reset').click(function(){
		resetFormulaire();
	});
	
});