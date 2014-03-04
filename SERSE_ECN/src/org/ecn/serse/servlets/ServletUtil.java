/**
 * Project: SERSE_ECN
 * Creation date: 4 mars 2014
 * Author: Audrey
 */
package org.ecn.serse.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * @author Audrey
 *
 */
public class ServletUtil {
	
	public static void sendOptions(ArrayList<String> listeObjets, String messageDefaut, HttpServletResponse response) throws IOException  {
		Map<String, String> listeOptions = new LinkedHashMap<>();
		if (messageDefaut!=null){
			listeOptions.put("defaut", messageDefaut);
		}
		for (int i=0; i<listeObjets.size(); i++){
			listeOptions.put(listeObjets.get(i), listeObjets.get(i));
		}
		
		String jsonResponse = new Gson().toJson(listeOptions);
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse);
	}

}
