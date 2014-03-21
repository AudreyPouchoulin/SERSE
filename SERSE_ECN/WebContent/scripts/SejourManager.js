/**
 * Project: SERSE_ECN
 * Creation date: 07 mar. 2014
 * Author: Audrey
 * Gestion des cases à cocher université et entreprise, 
 * et conséquences sur la liste de noms d'entreprises et universités pour la page de recherche
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

function changementTextDefaut(nouveauText){
	$("#universite_entreprise option[value='defaut']").text(nouveauText);
}

function entrepriseCoche(avecAutre){
	$('#sejourEntreprise').prop('checked', true);
	ajoutOptionsEntrepriseSiNecessaire(avecAutre);
	if ($('#sejourUniversite').prop('checked')){
		changementTextDefaut('Toutes les universités et entreprises');
	} else {
		changementTextDefaut('Toutes les entreprises');
	}
}

function universiteCoche(avecAutre){
	$('#sejourUniversite').prop('checked', true);	
	ajoutOptionsUniversiteSiNecessaire(avecAutre);
	if ($('#sejourEntreprise').prop('checked')){
		changementTextDefaut('Toutes les universités et entreprises');	
	} else {
		changementTextDefaut('Toutes les universités');
	}
}

function entrepriseDecoche(){
	// TODO : enlever le choix si le choix sélectionné est une entreprise
	changementTextDefaut('Toutes les universités');
	$('#entrepriseGroup').remove();
}

function universiteDecoche(){
	// TODO : enlever le choix si le choix sélectionné est une université
	changementTextDefaut('Toutes les entreprises');
	$('#universiteGroup').remove();
}