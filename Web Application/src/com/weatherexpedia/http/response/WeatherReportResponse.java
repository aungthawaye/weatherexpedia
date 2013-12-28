package com.weatherexpedia.http.response;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.weatherexpedia.model.WeatherReport;

@JsonAutoDetect
public class WeatherReportResponse 
{    
    private String status;
    private String message;
    private WeatherReport report;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public WeatherReport getReport()
    {
        return report;
    }

    public void setReport(WeatherReport report)
    {
        this.report = report;
    }

}
