package com.nopcommerce.testCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.AddCustomerPage;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.manage().window().maximize();
		driver.get(baseURL);
		logger.info("TC_AddCustomerTest_003 - URL opened " + baseURL);
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		logger.info("Clicking login  " );
		Thread.sleep(1000);
		lp.clickLogin();
		
		logger.info("TC_AddCustomerTest_003 - Adding new customer details");
		AddCustomerPage addCustomer= new AddCustomerPage(driver);
		addCustomer.clickOnCustomersMenu();
		addCustomer.clickCustomersMenuItem();
		//Thread.sleep(3000);
		addCustomer.clickAddNew();
		
		String email= randomString() +"@gmail.com";
		addCustomer.setEmail(email);
		//Thread.sleep(3000);
		
		addCustomer.setPassword("test123#");
		//Thread.sleep(3000);
		
		addCustomer.setFirstName("Oliviacarmen");
		addCustomer.setLastName("Smith");
		//Thread.sleep(1000);
		
		Thread.sleep(1000);
		System.out.println("Setting gender" );
		logger.info("TC_AddCustomerTest_003 - Setting");
		addCustomer.setGender("Female");
		
		Thread.sleep(1000);
		addCustomer.setDOB("5/15/2021");
		addCustomer.setCompanyName("Test Company aaa");
		
		try
		{
			addCustomer.setIsTaxExempt("false");
			addCustomer.setNewLetter("Your store name");
		}catch(Exception e)
		{
			System.out.println("Error occured." + e.getMessage());
		}
		
		
		addCustomer.setCustomerRoles("Vendors");
		
		addCustomer.setCustomerRoles("Forum Moderators");
		
		addCustomer.setManagerOfVendor("Vendor 2");
		
		addCustomer.setActive("false");
		
		addCustomer.setAdminComment("This is admin comment");
		
		Thread.sleep(5000);
		addCustomer.clickOnSave();
		logger.info("Validation started after cliccking save");
		String msg= driver.findElement(By.tagName("body")).getText();
		if (msg.contains("The new customer has been added successfully"))
		{
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else
		{
			captureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
			
	}
	
	
}
