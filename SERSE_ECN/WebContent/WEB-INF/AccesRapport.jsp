"<!-- 
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
		<title>SERSE Recherche de Rapports </title>
		<link rel="stylesheet" type="text/css" href="styles/StyleSheet1.css"/>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript" src="scripts/OptionsRemplissage.js"></script>
		<script type="text/javascript" src="scripts/MobilityManager.js"></script>
		<script type="text/javascript" src="scripts/GeographyManager.js"></script>
		<script type="text/javascript" src="scripts/Recherche.js"></script>
	</head>

	<body>
<!-- Onglets du menu de navigation et en-tête de page-->
		<p><%@include file="menu.jsp" %></p>

<!-- paragraphe "Criteres de recherche"-->
		<p>
			<fieldset>
				<h2> Criteres de recherche</h2>
<!-- Sous-paragraphe "Continent, Pays, Ville"-->
				<p>
					<fieldset>
						<img src="images/iconeInformation.jpg" height="7%" width="3%" align="right" class="imageflottante">
						<h3> Continent Pays, Ville</h3>
<!-- "Continent"-->
						<p>
							<select name="continent" id="continent">
								<option value="Tous les continents" selected="selected">Tous les continents</option>
									<!-- options are filled by AJAJ -->						
							</select>
						</p>
						
<!-- "Pays"-->
						<p>
							<select name="pays" id="pays">
								<option value="Tous les pays" selected="selected">Tous les pays</option>
									<!-- options are filled by AJAJ -->	
							</select>
						</p>

<!-- "Ville"-->
						<p>
							<select name="ville" id="ville">
								<option value="Toutes les villes" selected="selected">Toutes les villes</option>
									<!-- options are filled by AJAJ -->
							</select>
						</p>
				</fieldset>
			</p>
			
			
<!-- Sous-paragraphe Séjour"-->
			<p>
				<fieldset>
					<h2> Sejour </h2>
					<table id="invisibleTable">
						<tr id="invisibleTable">
							<td id="invisibleTable"><input type="checkbox" name="sejourUniversite" id="sejourUniversite" /> <label for="sejourUniversite">Universite</label></td>
							<td id="invisibleTable"><input type="checkbox" name="sejourEntreprise" id="sejourEntreprise" /> <label for="sejourEntreprise">Entreprise</label></td>
						</tr>
					</table>		
				</fieldset>
			</p>

<!-- Sous paragraphe Cadre de mobilite"-->
			<p>
				<fieldset>
					<h2>Cadre de mobilite</h2>
					<table id="invisibleTable" >
						<tr id="invisibleTable">
							<td id="invisibleTable">
								<input type="checkbox" name="cadreProfessionnel" id="cadreProfessionnel"/><label for="cadreProfessionnel">Professionnel</label>
								<ul id='casesCadreProfessionnel' style="list-style: none">
								    <li><input type='checkbox' style="list-style:none" id='pCME'/>CME</li>
								    <li><input type='checkbox' style="list-style:none" id='pSTING'/>STING</li>
								    <li><input type='checkbox' style="list-style:none" id='pTFE'/>TFE</li>
								    <li><input type='checkbox' style="list-style:none" id='pCesure'/>Césure</li>
								    <li><input type='checkbox' style="list-style:none" id='pSemestre'/>Semestre</li>	    
								</ul>
							</td>
							<td id="invisibleTable">
								<input type="checkbox" id="cadreAcademique"><label for="cadreAcademique">Académique</label>
								<ul id='casesCadreAcademique' style="list-style: none">
								    <li><input type='checkbox' id='aSemestre'/>Semestre</li>
								    <li><input type='checkbox' id='aAnnee'/>Annee</li>
								    <li><input type='checkbox' id='aDoubleDiplome'/>Double Diplome</li>
								    <li><input type='checkbox' id='aCesure'/>Césure</li>	    
								</ul>
							</td>
						</tr>		
					</table>
				</fieldset>
			</p>			
			
<!-- Sous paragraphe Autres-->
			<p>
				<fieldset>
				<h2>Autres</h2>
					<p>
<!-- Universites/Entreprises -->
						<select name="universite" id="universite_entreprise">
							<option value="Toutes les universités et entreprises" selected="selected">Toutes les universités et entreprises</option>
							<optgroup id="universiteGroup" label="Universite">Université</optgroup>
								<!-- options are filled by AJAJ -->	
							<optgroup id="entrepriseGroup" label="Entreprise">Entreprise</optgroup>
								<!-- options are filled by AJAJ -->						
						</select>
					</p>
				
<!-- Langues -->
					<p>
						<select name="langue" id="langue">
							<option value="Toutes les langues" selected="selected">Toutes les langues</option>
								<!-- options are filled by AJAJ -->							
						</select>
					</p>
								
<!-- Domaine d activites -->
					<p>
						<select name="domaine" id="domaine">	
							<option value="Tous les domaines d'activités" selected="selected">Tous les domaines d'activité</option>
							<!-- options are filled by AJAJ -->	
						</select>
					</p>
				
<!-- Tous les rapports -->
					<p>
						<select name="date" id="date">
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
			<h2> Resultats </h2>
			<p>
				<select name="resultatPage" id="resultatPage">					
					<option value="Resutalts par page" selected="selected">Resultats pas page</option>
					<option value="10resultats">10 Résultats</option>
					<option value="20resultats">20 Résultats</option>
					<option value="30resultats">30 Résultats</option>
					<option value="40resultats">40 Résultats</option>
					<option value="50resultats">50 Résultats</option>
				</select>
			</p>
		
			<table id="tableau">
				<thead>
					<tr>
						<th height="10" id="tableau">Rapport<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Dates<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Pays<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Ville<img src="images/iconeCroissantDecroissant.png"  class="imageflottante"></th>
						<th id="tableau">Lieux<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Domaine<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Mobilite<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
						<th id="tableau">Langue<img src="images/iconeCroissantDecroissant.png" class="imageflottante"></th>
					</tr>
				</thead>
			
				<tbody>
					<tr>
						<td><div align="center">UK_Semestre_Informatique<img src="Images/iconeTelechargemet.jpg" height="7%" width="5%"></div></td>
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