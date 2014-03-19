/**
 * Project: SERSE_ECN Creation date: 04 mar. 2014 Author: Audrey Bouton Reset,
 * Valider, Envoyer
 */

function soumettre(argumentsJson){
	$.post('SoumissionRapportServlet', argumentsJson, function(responseJson){
	     alert(responseJson);
   });
}

function recupererArguments() {
	var $pays = recupererValeurAvecPossibiliteAutre($('#pays'), $('#valueAutrePays'));
	var $ville = recupererValeurAvecPossibiliteAutre($('#ville'), $('#valueAutreVille'));
	var $universite = recupererValeurAvecPossibiliteAutre($('#universite_entreprise'), $('#valueAutreUniversite'));
	var $entreprise = recupererValeurAvecPossibiliteAutre($('#universite_entreprise'), $('#valueAutreEntreprise'));
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
