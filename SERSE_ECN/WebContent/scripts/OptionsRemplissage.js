/**
 * Project: SERSE_ECN
 * Creation date: 26 fev. 2014
 * Author: Audrey
 * Gestion du remplissage des options de filtres pour la recherche de rapport ou la soumission d'un nouveau rapport
 */

	$(document).ready(function() { 
		
/** remplissage de la liste déroulante de continents*/
	        $.post('OptionsServlet',{nom_liste:'continent'},function(responseJson) {  
		            var $select = $('#continent'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
			
/** remplissage de la liste déroulante de pays*/
	        $.post('OptionsServlet',{nom_liste:'pays'},function(responseJson) {  
		            var $select = $('#pays'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     	
/** remplissage de la liste déroulante de villes */
	        $.post('OptionsServlet',{nom_liste:'ville'},function(responseJson) {  
		            var $select = $('#ville'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
/** remplissage de la liste déroulante d'universités et entreprises */
	        $.post('OptionsServlet',{nom_liste:'université'},function(responseJson) {  
		            var $select = $('#universiteGroup'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	        $.post('OptionsServlet',{nom_liste:'entreprise'},function(responseJson) {  
	            var $select = $('#entrepriseGroup'); 
	            $select.find('option').remove();
            	$.each(responseJson, function(key, value) {               
                	$('<option>').val(key).text(value).appendTo($select); 
             });
        });
	     
/** remplissage de la liste déroulante des domaines d'activité*/
	        $.post('OptionsServlet',{nom_liste:'domaine'},function(responseJson) {  
		            var $select = $('#domaine'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
/** remplissage de la liste déroulante des langues */
	        $.post('OptionsServlet',{nom_liste:'langue'},function(responseJson) {  
		            var $select = $('#langue'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	 });