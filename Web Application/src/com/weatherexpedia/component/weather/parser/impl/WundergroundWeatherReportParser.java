package com.weatherexpedia.component.weather.parser.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.weatherexpedia.component.weather.parser.WeatherReportParser;
import com.weatherexpedia.model.WeatherReport;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */


@Service
public class WundergroundWeatherReportParser implements WeatherReportParser
{

    private final static Logger LOG = Logger.getLogger(WeatherReportParser.class);

    @SuppressWarnings("unchecked")
    public WeatherReport parse(Map<String, Object> jsonMap)
    {
        Map<String, Object> curObservationMap = (Map<String, Object>) jsonMap.get("current_observation");
        String tempString = (String) curObservationMap.get("temperature_string");
        String tempC = "";

        if (curObservationMap.get("temp_c") instanceof Double)
            tempC = ((Double) curObservationMap.get("temp_c")).toString();
        else if (curObservationMap.get("temp_c") instanceof Integer)
            tempC = ((Integer) curObservationMap.get("temp_c")).toString();

        String tempF = "";

        if (curObservationMap.get("temp_f") instanceof Double)
            tempF = ((Double) curObservationMap.get("temp_f")).toString();
        else if (curObservationMap.get("temp_f") instanceof Integer)
            tempF = ((Integer) curObservationMap.get("temp_f")).toString();

        Map<String, Object> observationLocMap = (Map<String, Object>) curObservationMap.get("observation_location");
        String fullAddr = (String) observationLocMap.get("full");
        String city = (String) observationLocMap.get("city");
        String state = (String) observationLocMap.get("state");
        String country = (String) observationLocMap.get("country");
        String latitude = (String) observationLocMap.get("latitude");
        String longitude = (String) observationLocMap.get("longitude");

        Map<String, Object> displayLocMap = (Map<String, Object>) curObservationMap.get("display_location");
        String zip = (String) displayLocMap.get("zip");

        WeatherReport report = new WeatherReport();
        report.setCity(city);
        report.setCountry(country);
        report.setFullAddress(fullAddr);
        report.setLatitude(latitude);
        report.setLongitude(longitude);
        report.setState(state);
        report.setTemperatureC(tempC);
        report.setTemperatureF(tempF);
        report.setTemperatureString(tempString);
        report.setZipCode(zip);

        return report;
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> verify(Map<String, Object> jsonMap)
    {
        Map<String, Object> responseMap = (Map<String, Object>) jsonMap.get("response");
        LOG.debug("responseMap : " + responseMap);
        Map<String, Object> errorMap = (Map<String, Object>) responseMap.get("error");
        LOG.debug("errorMap : " + errorMap);
        if (errorMap == null || errorMap.isEmpty())
            return null;

        String type = (String) errorMap.get("type");
        String msg = (String) errorMap.get("description");

        if (type != null && type.equals("querynotfound"))
            msg = "zipcode not found";

        Map<String, String> response = new HashMap<String, String>();
        response.put("type", type);
        response.put("desc", msg);

        return response;
    }

}
