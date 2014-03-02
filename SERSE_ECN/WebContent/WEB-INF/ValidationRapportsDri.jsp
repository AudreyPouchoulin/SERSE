<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 

 Utilisateurs : DRI
 Page : Rapports a valider ou invalider
 Date création : 23/02/2014
 
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
				<li class="active"><a href="ValidationRapportsDri.html"> Rapports a valider </a></li>
				<li><a href="RapportsMiseEnLigneDri.html"> Gerer les rapports </a></li>
				<li><a href="AboDesaboDri.html"> Preferences </a></li>
				</ul>
			</div>
			
			<fieldset class="fieldSetDriFieldSet">
			<h2> <legend>Resultats</legend> <Resultats> </h2>

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
						<th height="10" id="tableau" width="20%">Titre <img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="15%">Date soumission<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="10%">Pays<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="12%">Etat<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="13%">Type experience<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="15%">Rapports assigne a<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th id="tableau" width="20%">Actions</th>
						<th id="tableau" width="40%"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">UK_Semestre_Informatique.pdf <img src="iconeTelechargemet.jpg" height="7%" width="10%" align="center"></div></td>
						<td><div align="center">07/12/2013</div></td>
						<td><div align="center">Royaume-Uni</div></td>
						<td><div align="center">Attente validation</td>
						<td><div align="center">Academique</td>
						<td><div align="center">
							<select name="correcteur" id="continent" onChange="viewOthers()" />
							
							<option value="DRI" selected="selected">DRI</option>
			 				<option value="MichaelHombrouck ">Michael Hombrouck</option>
												
						</select>
						
						</td>
						<td>
							<div align="center">
							<INPUT TYPE="button" VALUE="Valider"/>
							<INPUT TYPE="button" VALUE="Invalider"/>
							<br/>
							<INPUT TYPE="button" VALUE="Visualiser toutes les infos"/>
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