<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 
 Utilisateurs : Dri
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
				<li><a href="AccueilDri.html"> Accueil </a></li>
				<!-- Liens a completer au fur et a mesure -->
				<li><a href="AccesRapportDri.html"> Acces aux rapports </a></li>
				<li><a href="ValidationRapportsDri.html"> Rapports a valider </a></li>
				<li><a href="RapportsMiseEnLigneDri.html"> Gerer les rapports </a></li>
				<li class="active"><a href="AboDesaboDri.html"> Preferences </a></li>
				</ul>
			</div>
			
			<br/>
			<br/>
			<br/>
			<fieldset>
			<h2> <legend>Gestions des preferences</legend> <Gestions des preferences> </h2>
			<p align="center">
				<input type="checkbox" name="dri_notification_assigation" id="sejourUniversite" />
				<label for="dri_notification_assigation">Recevoir les notifications par email quand un rapport m'est assigne</label>	
			</p>
			
			<p align="center">
				<input type="checkbox" name="dri_notification_rapport" id="sejourUniversite" />
				<label for="dri_notification_rapport">Recevoir les notifications par email quand une nouveau rapport est soumis en ligne</label>	
			</p>
			
			<p align="right">
				<INPUT TYPE="button" VALUE="Sauvegarder mes nouvelles preferences"/>
			</p>
			
			</fieldset>
	</body>
</html>