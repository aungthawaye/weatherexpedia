package com.weatherexpedia.component.weather.service;

import com.weatherexpedia.http.response.WeatherReportResponse;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */


public interface WeatherService
{
    public WeatherReportResponse getWeatherCondition(String zipCode);
}
