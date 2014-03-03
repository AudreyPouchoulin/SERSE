/**
 * Project: SERSE_ECN
 * Creation date: 26 fev. 2014
 * Author: Audrey
 * Gestion du remplissage des options de filtres pour la recherche de rapport ou la soumission d'un nouveau rapport
 */

	$(document).ready(function() { 
		
/** remplissage de la liste déroulante de continents*/
	        $.post('OptionsServlet',{nom_liste:'continent', message_defaut:$("#continent" ).val()},function(responseJson) {  
		            var $select = $('#continent'); 
		            fillOptions($select, responseJson);
	        });
			
/** remplissage de la liste déroulante de pays*/
	        $.post('OptionsServlet',{nom_liste:'pays', message_defaut:$("#pays" ).val()},function(responseJson) {  
		            var $select = $('#pays'); 
		            fillOptions($select, responseJson);
	        });
	     	
/** remplissage de la liste déroulante de villes */
	        $.post('OptionsServlet',{nom_liste:'ville', message_defaut:$("#ville" ).val()},function(responseJson) {  
		            var $select = $('#ville'); 
		            fillOptions($select, responseJson);
	        });
	     
/** remplissage de la liste déroulante d'universités et entreprises */
	        $.post('OptionsServlet',{nom_liste:'université'},function(responseJson) {  
		            var $select = $('#universiteGroup'); 
		            fillOptions($select, responseJson);
	        });
	        $.post('OptionsServlet',{nom_liste:'entreprise'},function(responseJson) {  
	            var $select = $('#entrepriseGroup'); 
	            fillOptions($select, responseJson);
	        });
	     
/** remplissage de la liste déroulante des domaines d'activité*/
	        $.post('OptionsServlet',{nom_liste:'domaine', message_defaut:$("#domaine" ).val()},function(responseJson) {  
		            var $select = $('#domaine'); 
		            fillOptions($select, responseJson);
	        });
	     
/** remplissage de la liste déroulante des langues */
	        $.post('OptionsServlet',{nom_liste:'langue', message_defaut:$("#langue" ).val()},function(responseJson) {  
		            var $select = $('#langue'); 
		            fillOptions($select, responseJson);
	        });
	 });
	
	function fillOptions($select, responseJson){
		$select.find('option').remove();
     	$.each(responseJson, function(key, value) {               
         	$('<option>').val(key).text(value).appendTo($select); 
      });
	}