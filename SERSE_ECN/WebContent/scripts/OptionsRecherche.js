/**
 * 
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
	     	
	     // remplissage de la liste déroulante de villes
	        $.post('OptionsServlet',{nom_liste:'ville'},function(responseJson) {  
		            var $select = $('#ville'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante d'universités et entreprises
	        $.post('OptionsServlet',{nom_liste:'université et entreprise'},function(responseJson) {  
		            var $select = $('#universite_entreprise'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante des domaines d'activité
	        $.post('OptionsServlet',{nom_liste:'domaine'},function(responseJson) {  
		            var $select = $('#domaine'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante des langues
	        $.post('OptionsServlet',{nom_liste:'langue'},function(responseJson) {  
		            var $select = $('#langue'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // cochage/décochage de la case Professionnel
	      $('#cadreProfessionnel').click(function() {
	    	  var cases = $("#casesCadreProfessionnel").find(':checkbox'); 
	    	  if(this.checked){
	    		  cases.prop('checked', true);
	    	  }else{
	    		  cases.prop('checked', false);
	    	  };         
	      });
	     
	     // cochage/décochage de la case Académique
	      $('#cadreAcademique').click(function() {
	    	  var cases = $("#casesCadreAcademique").find(':checkbox'); 
	    	  if(this.checked){
	    		  cases.prop('checked', true);
	    	  }else{
	    		  cases.prop('checked', false);
	    	  };         
	      });
	     
	     // TODO: si décochage de toutes les sous-cases, décochage de Académique
	     // TODO: si décochage de toutes les sous-cases, décochage de Professionnel
	 });