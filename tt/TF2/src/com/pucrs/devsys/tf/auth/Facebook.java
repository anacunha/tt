package com.pucrs.devsys.tf.auth;

import com.visural.common.StringUtil;

public class Facebook {
    // get these from your FB Dev App
    private static final String api_key = "MYAPIKEY";     
    private static final String secret = "1b52ee878cd9b32494ebafb9d5d3a558";
    private static final String client_id = "1410298582533255";  

    // set this to your servlet URL for the authentication servlet/filter
    private static final String redirect_uri = "http://localhost:8080/TF2/rest/loginfb"; 
    /// set this to the list of extended permissions you want
    private static final String[] perms = new String[] {"publish_stream", "email"};

    public static String getAPIKey() {
        return api_key;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id=" + 
            client_id + "&display=page&redirect_uri=" + 
            redirect_uri+"&scope="+StringUtil.delimitObjectsToString(",", perms);
    }

    public static String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" + 
            client_id+"&redirect_uri=" + 
            redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
}
