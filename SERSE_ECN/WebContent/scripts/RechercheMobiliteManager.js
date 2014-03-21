/**
 * Project: SERSE_ECN Creation date: 26 fev. 2014 Author: Audrey Gestion des
 * cases à cocher (cochage/décochage en fonction de la hierarchie) dans le cadre
 * mobilité pour la page de recherche de rapports
 */

/** cochage/décochage de la case Professionnel */
function cocheDecocheCaseProfessionnel() {
	var cases = $("#casesCadreProfessionnel").find(':checkbox');
	if ($('#cadreProfessionnel').prop('checked')) {
		cases.prop('checked', true);
	} else {
		if (!($('#cadreAcademique').prop('checked'))){
			alert('Une des 2 cases au moins doit être cochée (académique et/ou professionnel) pour que la recherche soit possible.');
			$('#cadreProfessionnel').prop('checked', true);
		} else {
			cases.prop('checked', false);
		}
	}
	;
}

/** cochage/décochage de la case Académique */
function cocheDecocheCaseAcademique() {
	var cases = $("#casesCadreAcademique").find(':checkbox');
	if ($('#cadreAcademique').prop('checked')) {
		cases.prop('checked', true);
	} else {
		if (!($('#cadreProfessionnel').prop('checked'))){
			alert('Une des 2 cases au moins doit être cochée (académique et/ou professionnel) pour que la recherche soit possible.');
			$('#cadreAcademique').prop('checked', true);
		} else {
			cases.prop('checked', false);
		}
	}
	;
}


/**
 * si décochage de toutes les sous-cases, décochage de Professionnel
 * si cochage d'une case sous professionnel, cochage de Professionnel
 * @param case sur laquelle l'utilisateur a cliquée
 */

function cocheDecochePro(caseClic) {
	if (caseClic.checked) {
		$('#cadreProfessionnel').prop('checked', true);
	} else if (!($('#pCME').prop('checked')) & !($('#pSTING').prop('checked'))
			& !($('#pTFE').prop('checked')) & !($('#pCesure').prop('checked'))
			& !($('#pSemestre').prop('checked'))) {
		if (!($('#cadreAcademique').prop('checked'))){
			alert('Une des 2 cases au moins doit être cochée (académique et/ou professionnel) pour que la recherche soit possible.');
			caseClic.checked = true;
		} else {
			$('#cadreProfessionnel').prop('checked', false);
		}
	}
	;
}

/**
 * si décochage de toutes les sous-cases, décochage de Académique 
 * si cochage d'une case sous académique, cochage de Académique
 * @param case sur laquelle l'utilisateur a cliquée
 */
function cocheDecocheAca(caseClic) {
	if (caseClic.checked) {
		$('#cadreAcademique').prop('checked', true);
	} else if (!($('#aSemestre').prop('checked'))
			& !($('#aAnnee').prop('checked'))
			& !($('#aDoubleDiplome').prop('checked'))
			& !($('#aCesure').prop('checked'))) {
		if (!($('#cadreProfessionnel').prop('checked'))){
			alert('Une des 2 cases au moins doit être cochée (académique et/ou professionnel) pour que la recherche soit possible.');
			caseClic.checked = true;
		} else {
			$('#cadreAcademique').prop('checked', false);
		}	
	}
	;
}

