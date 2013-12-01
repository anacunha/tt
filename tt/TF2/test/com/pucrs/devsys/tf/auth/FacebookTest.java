package com.pucrs.devsys.tf.auth;

import org.junit.Test;

import junit.framework.Assert;




public class FacebookTest {

	private static final String secret = "1b52ee878cd9b32494ebafb9d5d3a558";
    private static final String client_id = "1410298582533255";  
    private static final String redirect_uri = "http://localhost:8080/TF2/rest/loginfb"; 

    
    
   //com.pucrs.devsys.tf.auth.Facebook
    //Test
	@Test
    public  void getAuthURLFalhaTest() {
	  String linkFace =  "";//Facebook.getAuthURL("codigo2");
      StringBuilder linkEsp = new StringBuilder();
      
      linkEsp.append("https://graph.facebook.com/oauth/authorize?client_id=");
      linkEsp.append(client_id);
      linkEsp.append("&redirect_uri=");
      linkEsp.append(redirect_uri);
      linkEsp.append("&client_secret=");
      linkEsp.append(secret);
      linkEsp.append("&code=");
      linkEsp.append("codigo");
      System.out.println(linkEsp.toString());
       if(linkFace.equals(linkEsp.toString())) {
    	   Assert.fail("Não ta montando o link corretamente");
       }
    }
	
    //Test
	@Test
    public  void getAuthURLCorretoTest() {
	  
	String linkFace =  Facebook .getAuthURL("codigo");
      StringBuilder linkEsp = new StringBuilder();
      
      linkEsp.append("https://graph.facebook.com/oauth/authorize?client_id=");
      linkEsp.append(client_id);
      linkEsp.append("&redirect_uri=");
      linkEsp.append(redirect_uri);
      linkEsp.append("&client_secret=");
      linkEsp.append(secret);
      linkEsp.append("&code=");
      linkEsp.append("codigo");
      System.out.println(linkEsp.toString());
       if(linkFace.equals(linkEsp.toString())) {
    	   Assert.fail("Não ta montando o link corretamente");
       }
    }
	


}
