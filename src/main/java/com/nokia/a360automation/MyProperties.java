package com.nokia.a360automation;

import java.io.IOException;
import java.util.Properties;

public class MyProperties 
{
	private Properties myProperties;

	public MyProperties() 
	{
		myProperties = new Properties();

		try {
			myProperties.load(getClass().getResourceAsStream("/config.properties")); 
		} catch (IOException e) {
			System.err.println("Error loading config.properties");
			e.printStackTrace();
		}  
		catch (Exception e) {
			System.err.println("Error loading config.properties");
			e.printStackTrace();
		}  
	}

	public String getPropertyValue(String key) {
		return myProperties.getProperty(key);
	}
	
	public Long getLongPropertyValue(String key) {
		return Long.parseLong(myProperties.getProperty(key));
	}
}