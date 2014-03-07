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
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="styles/StyleSheet.css" />
	</head>

	<body>
		<!-- Onglets du menu de navigation -->
			<div id="menu">
				 <ul id="onglets">
				<li><a href="AccueilAdmin.html"> Accueil </a></li>
				<li><a href="AccesRapportAdmin.html"> Acces aux rapports </a></li>
				<li class="active"><a href="ValidationOptionsAdmin.html"> Options a valider </a></li>
				<li><a href="ModificationOptionsAdmin.html"> Gerer les options </a></li>
				<li><a href="AboDesaboAdmin.html"> Preferences </a></li>
				</ul>
			</div>
			
			<fieldset class="fieldSetDriFieldSet">
			<h4> <legend>Options a valider</legend> <Rapports prets a etre mis en ligne> </h4>

				<select name="resultatPage" id="resultatPage" onChange="viewOthers()" />
					<option value="Resutalts par page" selected="selected">Resultats par page</option>
					<option value="10resultats">10 R괵ltats</option>
					<option value="20resultats">20 R괵ltats</option>
					<option value="30resultats">30 R괵ltats</option>
					<option value="40resultats">40 R괵ltats</option>
					<option value="50resultats">50 R괵ltats</option>
				</select>
			
				<br/>
				<br/>
				<table id="tableau" align="center">
				<thead>
					<tr>
						<th height="10" id="tableau" width="20%">Categorie <img src="images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="15%">Propose par<img src="images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="15%">Date proposition<img src="images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="20%">Nouvelle valeur proposee<img src="images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="40%"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">Pays</div></td>
						<td><div align="center">Clara DOUCOURE</div></td>
						<td><div align="center">07/12/2013</div></td>
						<td><div align="center"> Mali  <INPUT TYPE="button" VALUE="Modifier"/></div></td>
						<td>
							<div align="center">
							<INPUT TYPE="button" VALUE="Valider"/>
							<INPUT TYPE="button" VALUE="Invalider"/>
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