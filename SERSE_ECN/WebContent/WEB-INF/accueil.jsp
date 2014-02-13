<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SERSE</title>
	</head>

	<body>
		<p>
			<% String attribut = (String) request.getAttribute("type_connexion");
				out.println( attribut );
			%>
		</p>
	</body>
</html>