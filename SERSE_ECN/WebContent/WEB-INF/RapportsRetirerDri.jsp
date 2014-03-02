<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<!-- 
 Utilisateurs : DRI
 Page : Rapports à mettre en ligne
 Date création : 22/02/2014
-->

<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE Soumission de Rapports</title>
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="StyleSheet.css" />
	</head>

	<body>
		<!-- Onglets du menu de navigation -->
			<div id="menu">
				 <ul id="onglets">
				<li><a href="AccueilDri.html"> Accueil </a></li>
				<!-- Liens a completer au fur et a mesure -->
				<li><a href="AccesRapportDri.html"> Acces aux rapports </a></li>
				<li><a href="ValidationRapportsDri.html"> Rapports a valider </a></li>
				<li class="active"><a href="RapportsMiseEnLigneDri.html"> Gerer les rapports </a></li>
				<li><a href="AboDesaboDri.html"> Preferences </a></li>
				</ul>
			</div>

			
			<!-- Liste des deux categories de rapports -->
			<select name="sometext" multiple="multiple" class="listBox">
				<option>Rapports valides prets a etre mis en ligne</option>
				<option>Rapports en ligne</option>
			</select>
			
			<fieldset class="fieldSetDriFieldSet">
			<h2> <legend>Rapports prets a etre mis en ligne</legend> <Rapports prets a etre mis en ligne> </h2>

				<table id="tableau" align="center">
				<thead>
					<tr>
						<th height="10" id="tableau" width="25%">Rapport <img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau">Dates validation<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau">Etat<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="40%"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">UK_Semestre_Informatique.pdf <img src="iconeTelechargemet.jpg" height="7%" width="7%" align="center"></div></td>
						<td><div align="center">07/07/2012</div></td>
						<td><div align="center">En attente de publication</div></td>
						<td>
							<div align="center">
							<INPUT TYPE="button" VALUE="Voir toutes les infos"/>
							<INPUT TYPE="button" VALUE="Mettre en ligne"/>
							</div>
						</td>

					</tr>
				</tbody>
				</table>
			<br/>
			<br/>
			<div align="right"><< Precedente | Page Suivante >></div>
			</fieldset>
	</body>
</html>