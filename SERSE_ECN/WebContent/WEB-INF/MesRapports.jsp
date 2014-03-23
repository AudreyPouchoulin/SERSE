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
		<link rel="stylesheet" type="text/css" href="styles/serse_main.css"/>
		<script type="text/javascript" src="scripts/jquery/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="scripts/menu.js"></script>
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
				<form  method="post" action="Soumission">
					<input id="button_Soumission" type="submit" class="button" type="button" VALUE=" Soumettre un nouveau rapport">
				</form>
				<br/>
				<br/>
				<br/>
				
				<table id="tableau">
					<thead>
						<tr>
							<th>Rapport<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
							<th>Date de soumission<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
							<th>Etat<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
							<th>Date du dernier changement d'etat<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
							<th>Commentaire<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						</tr>
					</thead>
					
					<tbody>
						<tr>
							<td><div>UK_Semestre_Informatique<img src="images/iconeTelechargemet.jpg" height="7%" width="5%"></div></td>
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