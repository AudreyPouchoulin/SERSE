/**
 * Project: SERSE_ECN
 * Creation date: 26 fev. 2014
 * Author: Audrey
 * Gestion du remplissage des options de filtres
 */

/** remplissage de la liste déroulante de continents*/
	function remplissageContinent(){
        $.post('OptionsServlet',{nom_liste:'continent', message_defaut:$("#continent" ).text()},function(responseJson) {  
	            var $select = $('#continent'); 
	            fillOptions($select, responseJson);
        });
	}

/** remplissage de la liste déroulante de pays
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissagePays(avecAutre){
		 $.post('OptionsServlet',{nom_liste:'pays', message_defaut:$("#pays" ).text()},function(responseJson) {  
	            var $select = $('#pays'); 
	            fillOptions($select, responseJson);
	            if (avecAutre){
	            	addOptionAutre($select);
	            }
		 });
	}
	
/** remplissage de la liste déroulante de villes 
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissageVille(avecAutre){
	    $.post('OptionsServlet',{nom_liste:'ville', message_defaut:$("#ville" ).text()},function(responseJson) {  
	            var $select = $('#ville'); 
	            fillOptions($select, responseJson);
	            if (avecAutre){
	            	addOptionAutre($select);
	            }
	    });
	}	

/** remplissage des universités de la liste déroulante d'universités/entreprises
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissageUniversite(avecAutre){
	        $.post('OptionsServlet',{nom_liste:'université'},function(responseJson) {  
		            var $select = $('#universiteGroup'); 
		            fillOptions($select, responseJson);
		            if (avecAutre){
		            	addOptionAutre($select);
		            }
	        });
	}

/** remplissage des entreprises de la liste déroulante d'universités/entreprises
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissageEntreprise(avecAutre){
	        $.post('OptionsServlet',{nom_liste:'entreprise'},function(responseJson) {  
	            var $select = $('#entrepriseGroup'); 
	            fillOptions($select, responseJson);
	            if (avecAutre){
	            	addOptionAutre($select);
	            }
	        });
	}

	     
/** remplissage de la liste déroulante des domaines d'activité
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissageDomaineActivite(avecAutre){
	        $.post('OptionsServlet',{nom_liste:'domaine', message_defaut:$("#domaine" ).text()},function(responseJson) {  
		            var $select = $('#domaine'); 
		            fillOptions($select, responseJson);
		            if (avecAutre){
		            	addOptionAutre($select);
		            }
	        });
	}

	     
/** remplissage de la liste déroulante des langues 
 * @param avecAutre : booléen vrai si il est nécessaire d'ajouter un champs "Autre", faux sinon
 */
	function remplissageLangue(avecAutre){
	        $.post('OptionsServlet',{nom_liste:'langue', message_defaut:$("#langue" ).text()},function(responseJson) {  
		            var $select = $('#langue'); 
		            fillOptions($select, responseJson);
		            if (avecAutre){
		            	addOptionAutre($select);
		            }
	        });
	}
	
/** remplissage de la liste déroulante des types de séjour
 */
	function remplissageTypeSejour(){
	        $.post('OptionsServlet',{nom_liste:'sejour', message_defaut:$("#typeSejour" ).text()},function(responseJson) {  
		            var $select = $('#typeSejour'); 
		            fillOptions($select, responseJson);
	        });
	}
	
/** remplissage de la liste déroulante des types de mobilité
 */
	function remplissageTypeMobilite(){
	        $.post('OptionsServlet',{nom_liste:'mobilite', message_defaut:$("#typeMobilite" ).text()},function(responseJson) {  
		            var $select = $('#typeMobilite'); 
		            fillOptions($select, responseJson);
	        });
	}

/** remplissage de la liste déroulante des types de mobilité
 */
	function remplissageTypeExperience(){
	        $.post('OptionsServlet',{nom_liste:'experience', message_defaut:$("#typeExperience" ).text()},function(responseJson) {  
		            var $select = $('#typeExperience'); 
		            fillOptions($select, responseJson);
	        });
	}
	
/** remplir les options à partir des données renvoyées par la base de données 
 *@param liste : liste déroulante à remplir
 *@param responseJson: réponse au format JSON
 */
	function fillOptions(liste, responseJson){
		liste.find('option').remove();
     	$.each(responseJson, function(key, value) {               
         	$('<option>').val(key).text(value).appendTo(liste); 
      });
	}
	
/** ajouter l'option "Autre"
 *@param liste : liste déroulante à laquelle rajouter l'option "Autre"
 */
	function addOptionAutre(liste){
		$('<option>').val('Autre').text('Autre').appendTo(liste); 
	}