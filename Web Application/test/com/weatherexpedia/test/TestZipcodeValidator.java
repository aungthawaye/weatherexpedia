package com.weatherexpedia.test;

import org.apache.log4j.Logger;

import com.weatherexpedia.component.util.ZipcodeValidator;

public class TestZipcodeValidator
{
    private final static Logger LOG = Logger.getLogger(TestZipcodeValidator.class);
    
    public static void main(String args[])
    {
        testValidator("912a34");
        testValidator("");
        testValidator("abc");
        testValidator("-91234");
        testValidator("91234");
    }
    
    public static void testValidator(String zip)
    {
        LOG.debug("****************************************");
        LOG.debug("\tTesting zip : '" + zip + "'");
        LOG.debug("\tValid : " + ZipcodeValidator.isValid(zip));
    }
}
