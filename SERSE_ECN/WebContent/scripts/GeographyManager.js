/**
 * Project: SERSE_ECN
 * Creation date: 03 mar. 2014
 * Author: Audrey
 * Gestion du contenu des listes de:
 * - continent
 * - pays
 * - ville
 * - université/entreprise noms
 * en fonction des choix faits dans les champs :
 * - continent
 * - pays
 * - ville
 */

/**
 * Actualise la liste d'options de pays en fonction du continent sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updatePaysAccordingToContinent(avecAutre){
	if($("#continent").val()!='defaut'){
		var $argumentsJson = {nom_liste:'pays', message_defaut:$("#pays option[value='defaut']").text(), continent:$("#continent").val()};
		var $liste = $('#pays');
		update($liste, $argumentsJson, avecAutre);
	} else {
		remplissagePays(avecAutre);
	}
}

/**
 * Actualise la liste d'options de villes en fonction du continent sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateVilleAccordingToContinent(avecAutre){
	if ($("#continent").val()!='defaut'){
		var $argumentsJson = {nom_liste:'ville', message_defaut:$("#ville option[value='defaut']").text(), continent:$("#continent").val()};
		var $liste = $('#ville');
		update($liste, $argumentsJson, avecAutre);
	} else {
		remplissageVille(avecAutre);
	}
}

/**
 * Actualise la liste d'options de villes en fonction du pays sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateVilleAccordingToPays(avecAutre){
	if ($("#pays").val()!='defaut'){
		var $argumentsJson = {nom_liste:'ville', message_defaut:$("#ville option[value='defaut']").text(), pays:$("#pays").val()};
		var $liste = $('#ville');
		update($liste, $argumentsJson, avecAutre);
	} else {
		updateVilleAccordingToContinent(avecAutre);
	}
}

/**
 * Actualise la liste d'options d'universités en fonction du continent sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateUniversiteAccordingToContinent(avecAutre){
	if($("#continent").val()!='defaut'){
		var $argumentsJson = {nom_liste:'universite', message_defaut:$("#universite_entreprise option[value='defaut']").text(), continent:$("#continent").val()};
		var $liste = $('#universiteGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		remplissageUniversite(avecAutre);
	}
}

/**
 * Actualise la liste d'options d'universités en fonction du pays sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateUniversiteAccordingToPays(avecAutre){
	if($("#pays").val()!='defaut'){
		var $argumentsJson = {nom_liste:'universite', message_defaut:$("#universite_entreprise option[value='defaut']").text(), pays:$("#pays").val()};
		var $liste = $('#universiteGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		updateUniversiteAccordingToContinent(avecAutre);
	}
}

/**
 * Actualise la liste d'options d'universités en fonction de la ville sélectionnée
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateUniversiteAccordingToVille(avecAutre){
	if($("#ville").val()!='defaut'){
		var $argumentsJson = {nom_liste:'universite', message_defaut:$("#universite_entreprise option[value='defaut']").text(), ville:$("#ville").val()};
		var $liste = $('#universiteGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		updateUniversiteAccordingToPays(avecAutre);
	}
	
}

/**
 * Actualise la liste d'options d'entreprise en fonction du continent sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateEntrepriseAccordingToContinent(avecAutre){
	if($("#continent").val()!='defaut'){
		var $argumentsJson = {nom_liste:'entreprise', message_defaut:$("#universite_entreprise option[value='defaut']").text(), continent:$("#continent").val()};
		var $liste = $('#entrepriseGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		remplissageEntreprise(avecAutre);
	}
}

/**
 * Actualise la liste d'options d'entreprise en fonction du pays sélectionné
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateEntrepriseAccordingToPays(avecAutre){
	if($("#pays").val()!='defaut'){
		var $argumentsJson = {nom_liste:'entreprise', message_defaut:$("#universite_entreprise option[value='defaut']").text(), pays:$("#pays").val()};
		var $liste = $('#entrepriseGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		updateEntrepriseAccordingToContinent(avecAutre);
	}
}

/**
 * Actualise la liste d'options d'entreprises en fonction de la ville sélectionnée
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function updateEntrepriseAccordingToVille(avecAutre){
	if($("#ville").val()!='defaut'){
		var $argumentsJson = {nom_liste:'entreprise', message_defaut:$("#universite_entreprise option[value='defaut']").text(), ville:$("#ville").val()};
		var $liste = $('#entrepriseGroup');
		update($liste, $argumentsJson, avecAutre);
	} else {
		updateEntrepriseAccordingToPays(avecAutre);
	}
}

/**
 * Actualise une liste d'options avec les options reçues au format JSON
 * @param liste nom de la liste déroulante où il faut actualiser les options
 * @param argumentsJson liste d'options au format JSON à ajouter dans la liste déourlante
 * @param avecAutre true si on veut un champs Autre dans les options, false sinon
 */
function update(liste, argumentsJson, avecAutre){
	$.post('OptionsRestreintesServlet',argumentsJson, function(responseJson) { 
        fillOptions(liste, responseJson);
        if (avecAutre){
        	addOptionAutre(liste);
        }
	});
}
