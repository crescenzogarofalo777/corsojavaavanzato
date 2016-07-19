package com.conversion.businessremote;

import javax.ejb.Remote;

import com.conversion.business.TemperatureConversion;

@Remote
public interface TemperatureConversionBeanRemote  extends TemperatureConversion {

}
