package com.pucrs.devsys.tf.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.pucrs.devsys.tf.db.dao.UserDAO;
import com.pucrs.devsys.tf.persistence.User;

public class AuthUtil 
{
	public static User getLoggedUser( HttpServletRequest request )
	{
		User u = null;
	     
	     Cookie[] cookies = request.getCookies();
	     
	     if( cookies != null )
	     {
	    	 for (Cookie cookie : cookies) 
	    	 {
	    		 if( cookie.getName().equals("TTalkToken") )
	    		 {
	    			 String faceId = cookie.getValue();
	    			 
	    			 u = UserDAO.getInstance().getUserByFacebook(faceId);
	    				
	    		 }
			}
	     }

		return u;
	}

}
