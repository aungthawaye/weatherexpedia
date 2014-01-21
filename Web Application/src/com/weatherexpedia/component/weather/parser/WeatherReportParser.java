package com.weatherexpedia.component.weather.parser;

import java.util.Map;

import com.weatherexpedia.model.WeatherReport;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */


public interface WeatherReportParser
{
    public WeatherReport parse(Map<String, Object> jsonMap);
    public Map<String, String> verify(Map<String, Object> jsonMap);
}
