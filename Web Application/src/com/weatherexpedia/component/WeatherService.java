package com.weatherexpedia.component;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.weatherexpedia.config.Configurator;
import com.weatherexpedia.http.response.WeatherReportResponse;
import com.weatherexpedia.model.WeatherReport;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */

/*
 * It will call the wunderground's weather service API (JSON) and return the response is Map.
 */

public class WeatherService
{
    private final static Logger LOG = Logger.getLogger(WeatherService.class);
    private final static String API_KEY = Configurator.getProperty(Configurator.Constants.API_KEY);
    private final static String WCONDITION_URL = "http://api.wunderground.com/api/" + API_KEY + "/conditions/q/";
    
    public WeatherReportResponse getWeatherCondition(String zipCode)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(WCONDITION_URL).append(zipCode).append(".json");
        Map<String, Object> jsonMap = APIHelper.callAPI(sb.toString());
        
        WeatherReportResponse report = new WeatherReportResponse();
        
        // verify whether the response from the API is successful or failure.
        Map<String, String> verfication = WeatherReportParser.verify(jsonMap);
        if(verfication != null)
        {
            LOG.debug("Reponse is failture : " + jsonMap);
            report.setMessage(verfication.get("desc"));
            report.setStatus("F");
            report.setReport(null);
            return report;
        }
        LOG.debug("Reponse is successful.");
        WeatherReport wreport = null;
        wreport = WeatherReportParser.parse(jsonMap);
        report.setStatus("S");
        report.setMessage("SUCCESS");
        
        report.setReport(wreport);
        
        return report;
    }
    
    /*
     * Helper class to access wunderground API 
     */
    private static class APIHelper 
    {
        @SuppressWarnings("unchecked")
        private final static Map<String, Object> callAPI(String apiUrlAndParams)
        {
            Map<String, Object> json = null;
            try
            {                
                LOG.debug("Calling : " + apiUrlAndParams);
                ObjectMapper mapper = new ObjectMapper();
                json = mapper.readValue(new URL(apiUrlAndParams), Map.class);
            }
            catch (IOException e)
            {
                LOG.fatal(e);
            }
            return json;
        }
    }
}
