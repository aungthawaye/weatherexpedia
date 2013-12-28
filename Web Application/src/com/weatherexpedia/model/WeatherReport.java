package com.weatherexpedia.model;

public class WeatherReport extends Report
{
    private String zipCode;
    private String temperatureC;
    private String temperatureF;
    private String temperatureString;
    private String fullAddress;
    private String city;
    private String state;
    private String country;
    private String latitude;
    private String longitude;

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getTemperatureC()
    {
        return temperatureC;
    }

    public void setTemperatureC(String temperatureC)
    {
        this.temperatureC = temperatureC;
    }

    public String getTemperatureF()
    {
        return temperatureF;
    }

    public void setTemperatureF(String temperatureF)
    {
        this.temperatureF = temperatureF;
    }

    public String getTemperatureString()
    {
        return temperatureString;
    }

    public void setTemperatureString(String temperatureString)
    {
        this.temperatureString = temperatureString;
    }

    public String getFullAddress()
    {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress)
    {
        this.fullAddress = fullAddress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

}
