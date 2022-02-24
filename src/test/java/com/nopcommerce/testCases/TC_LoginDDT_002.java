package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDataDrivenTest(String user, String pwd) throws InterruptedException, IOException
	{
		System.out.println("Executiong TC_LoginDDT_002");
		driver.manage().window().maximize();
		driver.get(baseURL);
		logger.info("URL opened");
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("User = " +user +" Password = " + pwd);
		lp.setEmail(user);
		logger.info("Setting user email " + user);
		
		lp.setPassword(pwd);
		logger.info("Setting user password " + pwd);
		
		logger.info("Clicking login");
		lp.clickLogin();
		Thread.sleep(2000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			logger.info("Login successful");
			Thread.sleep(1000);
			lp.clickLogout();
		}
		else
		{
			captureScreen(driver,"loginDataDrivenTest");
			Assert.fail();
			logger.info("Login failed");
		}

	}
	
	@DataProvider(name ="LoginData")
	public String [][] getData() throws IOException
	{
		String path =System.getProperty("user.dir")+ "/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		System.out.println("Xl path = " + path);
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String [rownum][colcount];
		try {
			for (int i=1; i<=rownum; i++)
			{
				for (int j=0;j<colcount;j++)
				{
					loginData[i-1][j]= XLUtils.getCellData(path, "Sheet1", i, j);	
				}
			}
		}catch(Exception e)
		{
			System.out.println("\n\nError occured "+e.getMessage() + " \n");
		}
		
		return loginData;
	}
	
}
