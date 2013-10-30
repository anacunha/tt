package com.pucrs.devsys.tf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.pucrs.devsys.tf.db.AbstractCRUD;
import com.pucrs.devsys.tf.persistence.User;

@Path("users")
public class UserService extends AbstractCRUD<User> 
{

}
