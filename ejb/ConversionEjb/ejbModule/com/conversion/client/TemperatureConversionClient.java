package com.conversion.client;

import javax.naming.Context;
import javax.naming.NamingException;

import com.conversion.TemperatureConversionBean;
import com.conversion.businessremote.TemperatureConversionBeanRemote;

public class TemperatureConversionClient {
    public static void main(String[] args) {
    	TemperatureConversionBeanRemote bean = doLookup();
    	System.out.println("celsius : 32.5 - fahrenheit : "+bean.celsiusToFahrenheit(32.5f));
        System.out.println("fahrenheit : 43.9 - celsius : "+bean.fahrenheitToCelsius(43.9f)); // 4. Call business logic
    }
 
    private static TemperatureConversionBeanRemote doLookup() {
        Context context = null;
        TemperatureConversionBeanRemote bean = null;
        try {
            // 1. Obtaining Context
            context = ClientUtility.getInitialContext();
            // 2. Generate JNDI Lookup name
            String lookupName = getLookupName();
            // 3. Lookup and cast
            bean = (TemperatureConversionBeanRemote) context.lookup(lookupName);
 
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }
 
    private static String getLookupName() {
/* 
The app name is the EAR name of the deployed EJB without .ear suffix. 
Since we haven't deployed the application as a .ear, 
the app name for us will be an empty string
*/
        String appName = "";
 
        /* The module name is the JAR name of the deployed EJB 
        without the .jar suffix.
        */
        String moduleName = "ConversionEjb";
 
/*AS7 allows each deployment to have an (optional) distinct name. 
This can be an empty string if distinct name is not specified.
*/
        String distinctName = "";
 
        // The EJB bean implementation class name
        String beanName = TemperatureConversionBean.class.getSimpleName();
 
        // Fully qualified remote interface name
        final String interfaceName = TemperatureConversionBeanRemote.class.getName();
 
        // Create a look up string name
        String name = "" +appName + "/" + moduleName + "/"  + 
        		distinctName + "/"+ beanName + "!" + interfaceName;
 
        return name;
    }
}
