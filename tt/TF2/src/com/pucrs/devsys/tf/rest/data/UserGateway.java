package com.pucrs.devsys.tf.rest.data;

import java.util.ArrayList;
import java.util.List;

import com.pucrs.devsys.tf.persistence.Event;
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
	public User passThroughGet(User u) 
	{
		User user = new User();
		
		List<Event> events = new ArrayList<Event>();
		
		for (Event event : user.getEvents()) 
		{
			Event e = new Event();
			e.setDate( event.getDate() );
			e.setDescription( event.getDescription() );
			e.setEdition( event.getDescription() );
		}
		
		return super.passThroughGet(l);
	}

}
