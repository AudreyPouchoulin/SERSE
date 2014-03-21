/**
 * Project: SERSE_ECN
 * Creation date: 07 mar. 2014
 * Author: Audrey
 * Gestion des cases à cocher université et entreprise, 
 * et conséquences sur la liste de noms d'entreprises et universités pour la page de recherche
 */

/** Remplit la liste d'universités si non déhà fait
 * @param avecAutre true si on veut une option Autre dans la liste, false sinon
 */
function ajoutOptionsUniversiteSiNecessaire(avecAutre){
	if (!($('#universiteGroup').length)){
		$('#universite_entreprise').append("<optgroup id=\"universiteGroup\" label=\"Université\"></optgroup>");
		if($("#ville").val()!='defaut'){
			updateUniversiteAccordingToVille(avecAutre);
		} else if($("#continent").val()!='defaut'){
			updateUniversiteAccordingToPays(avecAutre);
		} else if($("#continent").val()!='defaut'){
			updateUniversiteAccordingToContinent(avecAutre);
		} else {
			remplissageUniversite(avecAutre);
		}
	}
}

/**
 * Remplit la liste d'entreprise si non déjà fait
 * @param avecAutre true si on veut une option Autre dans la liste, false sinon
 */
function ajoutOptionsEntrepriseSiNecessaire(avecAutre){
	if (!($('#entrepriseGroup').length)){
		$('#universite_entreprise').append("<optgroup id=\"entrepriseGroup\" label=\"Entreprise\"></optgroup>");
		if($("#ville").val()!='defaut'){
			updateEntrepriseAccordingToVille(avecAutre);
		} else if($("#continent").val()!='defaut'){
			updateEntrepriseAccordingToPays(avecAutre);
		} else if($("#continent").val()!='defaut'){
			updateEntrepriseAccordingToContinent(avecAutre);
		} else {
			remplissageEntreprise(avecAutre);
		}
	}
}

/**
 * Change le messsage par défaut de la liste
 * @param nouveauText nouveau message défaut
 */
function changementTextDefaut(nouveauText){
	$("#universite_entreprise option[value='defaut']").text(nouveauText);
}

/**
 * Actions à faire lorsque l'utilisateur ou le programme coche la case entreprise
 * @param avecAutre true si on veut une option Autre dans la liste, false sinon
 */
function entrepriseCoche(avecAutre){
	$('#sejourEntreprise').prop('checked', true);
	ajoutOptionsEntrepriseSiNecessaire(avecAutre);
	if ($('#sejourUniversite').prop('checked')){
		changementTextDefaut('Toutes les universités et entreprises');
	} else {
		changementTextDefaut('Toutes les entreprises');
	}
}

/**
 * Actions à faire lorsque l'utilisateur ou le programme coche la case université
 * @param avecAutre true si on veut une option Autre dans la liste, false sinon
 */
function universiteCoche(avecAutre){
	$('#sejourUniversite').prop('checked', true);	
	ajoutOptionsUniversiteSiNecessaire(avecAutre);
	if ($('#sejourEntreprise').prop('checked')){
		changementTextDefaut('Toutes les universités et entreprises');	
	} else {
		changementTextDefaut('Toutes les universités');
	}
}

/**
 * Actions à faire lorsque l'utilisateur ou le programme décoche la case entreprise
 */
function entrepriseDecoche(){
	changementTextDefaut('Toutes les universités');
	$('#entrepriseGroup').remove();
}

/**
 * Actions à faire lorsque l'utilisateur ou le programme décoche la case université
 */
function universiteDecoche(){
	changementTextDefaut('Toutes les entreprises');
	$('#universiteGroup').remove();
}