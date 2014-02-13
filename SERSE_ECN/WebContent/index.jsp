<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>SERSE</title>
	</head>
	
	<body>
		<p> Connexion à SERSE </p>
		<p> Application de Soumission Electronique de Rapports de Séjours à l'Etranger </p>

		<div id="formulaire_connexion">
					<form method="post" action="login">
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

	</body>
</html>