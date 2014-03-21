/**
 * Project: SERSE_ECN 
 * Creation date: 04 mar. 2014 
 * Author: Audrey 
 * Récupération des arguments du formulaire, envoie de ces données au serveur
 */

/**
 * Dépôt d'un rapport sur le serveur
 * @param argumentsJson données JSON à envoyer au serveur pour déposer un rapport
 */
function soumettre(argumentsJson){
	$.post('SoumissionRapportServlet', argumentsJson, function(responseJson){
	     if (responseJson==true){
	    	 initialiserDialogFinSoumission();
	     } else {
	    	 alert("Un problème a été rencontré lors de la soumission du rapport. Merci de contacter votre administrateur système.");
	     }
   });
}

/**
 * Récupérer les données de depôt de rapport réparties sur la page
 * @returns données au format JSON
 */
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

/**
 * Récupérer la valeur d'une liste déroulante, pouvant contenur une option 'Autre'
 * @param champs liste d'options où l'option Autre a pu être sélectionnée
 * @param champsAutre lieu où se trouve l'entrée utilisateur si l'option autre a été sélectionné
 * @returns {String}
 */
function recupererValeurAvecPossibiliteAutre(champs, champsAutre) {
	var valeur = '';
	if (champs.val() == 'Autre') {
		valeur = champsAutre.val();
	} else {
		valeur = champs.val();
	}
	return valeur;
}
