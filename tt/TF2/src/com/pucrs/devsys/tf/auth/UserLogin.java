package com.pucrs.devsys.tf.auth;

import java.net.URL;

import org.codehaus.jettison.json.JSONObject;

import com.pucrs.devsys.tf.db.dao.UserDAO;
import com.pucrs.devsys.tf.persistence.User;
import com.visural.common.IOUtil;

public class UserLogin 
{

    public User authFacebookLogin(String accessToken, int expires) 
    {
        try 
        {
            JSONObject resp = new JSONObject(IOUtil.urlToString(new URL("https://graph.facebook.com/me?access_token=" + accessToken)));
            
            String id = resp.getString("id");
            String firstName = resp.getString("first_name");
            String lastName = resp.getString("last_name");
            String email = resp.getString("email");

            User user = UserDAO.getInstance().getUserByEmail(email);
            
            if( user == null )
            {
            	user = new User();
            	user.setFacebookId(id);
                user.setName( firstName + " " + lastName );
                user.setEmail( email );
                
                UserDAO.getInstance().update( user );
            
            	System.out.println( "Usuario Logado:" + id + " : " + firstName + " : " + lastName + " : " + email );
            }
            

            return user;
            
        } catch (Throwable ex) 
        {
            throw new RuntimeException("failed login", ex);
        }
    }
}
