/**
 * 
 */

function recherche(){
	
	
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
	$.each(responseJson, function(key, value) {
		alert ("printed");
		$("#testResultats").val().text(value).appendTo($("#testResultats"));
		
	});
}