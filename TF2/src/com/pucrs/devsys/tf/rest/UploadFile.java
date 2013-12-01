package com.pucrs.devsys.tf.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Resource;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem>  items = upload.parseRequest(request);
			
			 for (FileItem item : items) 
			 {
		            if (item.isFormField()) {
		                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
		                String fieldname = item.getFieldName();
		                String fieldvalue = item.getString();
		                
		                System.out.println( fieldname +" : "+ fieldvalue );
		                // ... (do your job here)
		            } else {
		                // Process form file field (input type="file").
		                String fieldname = item.getFieldName();
		                String filename = FilenameUtils.getName(item.getName());
		                InputStream filecontent = item.getInputStream();
		                
		                byte[] bytes = IOUtils.toByteArray( filecontent );
		                
		                Resource r = new Resource();
		                r.setContent(bytes);
		                r.setName(filename);
		                
		                DbConnector.getInstance().persist( r );
		                
		            }
		        }
			System.out.println( "passou" );
			
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}
