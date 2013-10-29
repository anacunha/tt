package com.pucrs.devsys.tf.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pucrs.devsys.tf.db.dao.UserDAO;
import com.pucrs.devsys.tf.persistence.User;

public class AuthenticationFilter implements Filter 
{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain chain) throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest)sr;
	     HttpServletResponse res = (HttpServletResponse)sr1;

	     User u = AuthUtil.getLoggedUser( req );
	     
	     if( u == null ) 
	     {
	    	  res.setStatus( 403 ); // forbidden
	    	//  res.sendRedirect("https://www.facebook.com/dialog/oauth?client_id=1410298582533255&redirect_uri=http://localhost:8080/TF2/rest/loginfb&scope=email");
	     }
	     else	   
	    	 chain.doFilter(sr, sr1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
