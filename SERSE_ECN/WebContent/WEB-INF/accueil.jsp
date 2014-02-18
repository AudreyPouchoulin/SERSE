<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"
	import="java.util.ArrayList"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SERSE</title>
	</head>
	
	<script type="text/javascript" src="scripts/XMLHttpRequest.js"></script>
	<script type="text/javascript" src="scripts/recherche.js"></script>

	<body>
		<p>
			<% 
				String personne = (String) request.getAttribute("personne_connectee");
				String role = (String) request.getAttribute("type_connexion");
				out.println("Bienvenue " + personne + ", vous êtes connecté comme " + role + ".");
			%>
		</p>
			
			
			<select name="Continent" id="continent" onclick="getContinents();">
				<option value="Choose a continent" selected="selected">Choose a continent with javascript ajax</option>
			</select>	
			
			<% 
					ArrayList<String> listeContinents =  new ArrayList<String>();
					listeContinents = (ArrayList<String>) request.getAttribute("continents");
					if (listeContinents!=null){
						for (int i=0; i<listeContinents.size(); i++){
							out.println(listeContinents.get(i));
						}
					}
				%>		
	</body>
</html>