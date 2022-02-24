package com.nopcommerce.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Orginal_Reporting extends TestListenerAdapter 
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		System.out.println("Inside the listner onStart Method (Reporting class)");
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "Test_Report_"+ timestamp+".html";
		System.out.println("RepName =" +repName);
		
		System.out.println("here Report location = " + System.getProperty("user.dir")+"/test-output/"+ repName);
		
		//htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ repName  );
		
		//htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
		//htmlReporter.loadXMLConfig(System.getProperty("user.dir") +"/extent-config.xml");
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/mySANReport.html");//specify location of the report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Host Name ", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "tester");
		extent.setSystemInfo("browser","Chrome");
		extent.setSystemInfo("os","Windows");
		
		htmlReporter.config().setDocumentTitle("nopCommerce Test Project")   ;
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test is successful 121sasa =tr.getName() " + tr.getName());
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS , MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		 
	}
	
	public void OnTestFailure(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		 
		String screenshotpath = System.getProperty("user.dir")+"\\Screenshots\\" + tr.getName()+".png";
		
		File f = new File(screenshotpath);
		
		if (f.exists())
		{
			try{
				logger.fail("Screenshot is below :" + logger.addScreenCaptureFromPath(screenshotpath));
			}catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	
	public void onFinish()
	{
		extent.flush();
	}
}

