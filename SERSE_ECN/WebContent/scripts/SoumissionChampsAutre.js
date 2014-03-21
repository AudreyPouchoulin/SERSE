/**
 * Project: SERSE_ECN
 * Creation date: 3 mar. 2014
 * Author: Audrey
 * Affichage du champs d'écriture lors de la soumission des rapports pour les champs "Autre" de:
 * - pays
 * - ville
 * - université
 * - entreprise
 * - langue
 * - domaine d'activité
 */

/**
 * Affiche ou non le champs 'Autre' pour entrée de l'utilisateur
 * @param champs liste d'options où l'option Autre a pu être sélectionnée
 * @param autreChamps champs à afficher si l'option 'Autre' a été sélectionnée
 */
function gestionAutre(champs, autreChamps){
	if (champs.val() == 'Autre'){
		autreChamps.show();
	} else {
		autreChamps.hide();
	}
}