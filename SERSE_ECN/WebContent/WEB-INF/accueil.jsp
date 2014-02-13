<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Résultat de la servlet de connexion</title>
	</head>

	<body>
		<p>
			<% String attribut = (String) request.getAttribute("erreur");
				out.println( attribut );
			%>
		</p>
	</body>
</html>