/**
 * Project: SERSE_ECN
 * Creation date: 18 mar. 2014
 * Author: Audrey
 */

function valider(){
	var $messageErreur = verifierEntrees();
	if ($messageErreur != ''){
		alert ($messageErreur, 'Erreur dans le remplissage du formulaire');
	} else {
		var argumentsJson = recupererArguments();
		initialiserDialogConfirmation(argumentsJson);
	}
}

function resetFormulaire() {
	$('#continent').val("defaut");
	$('#pays').val("defaut");
	$('#ville').val("defaut");
	$('#typeSejour').val("defaut");
	$('#typeMobilite').val("defaut");
	$('#typeExperience').val("defaut");
	$('#universite_entreprise').val("defaut");
	$('#langue').val("defaut");
	$('#domaine').val("defaut");

	$('#dateDebut').val('');
	$('#dateFin').val('');
	$('#adresse').val('');
	$('#coordonnees').text('Lancer la recherche apres avoir saisi l\'adresse');
	$('#cheminFichier').val('');

	$('#autrePays').hide();
	$('#autreVille').hide();
	$('#autreUniversite').hide();
	$('#autreEntreprise').hide();
	$('#autreLangue').hide();
	$('#autreDomaine').hide();
}

function verifierEntrees() {
	var $messageListeErreurs = '';

	// erreur sur les champs dates
	if ($('#dateDebut').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer une date de début.\n";
	} else if (!(isFormatDate($('#dateDebut').val()))) {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer une date de début de séjour au format jj/mm/aaaa.\n";
	}
	if ($('#dateFin').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer une date de fin.\n";
	} else if (!(isFormatDate($('#dateFin').val()))) {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer une date de fin de séjour au format jj/mm/aaaa.\n";
	} 
	if (!verifierOrdreDate($('#dateDebut').val(), $('#dateFin').val())){
		$messageListeErreurs = $messageListeErreurs
		+ "La date de début de séjour doit être inférieure à la date de fin de séjour.\n";
	}

	// erreur sur le champs continent, pays, ville
	$messageListeErreurs = testChampsDefaut($('#continent'),
			"Merci d'entrer un continent.", $messageListeErreurs);
	$messageListeErreurs = testChampsDefautComplex($('#pays'), $('#valueAutrePays'),
			"Merci d'entrer un pays.", $messageListeErreurs);
	$messageListeErreurs = testChampsDefautComplex($('#ville'),
			$('#valueAutreVille'), "Merci d'entrer une ville.", $messageListeErreurs);

	// erreur sur les champs types de séjour, type de mobilité, type
	// d'expérience
	$messageListeErreurs = testChampsDefaut($('#typeSejour'),
			"Merci d'entrer un type de séjour.", $messageListeErreurs);
	$messageListeErreurs = testChampsDefaut($('#typeMobilite'),
			"Merci d'entrer un type de mobilité.", $messageListeErreurs);
	$messageListeErreurs = testChampsDefaut($('#typeExperience'),
			"Merci d'entrer un type d'expérience.", $messageListeErreurs);

	// erreur sur le champs nom d'université/entreprise
	if ($('#universite_entreprise').val() == 'defaut') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer le nom d'une université ou entreprise.\n";
	} else if ($('#universite_entreprise #universiteGroup option:selected')
			.text() == 'Autre'
			&& $('#valueAutreUniversite').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer le nom d'une université.\n";
	} else if ($('#universite_entreprise #entrepriseGroup option:selected')
			.text() == 'Autre'
			&& $('#valueAutreEntreprise').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer le nom d'une entreprise. \n";
	}

	// erreur sur le champs langue, domaine
	$messageListeErreurs = testChampsDefautComplex($('#langue'),
			$('#valueAutreLangue'), "Merci d'entrer une langue.",
			$messageListeErreurs);
	$messageListeErreurs = testChampsDefautComplex($('#domaine'),
			$('#valueAutreDomaine'), "Merci d'entrer un domaine.",
			$messageListeErreurs);

	// erreur sur le champs adresse, coordonnées GPS, chemin du fichier
	if ($('#adresse').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer une adresse.\n";
	}
	// TODO : GPS vérification
	/*if ($('#coordonnees').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer les coordonnées GPS (en cliquant sur le bouton correspondant).\n";
	}*/
	if ($('#cheminFichier').val() == '') {
		$messageListeErreurs = $messageListeErreurs
				+ "Merci d'entrer le chemin du fichier à transmettre.\n";
	}

	return $messageListeErreurs;

}


