package com.crmGenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility
{
	/**
	 * this method will read data from property file for the key given by user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	
	
public String readDataFromPropertyFile(String key) throws Throwable
{
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties pLib= new Properties();
	pLib.load(fis);
	String value = pLib.getProperty(key);
	return value;
	
}
}
