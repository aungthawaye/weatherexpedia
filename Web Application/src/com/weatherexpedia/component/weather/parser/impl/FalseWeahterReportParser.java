package com.weatherexpedia.component.weather.parser.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.weatherexpedia.component.weather.parser.WeatherReportParser;
import com.weatherexpedia.model.WeatherReport;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */


/*
 * I added this class to show how we should configure @Autowired. If there are 2 class which implements same interface, then
 * Spring starts throw error. So, we should configure such DI in xml also.
 */


@Service
public class FalseWeahterReportParser implements WeatherReportParser
{

    @Override
    public WeatherReport parse(Map<String, Object> jsonMap)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, String> verify(Map<String, Object> jsonMap)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
