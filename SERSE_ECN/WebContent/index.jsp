<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="StyleSheet1.css"/>
		<title>SERSE</title>
	</head>
	
	<body>
		<!-- en-tête-->
		<div id=icone>
			<img src="images/icone_serse.png">
		</div>
		<p> Connexion à SERSE </p>
		<p> Application de Soumission Electronique de Rapports de Séjours à l'Etranger </p>

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
							<input type="submit" value="Connexion" id="buton_connexion" class="button" />
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