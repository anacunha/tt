package com.pucrs.devsys.tf.db.dao;

import java.util.List;

import javax.persistence.Query;

import com.pucrs.devsys.tf.db.AbstractDAO;
import com.pucrs.devsys.tf.db.DbConnector;
import com.pucrs.devsys.tf.persistence.User;

public class UserDAO extends AbstractDAO<User>
{
	private static UserDAO instance;
	
	public static UserDAO getInstance()
	{
		if( instance == null ) instance = new UserDAO();
		
		return instance;
	}
	
	private UserDAO()
	{
		
	}
	
	public List<User> getAll()
	{
		Query q = DbConnector.getInstance().em.createNativeQuery("SELECT * FROM users", User.class);
		
		List<User> list = q.getResultList();
		
		for (User user : list) 
		{
			user.setEvents(null);
			user.setTalks(null);
		}
		return list;
	}
	
	public User getUserByEmail(String email)
	{
		Query q = DbConnector.getInstance().em.createNativeQuery("SELECT * FROM users WHERE email = '" + email + "' ", User.class);
	
		List<User> users = q.getResultList();
		
		if( users == null || users.size() < 1 ) return null;
		
		return users.get(0);
	}
	
	public User getUserByFacebook(String facebookID)
	{
		Query q = DbConnector.getInstance().em.createNativeQuery("SELECT * FROM users WHERE FACEBOOKID = '" + facebookID + "' ", User.class);
		
		List<User> users = q.getResultList();
		
		if( users == null || users.size() < 1 ) return null;
		
		return users.get(0);
	}
}
