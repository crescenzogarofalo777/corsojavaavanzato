package com.conversion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.conversion.businesslocal.TemperatureConversionBeanLocal;
import com.conversion.businessremote.TemperatureConversionBeanRemote;

/**
 * Session Bean implementation class TemperatureConverter
 */
@Stateless
@LocalBean
public class TemperatureConversionBean implements TemperatureConversionBeanLocal, TemperatureConversionBeanRemote{

    /**
     * Default constructor. 
     */
    public TemperatureConversionBean() {
    }

	@Override
	public float fahrenheitToCelsius(float temp) {
		return (temp - 32)/1.8f;
	}

	@Override
	public float celsiusToFahrenheit(float temp) {
		return temp*1.8f + 32;
	}

}
