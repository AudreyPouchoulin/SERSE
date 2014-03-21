/**
 * Project: SERSE_ECN Creation date: 04 mar. 2014 Author: Audrey Bouton Reset,
 * Valider, Envoyer
 */

function soumettre(argumentsJson){
	$.post('SoumissionRapportServlet', argumentsJson, function(responseJson){
	     if (responseJson==true){
	    	 alert("Votre rapport a bien été soumis.\nVous pouvez suivre la validation de votre rapport dans l'onglet 'Mes rapports'.");
	    	 $.post('SoumissionFormulaireServlet', null, null);
	     } else {
	    	 alert("Un problème a été rencontré lors de la soumission du rapport. Merci de contacter votre administrateur système.");
	     }
   });
}

function recupererArguments() {
	var $pays = recupererValeurAvecPossibiliteAutre($('#pays'), $('#valueAutrePays'));
	var $ville = recupererValeurAvecPossibiliteAutre($('#ville'), $('#valueAutreVille'));
	var $entreprise = '';
	var $universite = '';
	if ($('#typeSejour').val() =='université'){
		$universite = recupererValeurAvecPossibiliteAutre($('#universite_entreprise'), $('#valueAutreUniversite'));
	} else if ($('#typeSejour').val() =='entreprise'){
		$entreprise = recupererValeurAvecPossibiliteAutre($('#universite_entreprise'), $('#valueAutreEntreprise'));
	}
	
	
	var $langue = recupererValeurAvecPossibiliteAutre($('#langue'), $('#valueAutreLangue'));
	var $domaine = recupererValeurAvecPossibiliteAutre($('#domaine'), $('#valueAutreDomaine'));
	//TODO : ajouter la récupération du GPS

	var arguments = {
		Nom : $('#nom').text(),
		Prenom : $('#prenom').text(),
		Sexe : $('#sexe').text(),
		DateDebut : $('#dateDebut').val(),
		DateFin : $('#dateFin').val(),
		Continent : $('#continent').val(),
		Pays : $pays,
		Ville : $ville,
		Sejour : $('#typeSejour').val(),
		Mobilite : $('#typeMobilite').val(),
		Experience : $('#typeExperience').val(),
		Universite : $universite,
		Entreprise : $entreprise,
		Langue : $langue,
		Domaine : $domaine,
		Adresse : $('#adresse').val(),
		CheminFichier : $('#cheminFichier').val()
	};
	return arguments;
}

function recupererValeurAvecPossibiliteAutre(champs, champsAutre) {
	var valeur = '';
	if (champs.val() == 'Autre') {
		valeur = champsAutre.val();
	} else {
		valeur = champs.val();
	}
	return valeur;
}
