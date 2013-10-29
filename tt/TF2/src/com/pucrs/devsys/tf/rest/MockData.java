package com.pucrs.devsys.tf.rest;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.pucrs.devsys.tf.auth.AuthUtil;
import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.User;

@Path("/mock")
public class MockData 
{
	
	@Context
	protected HttpServletRequest request;
	
	@GET
	public String createData()
	{
		Event e = new Event();
		
		e.setDate(new Date());
		e.setDescription("Descricao Evento 1");
		e.setEdition("1");
		e.setTitle("Evento 1");
		
		DbConnector.getInstance().persist( e );
		
		User u = AuthUtil.getLoggedUser( request );
		
		u.getEvents().add( e );
		
		DbConnector.getInstance().update( u );
		
		e.getOrganizers().add( u );
		
		return "OK";
	}

}
