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
	// tests si une option a été sélectionnée dans une liste déroulante
		var $continent = '';
		var $pays = '';
		var $ville = '';
		var $langue= '';
		var $domaineActivite = '';
		var $date = '';

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
					universite:$('#sejourUniversite').prop('checked'),
					entreprise:$('#sejourEntreprise').prop('checked'),
					professionnel:$('#cadreProfessionnel').prop('checked'),
					academique:$('#cadreAcademique').prop('checked'),
					CME:$('#pCME').prop('checked'),
					STING:$('#pSTING').prop('checked'),
					TFE:$('#pTFE').prop('checked'),
					pSemestre:$('#pSemestre').prop('checked'),
					pCesure:$('#pCesure').prop('checked'),
					aSemestre:$('#aSemestre').prop('checked'),
					aCesure:$('#aCesure').prop('checked'),
					annee:$('#aAnnee').prop('checked'),
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
		$("#contenuTableauResultats").append("<td> <a href='rapports/"+ encodeURIComponent(value.nom) + ".pdf'>" + value.nom + "</a> </td>");
		$("#contenuTableauResultats").append("<td> <a href='http://localhost:8080/SERSE_ECN/files/"+ encodeURIComponent(value.nom) + ".pdf'> <img height='30px' src='images/iconeDownload.jpg' border ='0'> </a> </td>");
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