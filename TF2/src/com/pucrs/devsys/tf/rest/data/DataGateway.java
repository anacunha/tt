package com.pucrs.devsys.tf.rest.data;

import java.util.List;

import com.pucrs.devsys.tf.db.AbstractModel;

/**
 * This is a gateway between the Rest Services and the Database. This will be used to 
 *  change the beans before sending them to the services. 
 *  ex: setting some fields to null to avoid endless loops during the parsing to JSON.
 *  And before saving them to the database, when a bean is update using the services some fields will be null but they should not be deleted from the database. 
 *  ex: pipeline logs.
 *  
 * @author I833488
 */
public abstract class DataGateway<M extends AbstractModel>
{

	 
	 public M passThrougCreate(M m)
	 {
		 return m;
	 }
	 
	 public List<M> passThroughGet(List<M> l)
	 {
		 
		 return l;
	 }
	
	 public M passThroughGet(M m)
	 {
		 return m;
	 }
	
	 public M passThroughUpdate(M m)
	 {
		 return m;
	 }
	 
	 public M passThroughDelete(M m)
	 {
		 return m;
	 }
}
