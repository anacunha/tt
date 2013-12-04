package com.pucrs.devsys.tf.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pucrs.devsys.tf.db.AbstractCRUD;
import com.pucrs.devsys.tf.persistence.Event;

@Path("events")
public class EventService extends AbstractCRUD<Event> {

	@Override
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{id}")
	public Boolean update(Event instance)
	{
		// TODO Auto-generated method stub
		return super.update(instance);
	}
}
