/**
 * Project: SERSE_ECN
 * Creation date: 07 mar. 2014
 * Author: Audrey
 * Lancement de l'actualisation des listes suivantes (si nécessaires) et de la vérification du remplissage des champs précédents
 * lors de la sélection d'un des choix dans les listes déroulantes de la page de soumission d'un nouveau rapport
 */

$(document).ready(function() {
	
	
/** Dates de début et de fin **/
	//$('#dateDebut').datepicker();

	
/** Géographie */
	$('#continent').change(function() {
		if ($('#continent').val() !='defaut'){
			updatePaysAccordingToContinent(true);
			updateVilleAccordingToContinent(true);
			updateUniversiteAccordingToContinent(true);
		}
	});
	
	$('#pays').change(function() {
		gestionAutre($('#pays'), $('#autrePays'));
		if ($('#pays').val() != 'Autre' && $('#pays').val() !='defaut'){
			updateVilleAccordingToPays(true);
			updateUniversiteAccordingToPays(true);
		}
	});
	
	$('#ville').change(function() {
		gestionAutre($('#ville'), $('#autreVille'));
		if ($('#ville').val() != 'Autre' && $('#ville').val() !='defaut'){
			updateUniversiteAccordingToVille(true);
		}
	});
	
/**Type de séjour*/
	$('#typeSejour').change(function() {
		var $selection = $('#typeSejour option:selected').text();
		if ($selection=='entreprise'){
			$('#universiteGroup').remove();
			$("#universite_entreprise option[value='defaut']").text('Choisissez une entreprise');
			if (!($('#entrepriseGroup').length)){
				$('#universite_entreprise').append("<optgroup id=\"entrepriseGroup\" label=\"Entreprise\">Entreprise</optgroup>");
				remplissageEntreprise(true);
			}
		} else if ($selection=='université'){
			$('#entrepriseGroup').remove();
			$("#universite_entreprise option[value='defaut']").text('Choisissez une université');
			if (!($('#universiteGroup').length)){
				$('#universite_entreprise').append("<optgroup id=\"universiteGroup\" label=\"Université\">Université</optgroup>");
				remplissageUniversite(true);
			}
			
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
		var $messageErreur = verifierEntrees();
		if ($messageErreur !=null){
			alert ($messageErreur);
		} else {
			var $argumentsJson = recupererArguments();
			alert("Page de validation" + $argumentsJson);
		}
	});

/** Bouton reset */
	$('#reset').click(function(){
		resetFormulaire();
	});
	
});