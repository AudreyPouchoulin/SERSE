<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<body>
		<p>
			<img id="icone" src="images/icone_serse.png">
			<% 
				String message = (String) request.getAttribute("message_bienvenue");
				if (message!=null){
					out.println(message);
				}
			%>
			<div id="menu">
				 <ul id="onglets">
					 <!-- Liens a completer au fur et a mesure -->
					<li class="active"><a href="Accueil"> Accueil </a></li>
					<li><a href="Recherche"> Acces aux rapports </a></li>
					<li><a href="MesRapports"> Mes Rapports </a></li>
				 </ul>
			</div>
		</p>
		
		
			
</body>
</html>