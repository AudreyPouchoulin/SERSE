<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
 Utilisateurs : Administrateur
 Page : Preferences
 Date création : 22/02/2014
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
				<li><a href="AccueilAdmin.html"> Accueil </a></li>
				<li><a href="AccesRapportAdmin.html"> Acces aux rapports </a></li>
				<li><a href="ValidationOptionsAdmin.html"> Options a valider </a></li>
				<li><a href="ModificationOptionsAdmin.html"> Gerer les options </a></li>
				<li class="active"><a href="AboDesaboAdmin.html"> Preferences </a></li>
				</ul>
			</div>
			
			
			<br/>
			<br/>
			<br/>
			<fieldset>
			<h4> <legend>Gestions des preferences</legend> <Gestions des preferences> </h4>
			<p align="center">
				<input type="checkbox" name="admin_notification" id="sejourUniversite" />
				<label for="admin_notification">Recevoir les notifications par email quand une nouvelle demande d'ajout d'option est faite</label>	
			</p>
			
			<p align="right">
				<INPUT TYPE="button" VALUE="Sauvegarder mes nouvelles preferences"/>
			</p>
			
			</fieldset>
	</body>
</html>