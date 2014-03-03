/**
 * Project: SERSE_ECN
 * Creation date: 03 mar. 2014
 * Author: Audrey
 * Lancement de la recherche lors du changement d'un des choix dans les listes déroulantes ou cases à cocher des filtres de recherche:
 * - continent
 * - pays
 * - ville
 * - universités/entreprises
 * - professionnel/académique/CME/STING/TFE/Césure/Semestre/Année/Double diplôme
 * - université/entreprise nom
 * - langue
 * - domaine d'activité
 * - date
 */
$(document).ready(function() {
	
	// Géographie
	$('#continent').change(function() {
		recherche();
	});
	$('#pays').change(function() {
		recherche();
	});
	$('#ville').change(function() {
		recherche();
	});
	
	// Séjour en université ou entreprise
	$('#sejourUniversite').click(function() {
		recherche();
	});
	$('#sejourEntreprise').click(function() {
		recherche();
	});
	
	// Cadre de mobilité
	$('#cadreProfessionnel').click(function() {
		recherche();
	});
	$('#cadreAcademique').click(function() {
		recherche();
	});
	$('#pCME').click(function() {
		recherche();
	});
	$('#pSTING').click(function() {
		recherche();
	});
	$('#pTFE').click(function() {
		recherche();
	});
	$('#pCesure').click(function() {
		recherche();
	});
	$('#pSemestre').click(function() {
		recherche();
	});
	$('#aSemestre').click(function() {
		recherche();
	});
	$('#aAnnee').click(function() {
		recherche();
	});
	$('#aDoubleDiplome').click(function() {
		recherche();
	});
	$('#aCesure').click(function() {
		recherche();
	});
	
	//Autres
	$('#universite_entreprise').change(function() {
		recherche();
	});
	$('#langue').change(function() {
		recherche();
	});
	$('#domaine').change(function() {
		recherche();
	});
	$('#date').change(function() {
		recherche();
	});
	
});

function recherche(){
	var $arguments = preparationParametresRecherche();
	$.post('RechercheServlet', $arguments,function(responseJson){
	            fillResults(responseJson);
    });
}

/** 
 */
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

		if ($('#continent').val() != 'Tous les continents'){
			$continent = $('#continent').val();
		}
		if ($('#pays').val() != "Tous les pays"){
			$pays = $('#pays').val();
		}
		if ($('#ville').val() != "Toutes les villes"){
			$ville = $('#ville').val();
		}
		if ($('#langue').val() != "Toutes les langues"){
			$langue = $('#langue').val();
		}
		if ($('#domaine').val() != "Tous les domaines d'activité"){
			$domaineActivite = $('#domaine').val();
		}
		if ($('#date').val() != "Toutes les rapports"){
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
	//$("#contenuTableauResultats").();
	$.each(responseJson, function(key, value) {
		$("#tableauResultats").append("<tr>");
			$("#tableauResultats").append("<td>" + value + "</td>");
		$("#tableauResultats").append("</tr>");	
		
	});
}