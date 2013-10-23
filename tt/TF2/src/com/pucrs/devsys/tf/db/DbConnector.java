package com.pucrs.devsys.tf.db;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;



import com.pucrs.devsys.tf.util.BaseBean;

public class DbConnector {

	private DataSource ds;
	private Connection conn;
	private EntityManagerFactory emf;
	public EntityManager em;
	private static DbConnector instance;

	private DbConnector()
	{
		getConnection();
	}
	
	public static DbConnector getInstance()
	{
		if( instance == null ) instance = new DbConnector();
			
		return instance;
	}
	
	public Connection getConnection() 
	{
		try 
		{
				emf = Persistence.createEntityManagerFactory("TF");
				em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void beginTransaction() {
		em.getTransaction().begin();
	}
	
	public void commitTransaction() {
		em.getTransaction().commit();
	}
	
	public void persist(AbstractModel bean) 
	{
		em.getTransaction().begin();
		em.persist(bean);
		em.getTransaction().commit();
	}
	
	public boolean save(AbstractModel bean) {
		beginTransaction();
		em.persist(bean);
		commitTransaction();
		return true;
	}
	
	public boolean update(AbstractModel bean) {
		beginTransaction();
		em.merge(bean);
		commitTransaction();
		return true;
	}
	
	public boolean delete(AbstractModel bean) {
		em.remove(bean);
		return true;
	}
	
	public void refresh(AbstractModel bean) {
		em.refresh(bean);
	}
	
	public <B extends AbstractModel> B find(Class<B> bean, Long id) {
		return em.find(bean, id);
	}
	
	public CriteriaBuilder getCriteriaBuilder()
	{
		return em.getCriteriaBuilder();
	}
	
	public <B> CriteriaQuery<B> createCriteria(Class<B> bean) {
		return em.getCriteriaBuilder().createQuery(bean);
	}
	
	public <B> TypedQuery<B> createQuery(CriteriaQuery<B> criteria) {
		return em.createQuery(criteria);
	}
}