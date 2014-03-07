<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
 Utilisateurs : Admin
 Page : Accueil
 Date création : 19/02/2014
-->

<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE Soumission de Rapports</title>
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="styles/StyleSheet.css" />
	</head>

	<body>
		<!-- Onglets du menu de navigation -->
			<div id="menu">
				 <ul id="onglets">
				<li class="active"><a href="/AccueilAdmin"> Accueil </a></li>
				<li><a href="/AccueilAdmin"> Acces aux rapports </a></li>
				<li><a href="/AccueilAdmin"> Options a valider </a></li>
				<li><a href="/AccueilAdmin"> Gerer les options </a></li>
				<li><a href="/AccueilAdmin"> Preferences </a></li>
				</ul>
			</div>
			
			<br/>
			<br/>
			<br/>
			<fieldset class="fieldsetWelcome">
			<div align="center"><h1>Bonjour </h1></div>
			<div class="textWelcome">
				<div class="textWelcome">  Vous avez : </div>	
				<br/>
				<div class="textWelcome">
					<% 
						Integer nbrOption = (Integer) request.getAttribute("nbrOptionsValider");
						out.println( nbrOption + " ");
					%>
				options a valider </div>	
				
			</div>		
			</fieldset>
			
			</fieldset>
	</body>
</html>