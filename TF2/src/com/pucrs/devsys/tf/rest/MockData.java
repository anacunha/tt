package com.pucrs.devsys.tf.rest;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import com.pucrs.devsys.tf.auth.AuthUtil;
import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.Resource;
import com.pucrs.devsys.tf.persistence.Sponsor;
import com.pucrs.devsys.tf.persistence.Talk;
import com.pucrs.devsys.tf.persistence.User;

@Path("/mock")
public class MockData 
{
	
	@Context
	protected HttpServletRequest request;
	
	@GET
	public String createData()
	{
	
		User user1 = new User();	
		user1.setEmail("aaa@gmail.com");
		user1.setId(1);
		user1.setName("felipe");
		DbConnector.getInstance().persist( user1 );
	
		User user2 = new User();	
		user2.setEmail("aaa@gmail.com");
		user2.setId(1);
		user2.setName("felipe");
		DbConnector.getInstance().persist( user2 );
		
		User u = AuthUtil.getLoggedUser( request );
		
		
		// Cria evento
		Event e1 = new Event();
		e1.setDate(new Date());
		e1.setDescription("Descricao Evento 1");
		e1.setEdition("1");
		e1.setTitle("Evento 1");
		DbConnector.getInstance().persist( e1 );
		
		// Cria Resource
		Resource r = new Resource();
		r.setName("Slides");
		r.setLink("http://link.para.o.arquivo.com");
		DbConnector.getInstance().persist(r);
		
		// Cria Talk
		Talk t1 = new Talk();
		t1.setDescricao("Descricao Talk 1");
	    t1.setResponsible( u );
	    t1.setStartTime(new Date());
	    t1.setTitulo("Talk 1");
		DbConnector.getInstance().persist( t1 );
	    
		// Adiciona resource para a talk;
	    t1.getResources().add( r );
	    DbConnector.getInstance().update( t1 );
	    r.setTalk(t1);
	    DbConnector.getInstance().update( r );
	    
	    // Adiciona usuario como organizador do evento
	 	u.getEvents().add( e1 );
	 	DbConnector.getInstance().update( u );
	 	e1.getOrganizers().add( u );
	 	DbConnector.getInstance().update( e1 );
	 		
	 	// Adiciona Talk ao evento
	 	e1.getTalks().add( t1 );
	 	DbConnector.getInstance().update(e1);
	 	t1.setEvent(e1);
	 	DbConnector.getInstance().update(t1);
	 	
	 	// Adiciona usuario como participante do evento
	 	t1.getParticipants().add( u );
	 	DbConnector.getInstance().update( t1 );
	 	u.getTalks().add( t1 );
	 	DbConnector.getInstance().update(u);
	 	
	 	// Cria sponsor
	 	Sponsor s = new Sponsor();
	 	s.setName( "PUCRS" );
	 	DbConnector.getInstance().persist(s);
	 	
	 	// Adiciona sponsor ao evento
	 	e1.getSponsors().add(s);
	 	DbConnector.getInstance().update(e1);
	 	s.getEvents().add( e1 );
	 	DbConnector.getInstance().update(s);
	 	
	 	File f = new File("users.ttalks");
	 		 	
		return "OK";
	}

}
