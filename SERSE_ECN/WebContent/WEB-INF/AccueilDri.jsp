<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- 
 Utilisateurs : DRI
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
				<li class="active"><a href="AccueilDri"> Accueil </a></li>
				<li><a href="AccueilDri"> Acces aux rapports </a></li>
				<li><a href="ValidationRapport"> Rapports a valider </a></li>
				<li><a href="GestionRapport"> Gerer les rapports </a></li>
				<li><a href="PreferenceDri"> Preferences </a></li>
				</ul>
			</div>
					
			<br/>
			<br/>
			<br/>
			<fieldset class="fieldsetWelcome">

			<div align="center"><h1>Bonjour </h1></div>
			<div class="textWelcome">
				<div class="textWelcome">  Vous avez : </div>	
					<div class="textWelcome">
						<% 
							Integer nbrValider = (Integer) request.getAttribute("nbrRapportsValider");
							out.println( nbrValider + " ");
						%>
					 Rapports a valider </div>	
					<div class="textWelcome"> 
						<% 
							Integer nbrLigne = (Integer) request.getAttribute("nbrRapportsLigne");
							out.println( nbrLigne  + " ");
						%>					
					Rapports en attente de mise en ligne <br/></div>	
				
			</div>		
			</fieldset>
	</body>
</html>