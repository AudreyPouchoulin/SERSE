<!-- 
 Utilisateurs : Etudiants
 Page : Mes Rapports
 Date création : 19/02/2014
-->

<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE Soumission de Rapports</title>
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="StyleSheet.css" />
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
				<li><a href="AccueilEtudiants.html"> Accueil </a></li>
				<!-- Liens a completer au fur et a mesure -->
				<li><a href="AccesRapportsEtudiants.html"> Acces aux rapports </a></li>
				<li class="active"><a href="MesRapportsEtudiants.html"> Mes Rapports </a></li>
				 </ul>
			</div>
		
		<!-- Champs des infos  -->
		<fieldset>
		<p>
			<br/>
			<br/>
			<br/>
			<div  align="center" id="bouttonSoumission"><INPUT class="envoiFormulaire" TYPE="button" VALUE=" Soumettre un nouveau rapport"><div/>
			
			<br/>
			<br/>
			<br/>
			<table id="tableau">
				<thead>
					<tr>
						<th width="10px">Rapport<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Date de soumission<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Etat<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Date du dernier changement d'etat<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Commentaire<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">UK_Semestre_Informatique<img src="iconeTelechargemet.jpg" height="7%" width="5%" align="center"></div></td>
						<td>01/09/2013</td>
						<td>En attente de validation</td>
						<td>12/12/2013</td>
						<td>RAS</td>
					</tr>
				</tbody>
			</table>
		</p>		
		</fieldset>
	</body>
</html>