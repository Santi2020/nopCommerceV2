package com.nopcommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File ("./configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			
			System.out.println("Error  =" +e.getMessage() );
			
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getEdgePath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
		
}
	