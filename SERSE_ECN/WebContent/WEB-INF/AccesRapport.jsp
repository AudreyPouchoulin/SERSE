<!-- 
 Utilisateurs : Etudiants
 Page : Recherche de Rapports
 Date création : 14/02/2014
-->

<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE Recherches de Rapports </title>
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="StyleSheet.css" />
	</head>

	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		$(document).ready(function() { 
			// remplissage de la liste déroulante de continents
	        $.post('OptionsServlet',{nom_liste:'continent'},function(responseJson) {  
		            var $select = $('#continent'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
			
	     	// remplissage de la liste déroulante de pays
	        $.post('OptionsServlet',{nom_liste:'pays'},function(responseJson) {  
		            var $select = $('#pays'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     	
	     // remplissage de la liste déroulante de villes
	        $.post('OptionsServlet',{nom_liste:'ville'},function(responseJson) {  
		            var $select = $('#ville'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante d'universités et entreprises
	        $.post('OptionsServlet',{nom_liste:'université et entreprise'},function(responseJson) {  
		            var $select = $('#universite_entreprise'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante des domaines d'activité
	        $.post('OptionsServlet',{nom_liste:'domaine'},function(responseJson) {  
		            var $select = $('#domaine'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	     
	     // remplissage de la liste déroulante des langues
	        $.post('OptionsServlet',{nom_liste:'langue'},function(responseJson) {  
		            var $select = $('#langue'); 
		            $select.find('option').remove();
	            	$.each(responseJson, function(key, value) {               
	                	$('<option>').val(key).text(value).appendTo($select); 
	             });
	        });
	 });
	</script>

	<body>
		<p>
			<% 
				String message = (String) request.getAttribute("message_bienvenue");
				out.println(message);
			%>
		</p>
	
		<h1>SERSE</h1>
		
		<!-- Onglets du menu de navigation -->
			<div id="menu">
				 <ul id="onglets">
					 <!-- Liens a completer au fur et a mesure -->
					<li ><a href="Accueil"> Accueil </a></li>
					<li class="active"><a href="Recherche"> Acces aux rapports </a></li>
					<li><a href="MesRapports" href="#"> Mes Rapports </a></li>
				 </ul>
			</div>

		<!-- paragraphe "Criteres de recherche"-->
		<p>
		<fieldset>
			<h2> <legend>Criteres de recherche</legend> <Criteres de recherche> </h2>
			<p>
			
			
			<!-- Sous-paragraphe "Continent, Pays, Ville"-->
			<p>
			<fieldset>
			<img src="iconeInformation.jpg" height="7%" width="3%" align="right" class="imageflottante">
			<h3> <legend>Continent Pays, Ville</legend> <Criteres de recherche> </h3>
				<!-- "Continent"-->
						<p>
						<select name="continent" id="continent"/>
							<option value="Tous les continents" selected="selected">Tous les continents</option>
							<!-- options are filled by AJAJ -->						
						</select>
						</p>
						
				<!-- "Pays"-->
						<p>
						<select name="pays" id="pays" />
							<option value="Tous les pays" selected="selected">Tous les pays</option>
							<!-- options are filled by AJAJ -->	
						</select>
						</p>

				<!-- "Ville"-->
						<p>
						<select name="ville" id="ville"/>
							<option value="Toutes les villes" selected="selected">Toutes les villes</option>
								<!-- options are filled by AJAJ -->
						</select>
						</p>
			</fieldset>
			</p>
			
			
			<!-- Sous-paragraphe Séjour"-->
			<p>
			<fieldset>
				<h2> <legend>Sejour</legend> <Sejour> </h2>
				<p>
				<table id="invisibleTable" WIDTH=500>
				<tr id="invisibleTable">
				<td id="invisibleTable"><input type="checkbox" name="sejourUniversite" id="sejourUniversite" /> <label for="sejourUniversite">Universite</label></td>
				<td id="invisibleTable"><input type="checkbox" name="sejourEntreprise" id="sejourEntreprise" /> <label for="sejourEntreprise">Entreprise</label></td>
				</tr>
				</table>
				</p>		
			</fieldset>
			</p>

			<!-- Sous paragraphe Cadre de mobilite"-->
			<p>
			<fieldset>
				<h2> <legend>Cadre de mobilite</legend> <Cadre de mobilite> </h2>
				
				<table WIDTH=600 id="invisibleTable" >
				<tr id="invisibleTable">
					<td id="invisibleTable"><input type="checkbox" name="cadreProfessionnel" id="cadreProfessionnel" /> <label for="cadreProfessionnel">Professionnel</label></td>
					<td id="invisibleTable"><input type="checkbox" name="cadreEntreprise" id="cadreEntreprise" /> <label for="cadreEntreprise">Academique</label><br /></td>
				</tr>
				
				<tr id="invisibleTable">
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="CME"/> <label for="CME">CME</label></td>
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="Semestre"/> <label for="Semestre">Semestre</label></td>
					
				</tr>
				
				<tr id="invisibleTable">
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="STING"/> <label for="STING">STING</label></td>
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="Annee"/> <label for="Annee">Annee</label></td>
				</tr>
				
				<tr id="invisibleTable">
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="TFE"/> <label for="TFE">TFE</label></td>
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="Double Diplome"/> <label for="Double Diplome">Double Diplome</label></td>
				</tr>
				
				<tr id="invisibleTable">
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="Cesure"/> <label for="Cesure">Cecure</label></td>
					<td ALIGN="center" id="invisibleTable"><input type="checkbox" name="Cesure"/> <label for="Cesure">Cecure</label></td>
				</tr>			
				</table>
				</p>
			</fieldset>
			</p>			
			
			<!-- Sous paragraphe Autres-->
			<p>
				<fieldset>
				<h2> <legend>Autres</legend> <Cadre de mobilite> </h2>
				<p>
				<!-- Universites/Entreprises -->
				<select name="universite" id="universite_entreprise"/>
					<option value="Toutes les universités et entreprises" selected="selected">Toutes les universités et entreprises</option>
					<!-- options are filled by AJAJ -->						
				</select>
				</p>
				
				<!-- Langues -->
				<select name="langue" id="langue"/>
					<option value="Toutes les langues" selected="selected">Toutes les langues</option>
						<!-- options are filled by AJAJ -->							
				</select>
								
				<!-- Domaine d activites -->
				<p>
				<select name="domaine" id="domaine" />	
					<option value="Tous les domaines d'activités" selected="selected">Tous les domaines d'activité</option>
					<!-- options are filled by AJAJ -->	
				</select>
				</p>
				
				<!-- Tous les rapports -->
				<p>
				<select name="annee" id="annee"/>
					<option value="Tous les rapports" selected="selected">Tous les rapports</option>
					<option value="2013-2014">2013-2014</option>
					<option value="2011-2012">2011-2012</option>	
					<option value="2009-2010">2009-2010</option>		
				</select>
				</p>
			</fieldset>
		</p>
		
		</fieldset>
		</p>	
	<!-- Resultats"-->
		<p>
		<fieldset>
		<h2> <legend>Resultats</legend> <Resultats> </h2>
		
		<p>
		<select name="resultatPage" id="resultatPage" onChange="viewOthers()" />
							
			<option value="Resutalts par page" selected="selected">Resultats pas page</option>
			 
			<option value="10resultats">10 R�sultats</option>
			<option value="20resultats">20 R�sultats</option>
			<option value="30resultats">30 R�sultats</option>
			<option value="40resultats">40 R�sultats</option>
			<option value="50resultats">50 R�sultats</option>

		</select>
		</p>
		
		<table id="tableau">
			<thead>
				<tr>
					<th height="10" id="tableau">Rapport<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Dates<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Pays<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Ville<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Lieux<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Domaine<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Mobilite<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
					<th id="tableau">Langue<img src="iconeCroissantDecroissant.png" align="center" class="imageflottante"></th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td><div align="center">UK_Semestre_Informatique<img src="iconeTelechargemet.jpg" height="7%" width="5%" align="center"></div></td>
					<td>02/02/2012 - 07/07/2012</td>
					<td>Royaume-Uni</td>
					<td>Londres</td>
					<td>University College London</td>
					<td>Informatique</td>
					<td>Double Diplome</td>
					<td>Anglais</td>
				</tr>
			</tbody>
		</table>
		</fieldset>
		</p>
	</form>
	
	</body>
</html>