package com.weatherexpedia.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */

/*
 * The purpose of this class is to load the API key from 'config.properties' file.
 */
public class Configurator
{
    private final static Logger LOG = Logger.getLogger(Configurator.class);
    private final static String CONFIG_FILE = "config.properties";
    private static Properties properties = null;

    // load properties from configuration file
    static
    {
        InputStream in = null;
        try
        {
            // load properties file
            in = Thread.currentThread().getContextClassLoader().getResourceAsStream(CONFIG_FILE);
            properties = new Properties();
            properties.load(in);
        }
        catch(Exception e)
        {
            LOG.fatal(e);
        }
        finally
        {
            if(in != null) try
            {
                in.close();
            }
            catch (IOException e)
            {
                // do nothing
            }
        }
    }
    
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
    
    public static class Constants
    {
        public static final String API_KEY = "api.key.value";
        public static final String ZIPCODE_PATTERN_KEY = "us.zipcode.pattern.value";
    }
}
