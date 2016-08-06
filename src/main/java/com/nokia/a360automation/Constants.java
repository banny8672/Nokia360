package com.nokia.a360automation;

public class Constants 
{
	private static Constants constants = null;

	private String username;
	private String password;
	private String downloadPath;
	private Long   webDriverTimeout;
	private Long   sleepTime;
	private String siteUrl;

	private Constants()
	{}
	
	public static Constants getConstants()
	{
		if(constants == null)
		{
			constants = new Constants();
			MyProperties myProperties = new MyProperties();
			constants.username =  myProperties.getPropertyValue("USERNAME");
			constants.password =  myProperties.getPropertyValue("PASSWORD");
			constants.downloadPath =  myProperties.getPropertyValue("DOWNLOAD_PATH");
			constants.webDriverTimeout =  myProperties.getLongPropertyValue("WEB_DRIVER_TIMEOUT");
			constants.sleepTime =  myProperties.getLongPropertyValue("SLEEP_TIME");
			constants.siteUrl =  myProperties.getPropertyValue("SITE_URL");
		}
		
		return constants;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDownloadPath() {
		return downloadPath;
	}

	public Long getWebDriverTimeout() {
		return webDriverTimeout;
	}

	public Long getSleepTime() {
		return sleepTime;
	}

	public String getSiteUrl() {
		return siteUrl;
	}
	
}
