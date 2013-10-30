package com.pucrs.devsys.tf.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.Event;
import com.pucrs.devsys.tf.persistence.Sponsor;
import com.pucrs.devsys.tf.persistence.Talk;
import com.pucrs.devsys.tf.persistence.User;

public class EventGateway extends DataGateway<Event>
{
	public static EventGateway instance;
	
	
	public static EventGateway getInstance()
	{
		if( instance == null ) instance = new EventGateway();
		return instance;
	}
	
	@Override
	public List<Event> passThroughGet(List<Event> l) 
	{

		List<Event> list = new ArrayList<Event>();
		
		for (Event event : l) 
		{
			
			list.add( passThroughGet( event ) );
		}
		
		return list;
	}
	@Override
	public Event passThroughGet(Event m) 
	{
				
		List<Talk> talks = new ArrayList<Talk>();
		for (Talk talk : m.getTalks()) 
		{
			Talk t = new Talk();
			t.setId( talk.getId() );
			t.setDescricao( talk.getDescricao() );
			t.setTitulo( m.getTitle() );
			t.setType( talk.getType() );
			
			talks.add( t );
		}
		
		List<User> organizers = new ArrayList<User>();
		for (User user : m.getOrganizers()) 
		{
			User u = new User();
			u.setId( user.getId() );
			u.setName( u.getName() );
			u.setEmail( user.getEmail() );
			
			organizers.add( u );
		}
		
		List<Sponsor> sponsors = new ArrayList<Sponsor>();
		for (Sponsor sponsor : m.getSponsors()) 
		{
			Sponsor s = new Sponsor();
			s.setId( sponsor.getId() );
			s.setName( sponsor.getName() );
			
			sponsors.add( s );
		}
		
		DbConnector.getInstance().detach( m );
		
		
		m.setTalks(talks);
		m.setOrganizers(organizers);
		m.setSponsors(sponsors);
		
		return m;
	}
}
