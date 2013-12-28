package com.weatherexpedia.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.weatherexpedia.component.WeatherService;
import com.weatherexpedia.component.ZipcodeValidator;
import com.weatherexpedia.config.Configurator;
import com.weatherexpedia.http.response.WeatherReportResponse;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */

/*
 * This is the main controller for this weather application. It will redirect you to the weather report page when
 * you access its request mapping pattern. 
 */
@Controller
public class WeatherExpediaController
{
    private final static Logger LOG = Logger.getLogger(WeatherExpediaController.class);
    
    
    /*
     * This method is just to redirect the user to weatherexpedia home page. 
     */
    @RequestMapping("/weather")
    public ModelAndView goToWeatherReport()
    {
        LOG.debug("Accessing /weather url");
        String apiKey = Configurator.getProperty(Configurator.Constants.API_KEY);
        LOG.debug("API Key loaded : " + apiKey);
        return new ModelAndView("weather_report", "apiKey", apiKey);
    }
    
    /*
     * This method return the weather response in JSON format. 
     */
    @RequestMapping(value ="/getreport", method = RequestMethod.GET)    
    public @ResponseBody WeatherReportResponse  getReport(@RequestParam String zip)
    {
        LOG.debug("Get weather report for : " + zip);
        // Do validation
        if(ZipcodeValidator.isValid(zip) == false)
        {
            LOG.debug("Invalid zip code : " + zip);
            WeatherReportResponse response = new WeatherReportResponse();
            response.setMessage("invalid zip code format");
            response.setStatus("F");
            return response;
        }
        
        WeatherService ws = new WeatherService();
        WeatherReportResponse response = ws.getWeatherCondition(zip); 
        return response;
    }
}
