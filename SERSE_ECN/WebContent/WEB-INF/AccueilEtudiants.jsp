<!-- 
 Utilisateurs : Etudiants
 Page : Accueil
 Date création : 19/02/2014
-->

<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SERSE Soumission de Rapports</title>
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="StyleSheet1.css" />
	</head>

	<body>
	
		<p>
			<% 
				String message = (String) request.getAttribute("message_bienvenue");
				out.println(message);
			%>
		</p>
		
		<!-- Onglets du menu de navigation -->
			<div id="menu">
				 <ul id="onglets">
					 <!-- Liens a completer au fur et a mesure -->
					<li class="active"><a href="Accueil"> Accueil </a></li>
					<li><a href="Recherche"> Acces aux rapports </a></li>
					<li><a href="MesRapports" href="#"> Mes Rapports </a></li>
				 </ul>
			</div>
			
			<br/>
			<br/>
			<br/>

			<p><h1 align="center"> Bienvenue sur SERSE ! </h1></p>		
			<p align="center">La date limite de soumission des rapports pour l'annee 2013-2014 est le 29/09/2014</p>	


		
	</body>
</html>