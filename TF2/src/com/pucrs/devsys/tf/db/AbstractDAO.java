package com.pucrs.devsys.tf.db;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


public abstract class AbstractDAO<M extends AbstractModel> extends AbstractController<M> 
{
	
	public List<M> list() 
	{
		CriteriaBuilder cb = DbConnector.getInstance().getCriteriaBuilder();
		CriteriaQuery<M> criteria = cb.createQuery(this.getModelClass());
		List<M> list = DbConnector.getInstance().createQuery(criteria).getResultList();
		
		return list;
	}
	
	public  M get( long id) {
		return DbConnector.getInstance().find(this.getModelClass(), id);
	}

	public  Boolean create(M instance) 
	{
		DbConnector.getInstance().save(instance);
		return true;
	}

	public Boolean update( M instance) {
		DbConnector.getInstance().update(instance);
		
		return true;
	}

	public Boolean delete( long id ) {
		
		M instance = DbConnector.getInstance().find(this.getModelClass(), id);
		
		DbConnector.getInstance().delete(instance);
		
		return true;
	}

}
