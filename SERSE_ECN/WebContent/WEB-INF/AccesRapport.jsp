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
		<title>SERSE Recherche de Rapports </title>
		<link rel="stylesheet" type="text/css" href="styles/StyleSheet1.css"/>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!--  alternative quand pas d'accès internet-->
		<script type="text/javascript" src="scripts/jquery-1.10.2.min.js"></script>
		
		<script type="text/javascript" src="scripts/OptionsRemplissage.js"></script>
		<script type="text/javascript" src="scripts/RecherchePageInitialisation.js"></script>
		
		<script type="text/javascript" src="scripts/GeographyManager.js"></script>
		<script type="text/javascript" src="scripts/RechercheSejourManager.js"></script>
		<script type="text/javascript" src="scripts/RechercheMobiliteManager.js"></script>
		<script type="text/javascript" src="scripts/RechercheFiltresAction.js"></script>
		
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
						<h3> Continent, Pays, Ville</h3>
<!-- "Continent"-->
						<p>
							<select name="continent" id="continent">
								<option value="defaut" selected="selected">Tous les continents</option>
									<!-- available options are filled by AJAJ -->						
							</select>
						</p>
						
<!-- "Pays"-->
						<p>
							<select name="pays" id="pays">
								<option value="defaut" selected="selected">Tous les pays</option>
									<!-- available options are filled by AJAJ -->	
							</select>
						</p>

<!-- "Ville"-->
						<p>
							<select name="ville" id="ville">
								<option value="defaut" selected="selected">Toutes les villes</option>
									<!-- available options are filled by AJAJ -->
							</select>
						</p>
				</fieldset>
			</p>
			
			
<!-- Sous-paragraphe Séjour"-->
			<p>
				<fieldset>
					<h2> Séjour </h2>
					<table id="invisibleTable">
						<tr id="invisibleTable">
							<td id="invisibleTable"><input type="checkbox" id="sejourUniversite" checked="checked"/> <label for="sejourUniversite">Universite</label></td>
							<td id="invisibleTable"><input type="checkbox" id="sejourEntreprise" checked="checked"/> <label for="sejourEntreprise">Entreprise</label></td>
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
								<input type="checkbox" id="cadreProfessionnel" checked="checked"/><label for="cadreProfessionnel">Professionnel</label>
								<ul id='casesCadreProfessionnel' style="list-style: none">
								    <li><input type='checkbox' id='pCME' checked="checked"/>CME</li>
								    <li><input type='checkbox' id='pSTING' checked="checked"/>STING</li>
								    <li><input type='checkbox' id='pTFE' checked="checked"/>TFE</li>
								    <li><input type='checkbox' id='pCesure' checked="checked"/>Césure</li>
								    <li><input type='checkbox' id='pSemestre' checked="checked"/>Semestre</li>	    
								</ul>
							</td>
							<td id="invisibleTable">
								<input type="checkbox" id="cadreAcademique" checked="checked"><label for="cadreAcademique">Académique</label>
								<ul id='casesCadreAcademique' style="list-style: none">
								    <li><input type='checkbox' id='aSemestre' checked="checked"/>Semestre</li>
								    <li><input type='checkbox' id='aAnnee' checked="checked"/>Annee</li>
								    <li><input type='checkbox' id='aDoubleDiplome' checked="checked"/>Double Diplome</li>
								    <li><input type='checkbox' id='aCesure' checked="checked"/>Césure</li>	    
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
						<select id="universite_entreprise">
							<option value="defaut" selected="selected">Toutes les universités et entreprises</option>
							<optgroup id="universiteGroup" label="Universite">Université</optgroup>
								<!-- available options are filled by AJAJ -->	
							<optgroup id="entrepriseGroup" label="Entreprise">Entreprise</optgroup>
								<!-- available options are filled by AJAJ -->						
						</select>
					</p>
				
<!-- Langues -->
					<p>
						<select id="langue">
							<option value="defaut" selected="selected">Toutes les langues</option>
								<!-- available options are filled by AJAJ -->							
						</select>
					</p>
								
<!-- Domaine d activites -->
					<p>
						<select id="domaine">	
							<option value="defaut" selected="selected">Tous les domaines d'activité</option>
							<!-- available options are filled by AJAJ -->	
						</select>
					</p>
				
<!-- Tous les rapports -->
					<p>
						<select id="date">
							<option value="defaut" selected="selected">Tous les rapports</option>
							<option value="2014">Rapports après 2014</option>
							<option value="2013">Rapports après 2013</option>
							<option value="2012">Rapports après 2012</option>	
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
		
			<table id="tableauResultats">
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
				<tbody id="contenuTableauResultats">
						<!-- résultats are filled by AJAJ -->
				</tbody>

			</table>
		</fieldset>
	</p>
</form>
	
</body>
</html>