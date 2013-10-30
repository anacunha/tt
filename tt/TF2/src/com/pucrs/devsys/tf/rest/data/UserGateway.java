package com.pucrs.devsys.tf.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.Talk;
import com.pucrs.devsys.tf.persistence.User;

public class UserGateway extends DataGateway<User>
{
	private static UserGateway instance;
	
	public static UserGateway getInstance()
	{
		if( instance == null ) instance = new UserGateway();
		
		return instance;
	}
	
	@Override
	public List<User> passThroughGet(List<User> l) 
	{
		List<User> list = new ArrayList<User>();
		
		for (User user : l) 
		{
			list.add( passThroughGet( user ) );
		}
		
		return list;
	}
	
	@Override
	public User passThroughGet(User u) 
	{
		List<Event> events = new ArrayList<Event>();
		for( Event event : u.getEvents() ) 
		{
			Event e = new Event();
			e.setDate( event.getDate() );
			e.setDescription( event.getDescription() );
			e.setEdition( event.getDescription() );
			e.setId( e.getId() );
			
			events.add( e );
		}
		
		List<Talk> talks = new ArrayList<Talk>();
		for (Talk talk : u.getTalks())
		{
			Talk t = new Talk();
			t.setId( talk.getId() );
			t.setDescricao( talk.getDescricao() );
			t.setTitulo( talk.getTitulo() );
			t.setStartTime( talk.getStartTime() );
			t.setType( talk.getType() );
			
			if( t.getResponsible() != null )
			{
				User resp = new User();
				resp.setId( t.getResponsible().getId() );
				resp.setName( t.getResponsible().getName() );
				
				t.setResponsible( resp );
			}
			
			
			talks.add( t );
		}
		
		DbConnector.getInstance().detach( u );
		
		u.setEvents( events );
		u.setTalks( talks );
	
		return u;
	}

}
