package com.nopcommerce.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver lDriver;
	
	public AddCustomerPage(WebDriver rDriver)
	{
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	// Identify all the element to perform Add new customer
	
	By lnkCustomersMenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomersMenuItem = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	
	By btnAddNew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	By txtFirstName = By.xpath("//*[@id=\"FirstName\"]");
	By txtLastNAme = By.xpath("//*[@id=\"LastName\"]");
	By rdMaleGender = By.id("Gender_Male");
	By rdFemaleGender = By.id("Gender_Female");
	
	By dtpickerDOB = By.id("DateOfBirth");
	
	By txtCompanyName = By.xpath("//*[@id=\"Company\"]");
	By chkTaxExempt = By.id("IsTaxExempt");
	By drpNewsLetter = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div");
	
	
	By txtCustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	By lstItemAdministrator = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By lstItemForumModerator = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By lstItemGuest = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By lstItemRegistered = By.xpath("//*[@id=\"c35c5c19-4f04-4417-982a-037aa7ca70ef\"]");
	By lstItemVendor = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	//By a = By.xpath("");
	
	
	
	By drpMgrOfVendor = By.xpath("//*[@id=\"VendorId\"]");
	By chkActive = By.id("Active");
	By txtAdminComment = By.xpath("//*[@id=\"AdminComment\"]");
	By btnSave = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	By btnSaveContinue = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[2]");
	By alnkBacktoCustomer = By.xpath("/html/body/div[3]/div[1]/form/div[1]/h1/small/a");
	
	public void clickOnCustomersMenu()
	{
		lDriver.findElement(lnkCustomersMenu).click();
	}
	
	public void clickCustomersMenuItem()
	{
		lDriver.findElement(lnkCustomersMenuItem).click();
	}
	
	public void clickAddNew()
	{
		lDriver.findElement(btnAddNew).click();
	}
	
	
	public void setEmail(String email)
	{
		lDriver.findElement(txtEmail).sendKeys(email);;
	}
	
	public void setPassword(String pwd)
	{
		lDriver.findElement(txtPassword).sendKeys(pwd);;
	}
	
	public void setFirstName(String firstName)
	{
		lDriver.findElement(txtFirstName).sendKeys(firstName);;
	}
	
	public void setLastName(String lastName)
	{
		lDriver.findElement(txtLastNAme).sendKeys(lastName);
	}
	
	public void setCustomerRoles(String role)
	{
		//Clear the text box
		System.out.println("inside Cust Role");
		
		lDriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div")).click();	
		System.out.println("Cust Role .click() done");
		
		//Click the element to show the drop down
		lDriver.findElement(txtCustomerRoles).click();
		WebElement listItem;
		System.out.println("Switching role");
		switch(role)
		{
		case "Administrators":
			System.out.println("Role= administrator");
			listItem = lDriver.findElement(lstItemAdministrator); break;
		case "Forum Moderators":
			System.out.println("role = Forum Moderators");
			listItem = lDriver.findElement(lstItemForumModerator); break;
		case "Guests":
			listItem =lDriver.findElement(lstItemGuest); break;
		case "Registered":
			listItem =lDriver.findElement(lstItemRegistered); break;
		case "Vendors":
			System.out.println("role = vendors");
			listItem =lDriver.findElement(lstItemVendor);
			//listItem.click();
			break;
		default:
			listItem =lDriver.findElement(lstItemGuest); break;
		}
		
		System.out.println("Outside switch-case");
		//listItem.click(); // not working then user JavaScriptExecutor
		
		JavascriptExecutor js = (JavascriptExecutor) lDriver; 
		System.out.println("Java script listItem.getText() ="  +listItem.getText());
		js.executeScript("arguments[0].click();", listItem);
		//System.out.println("Cust Role javascript executed");
	}
	
	public void setManagerOfVendor(String val)
	{
		System.out.println("Setting Vendor");
		Select drp = new Select (lDriver.findElement(drpMgrOfVendor));
		drp.selectByVisibleText(val);
		System.out.println("Setting vendor");
	}
	
	public void setGender(String gender)
	{
		System.out.println("Executing setGender");
		if (gender.equals("Male"))
		{
			lDriver.findElement(rdMaleGender).click();
		}
		else if (gender.equals("Female"))
		{
			System.out.println("Gender =" +gender);
			lDriver.findElement(rdFemaleGender).click();
		}
		else
		{
			lDriver.findElement(rdMaleGender).click();
		}	
		//System.out.println("Setting gender done");
	}
	
	public void setDOB(String dob)
	{
		System.out.println("Setting DOB");
		lDriver.findElement(dtpickerDOB).sendKeys(dob);
		System.out.println("Setting DOB done");
	}
	
	public void setCompanyName(String companyName)
	{
		System.out.println("Setting company name");
		lDriver.findElement(txtCompanyName).sendKeys(companyName);
		System.out.println("Setting company name done");
	}
	
	public void setActive(String active)
	{
		System.out.println("Setting Active");
		if (active.equals("false"))
		{
			lDriver.findElement(chkActive).click();
		}
		else
		{
			//lDriver.findElement(chkActive).clear();
		}
		System.out.println("Setting Active done");
		
	}
	
	public void setAdminComment(String comment)
	{
		System.out.println("Setting admin comment");
		lDriver.findElement(txtAdminComment).sendKeys(comment);
	}
	
	public void clickOnSave()
	{
		lDriver.findElement(btnSave).click();
	}
	
	public void setIsTaxExempt(String taxExempt)
	{
		System.out.println("Setting ISTaxExempt");
		if (taxExempt.equals("true"))
		{	
			System.out.println("Setting IsTaxExempt true");
			lDriver.findElement(chkTaxExempt).click();
			System.out.println("Setting IsTaxExempt(true) done");
		}
		else
		{	
			System.out.println("Setting IsTaxExempt to false");
			lDriver.findElement(chkTaxExempt).click();
			System.out.println("Setting IsTaxExempt done");
		}
		
	}
	
	public void setNewLetter(String newsLetter)
	{
		System.out.println("Setting news letter");
		Select drpNews = new Select(lDriver.findElement(drpNewsLetter));
		//lDriver.findElement(drpNewsLetter).click();
		//drpNews.
		drpNews.selectByVisibleText(newsLetter);
		System.out.println("Setting News letter done");
		
		
	}
}
