package org.ecn.serse.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	
	public static final int TAILLE_TAMPON = 10240; // 10 ko
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		/* try {
		        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		        for (FileItem item : items) {
	                String nomChamp = item.getFieldName();
	                String nomFichier = FilenameUtils.getName(item.getName());
	                InputStream contenuFichier = item.getInputStream();
		        }
		    } catch (FileUploadException e) {
		        throw new ServletException("Échec de l'analyse de la requête multipart.", e);
		    }

	    String chemin = this.getServletConfig().getInitParameter("chemin");
	    String fichier = request.getParameter("filepath");
	    if ( nomFichier != null && !nomFichier.isEmpty() ) {
	        String nomChamp = part.getName();
	        /*
	         * Antibug pour Internet Explorer, qui transmet pour une raison
	         * mystique le chemin du fichier local à la machine du client...
	         * 
	         * Ex : C:/dossier/sous-dossier/fichier.ext
	         * 
	         * On doit donc faire en sorte de ne sélectionner que le nom et
	         * l'extension du fichier, et de se débarrasser du superflu.
	         */
	        /* nomFichier = nomFichier.substring( nomFichier.lastIndexOf( '/' ) + 1 )
	                .substring( nomFichier.lastIndexOf( '\\' ) + 1 );

	        ecrireFichier( part, nomFichier, chemin );
	    }

	    this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );*/
	}


	/*
	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
	 * sur le disque, dans le répertoire donné et avec le nom donné.
	 */
	/*private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	    BufferedInputStream entree = null;
	    BufferedOutputStream sortie = null;
	    try {
	        entree = new BufferedInputStream( part.getInputStream(), TAILLE_TAMPON );
	        sortie = new BufferedOutputStream( new FileOutputStream( new File( chemin + nomFichier ) ),
	                TAILLE_TAMPON );
	    } finally {
	        try {
	            sortie.close();
	        } catch ( IOException ignore ) {
	        }
	        try {
	            entree.close();
	        } catch ( IOException ignore ) {
	        }
	    }
	}*/

}
