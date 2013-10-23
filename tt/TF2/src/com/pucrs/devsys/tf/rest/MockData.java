package com.pucrs.devsys.tf.rest;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;

@Path("/mock")
public class MockData 
{
	
	@GET
	public String createData()
	{
		Event e = new Event();
		
		e.setDate(new Date());
		e.setDescription("Descricao Evento 1");
		e.setEdition("1");
		e.setTitle("Evento 1");
		
		DbConnector.getInstance().persist( e );
		
		return "OK";
	}

}
