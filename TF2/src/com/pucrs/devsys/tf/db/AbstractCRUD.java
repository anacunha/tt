package com.pucrs.devsys.tf.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pucrs.devsys.tf.rest.data.DataGateway;
import com.pucrs.devsys.tf.rest.data.DataGatewayRegister;

public abstract class AbstractCRUD<M extends AbstractModel> extends AbstractController<M> {
	
	@Context
	protected HttpServletRequest request;
	
	@Context
	protected HttpServletRequest response;
	 
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<M> list() 
	{
		
		CriteriaBuilder cb = DbConnector.getInstance().getCriteriaBuilder();
		CriteriaQuery<M> criteria = cb.createQuery(this.getModelClass());
		List<M> list = DbConnector.getInstance().createQuery(criteria).getResultList();
		
		DataGateway<M> gateway = DataGatewayRegister.getInstance().get(this.getModelClass().getSimpleName());
		
		if( gateway != null ) 
			return gateway.passThroughGet( list );
		else
			return list;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  M get( @PathParam("id") long id) 
	{
		M m =  DbConnector.getInstance().find(this.getModelClass(), id);
		
		DataGateway<M> gateway = DataGatewayRegister.getInstance().get(this.getModelClass().getSimpleName());
		
		if( gateway != null ) 
			return gateway.passThroughGet( m );
		else
			return m;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public  Boolean create(M instance) 
	{

		DataGateway<M> gateway = DataGatewayRegister.getInstance().get(this.getModelClass().getSimpleName());
		
		if( gateway != null ) instance = gateway.passThrougCreate( instance );
		
		DbConnector.getInstance().save(instance);
		
		return true;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean update( M instance) 
	{
		DataGateway<M> gateway = DataGatewayRegister.getInstance().get(this.getModelClass().getSimpleName());
		
		if( gateway != null ) instance = gateway.passThroughUpdate( instance );
		
		DbConnector.getInstance().update(instance);
		
		return true;
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean delete(@PathParam("id") long id) 
	{
		M instance = DbConnector.getInstance().find(this.getModelClass(), id);
		
		DataGateway<M> gateway = DataGatewayRegister.getInstance().get(this.getModelClass().getName());
		
		if( gateway != null ) instance = gateway.passThroughDelete( instance );
		
		DbConnector.getInstance().delete(instance);
		
		return true;
	}
}
