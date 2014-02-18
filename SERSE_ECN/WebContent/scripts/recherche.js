/**
 * 
 */

	function getContinents(){
			var xhr = getXMLHttpRequest();
			xhr.open("POST", "ContinentServlet", true);
			alert("OK open");
			xhr.send(null);
			alert("OK send");
			//xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			if (xhr.readyState == 4 && (xhr.status == 200 || xhr.status == 0)) {
				alert("OK");
			}	
		}