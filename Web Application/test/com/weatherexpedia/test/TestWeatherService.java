package com.weatherexpedia.test;

import org.apache.log4j.Logger;

import com.weatherexpedia.component.weather.parser.impl.WundergroundWeatherReportParser;
import com.weatherexpedia.component.weather.service.impl.WundergroundWeatherService;
import com.weatherexpedia.http.response.WeatherReportResponse;

public class TestWeatherService
{
    private final static Logger LOG = Logger.getLogger(TestWeatherService.class);
    
    public static void main(String args[])
    {   
        testWeatherCondition("");
        testWeatherCondition("abcde");
        testWeatherCondition("94117");
    }
    
    public static void testWeatherCondition(String zip)
    {
        WundergroundWeatherService ws = new WundergroundWeatherService();
        ws.setParser(new WundergroundWeatherReportParser());
        WeatherReportResponse response = ws.getWeatherCondition(zip);
        LOG.debug("****************************************************************");
        LOG.debug("\tTesting with Input : '" + zip + "'");
        LOG.debug("\t\t status : " + response.getStatus());
        LOG.debug("\t\t message : " + response.getMessage());
        LOG.debug("\t\t zip : " + (response.getReport() != null ? response.getReport().getZipCode() : "<NO DATA>"));
        LOG.debug("\t\t report : " + (response.getReport() != null ? response.getReport().getTemperatureString() : "<NO DATA>"));
    }
}
