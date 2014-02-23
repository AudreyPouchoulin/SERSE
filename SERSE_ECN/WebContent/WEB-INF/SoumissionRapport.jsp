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
		<LINK type="text/css/html" rel="stylesheet" media="all" title="CSS" href="StyleSheet1.css" />
	</head>

	<body>
		<!-- Onglets du menu de navigation et en-tête de page-->
			<p><%@include file="menu.jsp" %></p>
			
		<!-- Champs de saisie des informations  -->
		<p>
		<fieldset>
			<table>
				<tr>
					<td>Nom</td>
					<td>Pouchoulin</td>
				</tr>
				
				<tr>
					<td>Prenom</td>
					<td>Audrey</td>
				</tr>
				
				<tr>
					<td>Sexe</td>
					<td>F</td>
				</tr>
				
				<tr>
					<td>Date de debut de sejour</td>
					<td><input type="text" name="dateDebut" placeholder="jj/mm/aaaa"><image src="iconeCalendrier.png" width="10%" height="20%" align="center"/></td>
				</tr>
				
				<tr>
					<td>Date de fin de sejour</td>
					<td><input type="text" name="dateDebut" placeholder="jj/mm/aaaa"><image src="iconeCalendrier.png" width="10%" height="20%" align="center"/></td>
				</tr>
				
				<tr>
					<td>Continent</td>
					<td><!-- "Continent"-->
						<p>
						<select name="continent" id="continent" onChange="viewOthers()" />
							
							<option value="Choisissez un continent" selected="selected">Choisissez un continent</option>
			 
							<option value="Afrique">Afrique</option>
							<option value="Amerique">Amerique</option>
							<option value="Amerique">Asie</option>
							<option value="Europe">Europe</option>
							<option value="Oceanie">Oceanie</option>
												
						</select>
						</p></td>
				</tr>
				
				<tr>
					<td>Pays</td>
					<td>
					<select name="pays" id="pays" onChange="viewOthers()" />
							<option value="Choississez un pays" selected="selected">Choississez un pays</option>
							<option value="Belgique">Belgique</option> 
							<option value="France ">France</option>
							<option value="Royaume-Unie ">Royaume-Uni</option>
							<option value="Ukraine">Ukraine</option> 

					</select>
					</td>
				</tr>

				<tr>
					<td>Ville</td>
					<td>
							<select name="ville" id="ville" onChange="viewOthers()" />
							<option value="Choississez une ville" selected="selected">Choississez une ville</option>
							<option value="Paris ">Londres</option>
							<option value="Kiev">Bristol</option> 
							<option value="Bamako">Durham</option> 
							<option value="New York">Manchester</option> 
							<option value="Toronto">Nothingham</option> 
						</select>
					</td>
				</tr>
				
				<tr>
					<td>Type de sejour</td>
					<td>
							<select name="typeSejour" onChange="viewOthers()" />
							<option value="Choisir le type de sejour" selected="selected">Choisir le type de sejour</option>
							<option value="Universite ">Universite</option>
							<option value="Entreprise">Entreprise</option> 
					</td>
				</tr>		

				<tr>
					<td>Type de mobilite</td>
					<td>
							<select name="cadreMobilite" onChange="viewOthers()" />
							<option value="cadreMobilite" selected="selected">Choisir le type de la mobilite</option>
							<option value="Universite ">Double Diplome</option>
							<option value="Entreprise">Semestre</option> 
					</td>
				</tr>

				<tr>
					<td>Type Experience</td>
					<td>
							<select name="cadreMobilite" onChange="viewOthers()" />
							<option value="cadreMobilite" selected="selected">Choisir le type d'experience</option>
							<option value="Academique">Academique</option>
							<option value="Professionnel">Professionnel</option> 
					</td>
				</tr>

				<tr>
					<td>Universite/Entreprise</td>
					<td>
					<select name="universite" id="universite" onChange="viewOthers()" />
							
						<option value="Toutes les universites/entreprises" selected="selected">Toutes les universites/entreprises</option>
				 
						<option value="Columbia">King's College</option>
						<option value="London School of Economics">London School of Economics</option>
						<option value="University of Toronto">University College London</option>
						<option value="Universite de Kiev">Imperial College London</option>
						<option value="Universite de Kiev">UCASS</option>
												
					</select>					
					</td>
				</tr>
				
				<tr>
					<td>Langues parlees</td>
					<td>
						<select name="langue" id="langue" onChange="viewOthers()"/>
							
						<option value="Toutes les langues" selected="selected">Toutes les langues</option>
			 			<option value="anglais">Anglais</option>
						<option value="francais">Francais</option>
						<option value="russe">Russe</option>
						<option value="Espagnol">Espagnol</option>
												
						</select>
						<img src="Images/iconeInformation.jpg" height="12%" width="5%" align="center" class="imageflottante">
					</td>
					
					
				</tr>
				
				<tr>
					<td>Domaine d'activites</td>
					<td>
						<select name="domaine" id="domaine" onChange="viewOthers()" />
							<option value="Tous les domaines" selected="selected">Tous les domaines</option>					 
							<option value="Genie Civil">Genie Civil</option>
							<option value="Aeronautique">Aeronautique</option>
							<option value="Finance">Finance</option>
							<option value="Finance">Management</option>
							<option value="Informatique">Informatique</option>													
						</select>
						<img src="Images/iconeInformation.jpg" height="12%" width="5%" align="center" class="imageflottante">
					</td>
				</tr>
				
				<tr>
					<td>Adresse du lieu de sejour</td>
					<td><input type="text" name="firstname" placeholder="Entrer l'adresse du lieu de sejour" size="27"></td>
					<td><INPUT class="envoiFormulaire" TYPE="button" VALUE="Recherche des coordonnees GPS "></td>
				</tr>

				<tr>
					<td>Coordonnees GPS</td>
					<td>Lancer la recherche apres avoir saisi l'adresse <td></td></td>
				</tr>

				<tr>
					<td>Rapport</td>
					<td><input type="text" name="firstname" placeholder="Chemin du fichier"></td>
					<td><INPUT class="envoiFormulaire" TYPE="button" VALUE="Parcourir"></td>
				</tr>
				

				<tr>
					<td><INPUT class="envoiFormulaire" TYPE="reset" VALUE=" Reset "></td>
					<td><INPUT class="envoiFormulaire" TYPE="submit" VALUE=" Envoyer "></td>
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