function testChampsDefaut(champs, messageErreur, messageListeErreurs) {
	if (champs.val() == 'defaut') {
		messageListeErreurs = messageListeErreurs + messageErreur + "\n";
	}
	return messageListeErreurs;
}

function testChampsDefautComplex(champs, autreChamps, messageErreur,
		messageListeErreurs) {
	if (champs.val() == 'defaut' || (champs.val() == 'Autre' && autreChamps.val() == '')) {
		messageListeErreurs = messageListeErreurs + messageErreur + "\n";
	}
	return messageListeErreurs;
}

/**
 * Vérifie que la date est bien saisie avec le format JJ/MM/AAAA
 * 
 * @param entreeUtilisateur
 */
function isFormatDate(entreeUtilisateur) {
	var isGoodFormat = true;
	var amin = 2010; // année mini
	var amax = 2100; // année maxi
	var separateur = "/"; // separateur entre jour/mois/annee
	var j = (entreeUtilisateur.substring(0, 2));
	var m = (entreeUtilisateur.substring(3, 5));
	var a = (entreeUtilisateur.substring(6));
	if ((isNaN(j)) || (j < 1) || (j > 31)) {
		isGoodFormat = false;
	}
	if ((isNaN(m)) || (m < 1) || (m > 12)) {
		isGoodFormat = false;
	}
	if ((isNaN(a)) || (a < amin) || (a > amax)) {
		isGoodFormat = false;
	}
	if ((entreeUtilisateur.substring(2, 3) != separateur) || (entreeUtilisateur.substring(5, 6) != separateur)) {
		isGoodFormat = false;
	}
	return isGoodFormat;
}

function verifierOrdreDate(dateDebut, dateFin){
	var isGoodOrder = true;
	if (dateDebut!='' && dateFin!='' && isFormatDate($('#dateFin').val()) && isFormatDate($('#dateDebut').val())){
		var j1 = (dateDebut.substring(0, 2));
		var m1 = (dateDebut.substring(3, 5));
		var a1 = (dateDebut.substring(6));
		var j2 = (dateFin.substring(0, 2));
		var m2 = (dateFin.substring(3, 5));
		var a2 = (dateFin.substring(6));
		if (a1>a2){
			isGoodOrder = false;
		} else if (m1>m2){
			isGoodOrder = false;
		} else if (j1>j2){
			isGoodOrder = false;
		}
	}
	return isGoodOrder;
}

function printinformationsRapportInDialog(argumentsJson){
	$('#informationsDeSoumission').append("<table>");
	$.each(argumentsJson, function(key, value) {
		$('#informationsDeSoumission').append("<tr> <td>"+ key + "</td> <td>"+ value + "</td> </tr>");
	});
	$('#informationsDeSoumission').append("</table>");
}
function initialiserDialogConfirmation(argumentsJson){
	printinformationsRapportInDialog(argumentsJson);
	$( "#dialogConfirmation" ).dialog({
	      resizable: false,
	      height:600,
	      width:300,
	      modal: true,
	      buttons: {
	        "Soumettre le rapport": function() {
	        	soumettre(argumentsJson);
	          $( this ).dialog( "close" );
	        },
	        "Modifier les informations": function() {
	          $( this ).dialog( "close" );
	        }
	      }
	    });
	$( "#dialogConfirmation" ).show();
}