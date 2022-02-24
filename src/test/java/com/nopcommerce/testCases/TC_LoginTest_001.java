package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws InterruptedException, IOException  
	{
		driver.get(baseURL);
		logger.info("URL opened " + baseURL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		logger.info("Clicking login  " );
		Thread.sleep(3000);
		lp.clickLogin();
		Thread.sleep(1000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Login successful");
			Thread.sleep(1000);
			lp.clickLogout();
		}
		else
		{
			captureScreen(driver,"LoginTest");
			Assert.fail();
			logger.info("Login failed");
		}
	}
	
	
}
