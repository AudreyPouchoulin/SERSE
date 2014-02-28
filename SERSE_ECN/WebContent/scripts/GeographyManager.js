/**
 * 
 */
$(document).ready(function() {
	$('#continent').change(function() {
		var $arguments = recherche();
		$.post('RechercheServlet', $arguments,function(responseJson){
		            fillResults(responseJson);
	        });
	});
});
