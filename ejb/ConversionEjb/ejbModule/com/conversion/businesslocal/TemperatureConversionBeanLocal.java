package com.conversion.businesslocal;

import javax.ejb.Local;

import com.conversion.business.TemperatureConversion;

@Local
public interface TemperatureConversionBeanLocal extends TemperatureConversion {

}
