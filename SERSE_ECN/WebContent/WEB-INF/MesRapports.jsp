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
		<!-- Onglets du menu de navigation et en-tête de page-->
			<p><%@include file="menu.jsp" %></p>
		
		<!-- Champs des infos  -->
		<fieldset>
		<p>
			<br/>
			<br/>
			<br/>
			<form  align="center" id="bouttonSoumission" method="post" action="Soumission">
				<input type="submit" class="button" type="button" VALUE=" Soumettre un nouveau rapport">
			<form/>
			
			<br/>
			<br/>
			<br/>
			<table id="tableau">
				<thead>
					<tr>
						<th width="10px">Rapport<img src="Images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Date de soumission<img src="Images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Etat<img src="Images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Date du dernier changement d'etat<img src="Images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
						<th>Commentaire<img src="Images/iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><div align="center">UK_Semestre_Informatique<img src="Images/iconeTelechargemet.jpg" height="7%" width="5%" align="center"></div></td>
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