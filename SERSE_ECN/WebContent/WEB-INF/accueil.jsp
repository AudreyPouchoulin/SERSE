<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"
	import="java.util.ArrayList"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SERSE</title>
	</head>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="scripts/recherche.js"></script>
	<script>
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
	</script>

	<body>
		<p>
			<% 
				String personne = (String) request.getAttribute("personne_connectee");
				String role = (String) request.getAttribute("type_connexion");
				out.println("Bienvenue " + personne + ", vous êtes connecté comme " + role + ".");
			%>
		</p>
			
			
			<select name="Continent" id="continent"">
				<!-- options are filled by AJAX -->
			</select>	
			
	</body>
</html>