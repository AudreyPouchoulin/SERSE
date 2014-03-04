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

function updatePaysAccordingToContinent(){
	//TODO: obtenir le message défaut
	var $argumentsJson = {nom_liste:'pays', message_defaut:"a", continent:$("#continent").val()};
	var $liste = $('#pays');
	update($liste, $argumentsJson);
}

function updateVilleAccordingToContinent(){
	
}

function updateVilleAccordingToPays(){
	
}

function updateUniversiteAccordingToContinent(){
	
}

function updateUniversiteAccordingToPays(){
	
}

function updateUniversiteAccordingToVille(){
	
}

function updateEntrepriseAccordingToContinent(){
	
}

function updateEntrepriseAccordingToPays(){
	
}

function updateEntrepriseAccordingToVille(){
	
}

function update(liste, argumentsJson){
	$.post('OptionsRestreintesServlet',argumentsJson, function(responseJson) {   
        fillOptions(liste, responseJson);
	});
}
