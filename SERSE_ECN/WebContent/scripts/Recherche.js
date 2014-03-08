/**
 * Project: SERSE_ECN
 * Creation date: 03 mar. 2014
 * Author: Audrey
 * Fonctions relatives à la recherche: 
 * - récupération des paramètres de recherche
 * - appel de la servlet de recherche
 * - remplissage des résultats
 */

function recherche(){
	var $arguments = preparationParametresRecherche();
	$.post('RechercheServlet', $arguments,function(responseJson){
	     fillResults(responseJson);
    });
}

function preparationParametresRecherche(){

	// regroupement de cases à cocher : semestre, année, césure
		var $semestre = false;
		var $annee = false;
		var $cesure = false;
		if ($('#aSemestre').prop('checked') || $('#pSemestre').prop('checked')){
			$semestre = true;
		}
		if ($('#aAnnee').prop('checked') || $('#pAnnee').prop('checked')){
			$annee = true;
		}
		if ($('#aCesure').prop('checked') || $('#pCesure').prop('checked')){
			$cesure = true;
		}
		
	// tests si une option a été sélectionnée dans une liste déroulante
		var $continent = null;
		var $pays = null;
		var $ville = null;
		var $langue= null;
		var $domaineActivite = null;
		var $date = null;

		if ($('#continent').val() != 'defaut'){
			$continent = $('#continent').val();
		}
		if ($('#pays').val() != "defaut"){
			$pays = $('#pays').val();
		}
		if ($('#ville').val() != "defaut"){
			$ville = $('#ville').val();
		}
		if ($('#langue').val() != "defaut"){
			$langue = $('#langue').val();
		}
		if ($('#domaine').val() != "defaut"){
			$domaineActivite = $('#domaine').val();
		}
		if ($('#date').val() != "defaut"){
			$date = $('#date').val();
		}

	var $arguments = {continent:$continent, 
					pays:$pays,
					ville:$ville,
					universite:$('#universite').prop('checked'),
					entreprise:$('#entreprise').prop('checked'),
					professionnel:$('#cadreProfessionnel').prop('checked'),
					academique:$('#cadreAcademique').prop('checked'),
					CME:$('#pCME').prop('checked'),
					STING:$('#pSTING').prop('checked'),
					TFE:$('#pTFE').prop('checked'),
					semestre:$semestre,
					annee:$annee,
					cesure:$cesure,
					doubleDiplome:$('#aDoubleDiplome').prop('checked'),
					universiteNom:$('#universiteGroup>option:selected').val(),
					entrepriseNom:$('#entrepriseGroup>option:selected').val(),
					langue:$langue,
					domaineActivite:$domaineActivite,
					date:$date};

	return $arguments;
}

function fillResults(responseJson){
	$("#contenuTableauResultats").find('tr').remove();
	$("#contenuTableauResultats").find('td').remove();
	if (responseJson.length==0){
		$("#contenuTableauResultats").append("<tr> <td colspan='8'>Pas de résultats correspondants aux critères </td></tr>");
	}
	$.each(responseJson, function(key, value) {
		$("#contenuTableauResultats").append("<tr>");
		$("#contenuTableauResultats").append("<td>" + value.nom + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.date + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.pays + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.ville + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.lieux + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.domaine + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.mobilite + "</td>");
		$("#contenuTableauResultats").append("<td>" + value.langue + "</td>");
		$("#contenuTableauResultats").append("</tr>");	
	});
}