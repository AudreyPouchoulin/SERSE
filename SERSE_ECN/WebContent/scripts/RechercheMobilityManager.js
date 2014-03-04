/**
 * Project: SERSE_ECN
 * Creation date: 26 fev. 2014
 * Author: Audrey
 * Gestion des cases à cocher (cochage/décochage en fonction de la hierarchie)
 *  dans le cadre mobilité pour la page de recherche de rapports
 */

$(document).ready(function() {

/** cochage/décochage de la case Professionnel*/
	      $('#cadreProfessionnel').click(function() {
	    	  var cases = $("#casesCadreProfessionnel").find(':checkbox'); 
	    	  if(this.checked){
	    		  cases.prop('checked', true);
	    	  }else{
	    		  cases.prop('checked', false);
	    	  };         
	      });
	     
/** cochage/décochage de la case Académique */
	      $('#cadreAcademique').click(function() {
	    	  var cases = $("#casesCadreAcademique").find(':checkbox'); 
	    	  if(this.checked){
	    		  cases.prop('checked', true);
	    	  }else{
	    		  cases.prop('checked', false);
	    	  };         
	      });
	     
/** si décochage de toutes les sous-cases, décochage de Professionel 
 *  si cochage d'une case sous professionel, cochage de Professionel
 */
	      $('#pCME').click(function() {
	    	  cocheDecochePro(this);
	      });
	      $('#pSTING').click(function() {
	    	  cocheDecochePro(this);
	      });
	      $('#pTFE').click(function() {
	    	  cocheDecochePro(this);
	      });
	      $('#pCesure').click(function() {
	    	  cocheDecochePro(this);
	      });
	      $('#pSemestre').click(function() {
	    	  cocheDecochePro(this);
	      });
	      
	      
	      function cocheDecochePro(caseClic){
	    	  if (caseClic.checked){
	    		  $('#cadreProfessionnel').prop('checked', true);
	    	  } else if (!($('#pCME').prop('checked')) & !($('#pSTING').prop('checked')) & !($('#pTFE').prop('checked')) & !($('#pCesure').prop('checked')) & !($('#pSemestre').prop('checked'))){
	    		  $('#cadreProfessionnel').prop('checked', false);
	    	  };
	      }
	      
/** si décochage de toutes les sous-cases, décochage de Académique
*  si cochage d'une case sous académique, cochage de Académique
*/
	      $('#aSemestre').click(function() {
	    	  cocheDecocheAca(this);
	      });
	      $('#aAnnee').click(function() {
	    	  cocheDecocheAca(this);
	      });
	      $('#aDoubleDiplome').click(function() {
	    	  cocheDecocheAca(this);
	      });
	      $('#aCesure').click(function() {
	    	  cocheDecocheAca(this);
	      });
	      
	      
	      function cocheDecocheAca(caseClic){
	    	  if (caseClic.checked){
	    		  $('#cadreAcademique').prop('checked', true);
	    	  } else if (!($('#aSemestre').prop('checked')) & !($('#aAnnee').prop('checked')) & !($('#aDoubleDiplome').prop('checked')) & !($('#aCesure').prop('checked'))){
	    		  $('#cadreAcademique').prop('checked', false);
	    	  };
	      }
	      
});