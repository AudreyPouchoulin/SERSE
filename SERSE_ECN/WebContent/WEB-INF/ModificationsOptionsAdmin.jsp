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
			<div id="menu">
				 <ul id="onglets">
				<li><a href="AccueilAdmin.html"> Accueil </a></li>
				<li><a href="AccesRapportAdmin.html"> Acces aux rapports </a></li>
				<li><a href="ValidationOptionsAdmin.html"> Options a valider </a></li>
				<li class="active"><a href="ModificationOptionsAdmin.html"> Gerer les options </a></li>
				<li><a href="AboDesaboAdmin.html"> Preferences </a></li>
				</ul>
			</div>
			
			<fieldset class="fieldSetdAdminTypeOption">
			<h4> <legend>Types d'option</legend> <Types d'option> </h4>
			
			<select name="sometext" multiple="multiple" class="listBoxTypesOptions">
				<option>Universités</option>
				<option>Entreprises</option>
				<option>Pays</option>
				<option>Villes</option>
				<option>Langues</option>
				<option>Types Mobilites</option>
				<option>Types Experience</option>
				<option>Types Sejour</option>
			</select>	
			
			<INPUT TYPE="button" VALUE="Ajouter un nouveau type d'option" class="buttonAdminGestionOption" align="center"/> </br>	
			<INPUT TYPE="button" VALUE="Modifier un type d'option" class="buttonAdminGestionOption" align="center"/> </br>	
			<INPUT TYPE="button" VALUE="Supprimer un type d'option" class="buttonAdminGestionOption" align="center"/>

			</fieldset>
			
			
			<fieldset class="fieldSetdAdminOption">
			<h4> <legend> Options disponibles </legend> <Options disponibles> </h4>
							<table id="tableau" align="center">
				<thead>
					<tr>
						<th height="8" id="tableau" width="25%"> Pays<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th height="8" id="tableau" width="25%"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">Ukraine</div></td>
						<td>
							<div align="center">
							<INPUT TYPE="button" VALUE="Renommer"/>
							<INPUT TYPE="button" VALUE="Supprimer"/>
							</div>
						</td>

					</tr>
				</tbody>
				</table>
				
				</br>
				</br>
			
				<INPUT TYPE="button" VALUE="Ajouter une nouvelle option" align="right"/>

			</fieldset>
	</body>
</html>