/**
 * Project: SERSE_ECN
 * Creation date: 07 mar. 2014
 * Author: Audrey
 * Gestion des cases à cocher université et entreprise, 
 * et conséquences sur la liste de noms d'entreprises et universités pour la page de recherche
 */


function ajoutOptionsUniversiteSiNecessaire(){
	if (!($('#universiteGroup').length)){
		$('#universite_entreprise').append("<optgroup id=\"universiteGroup\" label=\"Université\"></optgroup>");
		// TODO: prendre en compte continent, pays, ville si nécessaire
		remplissageUniversite(false);
	}
}

function ajoutOptionsEntrepriseSiNecessaire(){
	if (!($('#entrepriseGroup').length)){
		$('#universite_entreprise').append("<optgroup id=\"entrepriseGroup\" label=\"Entreprise\"></optgroup>");
		// TODO: prendre en compte continent, pays, ville si nécessaire
		remplissageEntreprise(false);
	}
}

function changementTextDefaut(nouveauText){
	$("#universite_entreprise option[value='defaut']").text(nouveauText);
}

function entrepriseCoche(){
	$('#sejourEntreprise').prop('checked', true);
	ajoutOptionsEntrepriseSiNecessaire();
	if ($('#sejourUniversite').prop('checked')){
		changementTextDefaut('Toutes les universités et entreprises');
	} else {
		changementTextDefaut('Toutes les entreprises');
	}
}

function universiteCoche(){
	$('#sejourUniversite').prop('checked', true);	
	ajoutOptionsUniversiteSiNecessaire();
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