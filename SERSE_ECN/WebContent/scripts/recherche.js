/**
 * 
 */
	$(init);
	
	function init() {
	$(document).ready(function() { 
        $.post('ContinentServlet',null,function(responseJson) {  
	            var $select = $('#continent'); 
	            $select.find('option').remove();
	            $select.find('option').remove(); 
	            $select.append('<option value="'+ 0 +'">'+ 'Choose a continent' +'</option>');
            	$.each(responseJson, function(key, value) {               
                	$('<option>').val(key).text(value).appendTo($select); 
             });
        });
 });
	}
	
	/*function getContinents(){
			var xhr = getXMLHttpRequest();
			xhr.open("POST", "ContinentServlet", true);
			xhr.send(null);
			//xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
				alert("OK");
			}	
		}*/    