<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="styles/serse_main.css"/>
		<title>SERSE</title>
	</head>
	
	<body id="connexion">
		<!-- en-tête-->
		<img src="images/icone_serse.png">
		<h1> Connexion à SERSE </h1>
		<h2> Application de Soumission Electronique de Rapports de Séjours à l'Etranger </h2>

		<!-- formulaire: identifiant +  mot de passe + bouton connxeion-->
		<div id="formulaire_connexion">
					<form method="post" action="Accueil">
							<table id="table_connexion">
								<tr>
									<td><label for="txt_identifiant">Identifiant</label></td>
									<td><input type="text" id="txt_identifiant" name="username" size="7" placeholder="Votre identifiant de Centrale Nantes"/></td>
								</tr>
								<tr>
									<td><label for="txt_password">Mot de passe</label></td>
									<td><input type="password" id="txt_password" name="password" size="30" placeholder="Votre mot de passe" /></td>
								</tr>
							</table>
							<br>
							<input type="submit" value="Connexion" id="button_connexion" class="button" />
					</form>
		</div>
		
		<p>
			<% String attribut = (String) request.getAttribute("erreur_information");
				if (attribut!=null){
					out.println( attribut );
				}
			%>
		</p>

	</body>
</html>