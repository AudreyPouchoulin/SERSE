<!-- 
 Utilisateurs : Etudiants
 Page : Soumission de rapport
 Date crÃ©ation : 19/02/2014
-->

<%@ page language="java" 
	contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
	
<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE Soumission de Rapports</title>
		<link rel="stylesheet" type="text/css" href="styles/StyleSheet1.css"/>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!--  alternative quand pas d'accès internet-->
		<script type="text/javascript" src="scripts/jquery-1.10.2.min.js"></script>
		
		<script type="text/javascript" src="scripts/OptionsRemplissage.js"></script>
		<script type="text/javascript" src="scripts/SoumissionPageInitialisation.js"></script>
		<script type="text/javascript" src="scripts/SoumissionChampsAutre.js"></script>
		<script type="text/javascript" src="scripts/SoumissionFiltresAction.js"></script>
		<script type="text/javascript" src="scripts/Soumission.js"></script>
	</head>

	<body>
<!--Onglets du menu de navigation et en-tête de page-->
			<p><%@include file="menu.jsp" %></p>
			
<!--Champs de saisie des informations -->
		<p>
			<fieldset>
				<table>
					<tr>
						<td>Nom</td>
						<td id='nom' >Pouchoulin</td>
					</tr>
					
					<tr>
						<td>Prenom</td>
						<td id='prenom'>Audrey</td>
					</tr>
					
					<tr>
						<td>Sexe</td>
						<td sexe='sexe'>F</td>
					</tr>
					
					<tr>
						<td>Date de début de séjour</td>
						<td><input type="text" id="dateDebut" placeholder="jj/mm/aaaa"><img src="images/iconeCalendrier.png" width="10%" height="20%"/></td>
					</tr>
					
					<tr>
						<td>Date de fin de séjour</td>
						<td><input type="text" id="dateFin" placeholder="jj/mm/aaaa"><img src="images/iconeCalendrier.png" width="10%" height="20%"/></td>
					</tr>
<!--Continent-->					
					<tr>
						<td>Continent</td>
						<td>
							<select name="continent" id="continent">
								<option value="defaut" selected="selected">Choisissez un continent</option>
								<!-- available options are filled by AJAJ -->					
							</select>
						</td>
					</tr>

<!--Pays-->						
					<tr>
						<td>Pays</td>
						<td>
							<select name="pays" id="pays">
								<option value="defaut" selected="selected">Choisissez un pays</option>
								<!-- available options are filled by AJAJ + champs Autre-->
							</select>
						</td>
						<td id='autrePays' style="display: none">
							<input id="valueAutrePays" type="text" placeholder="Nom du pays ?"/>
						</td>
					</tr>

<!--Ville-->	
					<tr>
						<td>Ville</td>
						<td>
							<select id="ville">
								<option value="defaut" selected="selected">Choisissez une ville</option>
								<!-- available options are filled by AJAJ -->
							</select>
						</td>
						<td id='autreVille' style="display: none">
							<input id="valueAutreVille" type="text" placeholder="Nom de la ville ?"/>
						</td>
					</tr>

<!--Type de séjour-->				
					<tr>
						<td>Type de séjour</td>
						<td>
							<select id="typeSejour">
								<option value="defaut" selected="selected">Choisissez un type de séjour</option>
								<!-- available options are filled by AJAJ -->
							</select>	
						</td>
					</tr>		

<!--Type de mobilité-->
					<tr>
						<td>Type de mobilité</td>
						<td>
							<select id="typeMobilite">
								<option value="defaut" selected="selected">Choisissez un type de mobilité</option>
								<!-- available options are filled by AJAJ -->
							</select>		
						</td>
					</tr>

<!--Type d'expérience-->
					<tr>
						<td>Type Expérience</td>
						<td>
							<select id="typeExperience">
								<option value="defaut" selected="selected">Choisissez un type d'expérience</option>
								<!-- available options are filled by AJAJ -->
							</select>
						</td>
					</tr>

<!--Nom de l'université ou de l'entreprise-->
					<tr>
						<td>Universite/Entreprise</td>
						<td>
							<select id="universite_entreprise">
								<option value="defaut" selected="selected">Choisissez une université ou une entreprise</option>
								<optgroup id="universiteGroup" label="Universite">Université</optgroup>
									<!-- available options are filled by AJAJ -->	
								<optgroup id="entrepriseGroup" label="Entreprise">Entreprise</optgroup>
									<!-- available options are filled by AJAJ -->					
							</select>					
						</td>
						<td id='autreUniversite' style="display: none">
							<input id="valueAutreUniversite" type="text" placeholder="Nom de l'université ?"/>
						</td>
						<td id='autreEntreprise' style="display: none">
							<input id="valueAutreEntreprise" type="text" placeholder="Nom de l'entreprise?"/>
						</td>
					</tr>

<!--Langue-->				
					<tr>
						<td>Langues parlées</td>
						<td>
							<select id="langue">		
								<option value="defaut" selected="selected">Choisissez une langue de travail majoritaire</option>
								<!-- available options are filled by AJAJ -->					
							</select>
							<img src="images/iconeInformation.jpg" height="12%" width="5%"class="imageflottante">
						</td>
						<td id='autreLangue' style="display: none">
							<input id="valueAutreLangue" type="text" placeholder="Nom de la langue ?"/>
						</td>
					</tr>

<!--Domaine d'activité-->					
					<tr>
						<td>Domaines d'activités</td>
						<td>
							<select id="domaine">
								<option value="defaut" selected="selected">Choisissez un domaine d'activité principal</option>
								<!-- available options are filled by AJAJ -->					 												
							</select>
							<img src="images/iconeInformation.jpg" height="12%" width="5%" class="imageflottante">
						</td>
						<td id='autreDomaine' style="display: none">
							<input id="valueAutreDomaine" type="text" placeholder="Nom du domaine d'activité ?"/>
						</td>
					</tr>

<!--Adresse du lieu de séjour-->						
					<tr>
						<td>Adresse du lieu de séjour</td>
						<td><input id="adresse" type="text" placeholder="Entrer l'adresse du lieu de séjour" size="27"></td>
						<td><input type="button" value="Recherche des coordonnées GPS "></td>
					</tr>

<!--Affichage des coordonnées GPS-->		
					<tr>
						<td>Coordonnées GPS</td>
						<td id="coordonnees">Lancer la recherche apres avoir saisi l'adresse <td>
					</tr>

<!--Chemin du fichier-->
					<tr>
						<td>Rapport</td>
						<td><input id="cheminFichier" type="text" placeholder="Chemin du fichier"></td>
						<td><input type="button" value="Parcourir"></td>
					</tr>
					
<!--Reset et soumettre le rapport-->	
					<tr>
						<td><input id="reset" type="reset" value="Reset"></td>
						<td><input id="valider" type="submit" value="Valider"></td>
					</tr>
				</table>
			<br/>
			<br/>
			<br/>
			<br/>
		
					
			</fieldset>
		</p>
	</body>
</html>