package com.nopcommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver)
	{
		ldriver= rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath ="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnlogin;
	
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	@CacheLookup
	WebElement lnklogout;
	
	public void setEmail(String val)
	{
		txtemail.clear();
		txtemail.sendKeys(val);
	}
	
	public void setPassword(String val)
	{
		txtpassword.clear();
		txtpassword.sendKeys(val);
	}
	
	public void clickLogin()
	{
		btnlogin.click();
	}
	
	public void clickLogout()
	{
		lnklogout.click();
	}
	
}
