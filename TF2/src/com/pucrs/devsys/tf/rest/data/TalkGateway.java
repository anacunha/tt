package com.pucrs.devsys.tf.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.Resource;
import com.pucrs.devsys.tf.persistence.Talk;
import com.pucrs.devsys.tf.persistence.User;

public class TalkGateway extends DataGateway<Talk>
{
	public static TalkGateway instance;
	
	public static TalkGateway getInstance()
	{
		if( instance == null ) instance = new TalkGateway();
		return instance;
	}
	
	@Override
	public List<Talk> passThroughGet(List<Talk> l)
	{
		List<Talk> list = new ArrayList<Talk>();
		for (Talk talk : l) 
		{
			list.add( passThroughGet( talk ) );
		}
		
		return list;
	}
	
	@Override
	public Talk passThroughGet(Talk m) 
	{
		List<User> participants = new ArrayList<User>();
		for (User user : m.getParticipants()) 
		{
			User u = new User();
			u.setEmail( user.getEmail() );
			u.setId( user.getId() );
			u.setName( user.getName() );
			
			participants.add( u );
		}
		
		List<Resource> resources = new ArrayList<Resource>();
		for (Resource resource : m.getResources()) 
		{
			Resource r = new Resource();
			r.setId( resource.getId() );
			r.setLink( r.getLink() );
			r.setName( resource.getName() );
			
			resources.add( r );
		}
		
		Event e = new Event();
		e.setId( m.getEvent().getId() );
		e.setTitle( m.getEvent().getTitle() );
			
		DbConnector.getInstance().detach(m);
		
		if( m.getResponsible() != null )
		{
			User u = new User();
			u.setId( m.getResponsible().getId() );
			u.setName( m.getResponsible().getName() );
			u.setEmail( m.getResponsible().getEmail() );
			m.setResponsible( u );
		}
		
		
		m.setEvent( e );
		m.setParticipants(participants);
		m.setResources(resources);
		
		return m;
	}
}
