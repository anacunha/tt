package com.pucrs.devsys.tf.rest;

import javax.ws.rs.Path;

import com.pucrs.devsys.tf.db.AbstractCRUD;
import com.pucrs.devsys.tf.persistence.Event;

@Path("events")
public class EventService extends AbstractCRUD<Event> {

}
