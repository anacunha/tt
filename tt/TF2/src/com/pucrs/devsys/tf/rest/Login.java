package com.pucrs.devsys.tf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/loginfb")
public class Login 
{
	@GET
	public String get()
	{
		return "ok";
	}
}
