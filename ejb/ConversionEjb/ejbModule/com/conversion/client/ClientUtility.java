package com.conversion.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtility {
	private static Context initialContext;
	 
    private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
        	
            Properties p = new Properties();

            p.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            p.put(javax.naming.Context.PROVIDER_URL, "remote://localhost:4447");
            p.put("jboss.naming.client.ejb.context", true);
            p.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            
            initialContext = new InitialContext(p);
        }
        return initialContext;
    }
}
