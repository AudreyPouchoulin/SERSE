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
		
		if (('#continent>option:selected').val()!="Tous les continents"){
			$continent = ('#continent>option:selected').val();
		}
		if (('#pays>option:selected').val()!="Tous les pays"){
			$pays = ('#pays>option:selected').val();
		}
		if (('#ville>option:selected').val()!="Toutes les villes"){
			$ville = ('#ville>option:selected').val();
		}
		if (('#langue>option:selected').val()!="Toutes les langues"){
			$langue = ('#ville>option:selected').val();
		}
		if (('#domaine>option:selected').val()!="Tous les domaines d'activité"){
			$domaineActivite = ('#domaine>option:selected').val();
		}
		if (('#date>option:selected').val()!="Toutes les rapports"){
			$date = ('#date>option:selected').val();
		}
	
	var $arguments = {continent:$continent, 
					pays:$pays,
					ville:$ville,
					universite:('#universite').prop('checked'),
					entreprise:('#entreprise').prop('checked'),
					professionnel:('#cadreProfessionnel').prop('checked'),
					academique:('#cadreAcademique').prop('checked'),
					CME:('#pCME').prop('checked'),
					STING:('#pSTING').prop('checked'),
					TFE:('#pTFE').prop('checked'),
					semestre:$semestre,
					annee:$annee,
					cesure:$cesure,
					doubleDiplome:('#aDoubleDiplome').prop('checked'),
					universiteNom:('#universiteGroup>option:selected').val(),
					entrepriseNom:('#entrepriseGroup>option:selected').val(),
					langue:$langue,
					domaineActivite:$domaineActivite,
					date:$date};

	return $arguments;
}

function fillResults(responseJson){
	
}