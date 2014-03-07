/**
 * Project: SERSE_ECN
 * Creation date: 04 mar. 2014
 * Author: Audrey
 * Lancement de la recherche ou de l'actualisation de listes
 * lors du changement d'un des choix dans les listes déroulantes ou cases à cocher des filtres de recherche:
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
	
/** Géographie */
	$('#continent').change(function() {
		updatePaysAccordingToContinent();
		updateVilleAccordingToContinent();
		updateUniversiteAccordingToContinent();
		updateEntrepriseAccordingToContinent();
		recherche();
	});
	
	$('#pays').change(function() {
		updateVilleAccordingToPays();
		updateUniversiteAccordingToPays();
		updateEntrepriseAccordingToPays();
		recherche();
	});
	$('#ville').change(function() {
		updateUniversiteAccordingToVille();
		updateEntrepriseAccordingToVille();
		recherche();
	});
	
/**Séjour en université ou entreprise */
	$('#sejourUniversite').click(function() {
		if (this.checked){
			universiteCoche();
		} else {
				universiteDecoche();
				if (!($('#sejourEntreprise').prop('checked'))) {
				alert('Une des 2 cases au moins doit être cochée (université et/ou entreprise) pour que la recherche soit possible.');
				entrepriseCoche();
			}
			
		}
		recherche();
	});
	
	$('#sejourEntreprise').click(function() {
		if (this.checked){
			entrepriseCoche();
		} else {
			entrepriseDecoche();
			if(!($('#sejourUniversite').prop('checked'))){
				alert('Une des 2 cases au moins doit être cochée (université et/ou entreprise) pour que la recherche soit possible.');
				universiteCoche();
			}
		}
		recherche();
	});

/**Cadre de mobilité */
	$('#cadreProfessionnel').click(function() {
		cocheDecocheCaseProfessionnel();
		recherche();
	});
	$('#cadreAcademique').click(function() {
		cocheDecocheCaseAcademique();
		recherche();
	});
	$('#pCME').click(function() {
		cocheDecochePro(this);
		recherche();
	});
	$('#pSTING').click(function() {
		cocheDecochePro(this);
		recherche();
	});
	$('#pTFE').click(function() {
		cocheDecochePro(this);
		recherche();
	});
	$('#pCesure').click(function() {
		cocheDecochePro(this);
		recherche();
	});
	$('#pSemestre').click(function() {
		cocheDecochePro(this);
		recherche();
	});
	$('#aSemestre').click(function() {
		cocheDecocheAca(this);
		recherche();
	});
	$('#aAnnee').click(function() {
		cocheDecocheAca(this);
		recherche();
	});
	$('#aDoubleDiplome').click(function() {
		cocheDecocheAca(this);
		recherche();
	});
	$('#aCesure').click(function() {
		cocheDecocheAca(this);
		recherche();
	});
	
/** Autres */
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
