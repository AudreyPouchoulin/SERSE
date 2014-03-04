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
			// TODO: prendre en compte continent, pays, ville si nécessaire
			$('#universite_entreprise').append("<optgroup id=\"universiteGroup\" label=\"Universite\">Université</optgroup>");
			remplissageUniversite(false);
		} else {
			// TODO: changer la valeur du champs par défaut
			$('#universiteGroup').remove();
		}
		recherche();
	});
	
	$('#sejourEntreprise').click(function() {
		if (this.checked){
			$('#universite_entreprise').append("<optgroup id=\"entrepriseGroup\" label=\"Entreprise\">Entreprise</optgroup>");
			remplissageEntreprise(false);
		} else {
			// TODO: changer la valeur du champs par défaut
			$('#entrepriseGroup').remove();
		}
		recherche();
	});
	
/**Cadre de mobilité */
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