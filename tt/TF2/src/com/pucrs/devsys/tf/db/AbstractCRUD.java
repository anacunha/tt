package com.pucrs.devsys.tf.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public abstract class AbstractCRUD<M extends AbstractModel> extends AbstractController<M> {
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<M> list() 
	{
		CriteriaBuilder cb = DbConnector.getInstance().getCriteriaBuilder();
		CriteriaQuery<M> criteria = cb.createQuery(this.getModelClass());
		List<M> list = DbConnector.getInstance().createQuery(criteria).getResultList();
		
		return list;
	}
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  M get( @PathParam("id") long id) {
		return DbConnector.getInstance().find(this.getModelClass(), id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Boolean create(M instance) 
	{
		DbConnector.getInstance().save(instance);
		return true;
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean update( M instance) {
		DbConnector.getInstance().update(instance);
		
		return true;
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean update(@PathParam("id") long id) {
		M instance = DbConnector.getInstance().find(this.getModelClass(), id);
		
		DbConnector.getInstance().delete(instance);
		
		return true;
	}
}
