package com.weatherexpedia.component.util;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.weatherexpedia.config.Configurator;

/*
 * Author   : Aung Thaw Aye
 * Email    : ata.aungthawaye@gmail.com
 * Mobile   : +65 9185 2209 
 * */

public class ZipcodeValidator
{
    private final static Logger LOG = Logger.getLogger(ZipcodeValidator.class);
    private final static String REGEX_PATTERN = Configurator.getProperty(Configurator.Constants.ZIPCODE_PATTERN_KEY);
    
    public static boolean isValid(String zip)
    {
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        return pattern.matcher(zip).matches();
    }
}
