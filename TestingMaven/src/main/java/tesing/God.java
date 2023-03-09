package tesing;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class God {
	
	WebDriver ob;
	ExtentReports extentreport;
	ExtentSparkReporter sparkreporter;
	ExtentTest testcase;
	
	@BeforeSuite
	public void browser()
	{
		
		extentreport=new ExtentReports();
		sparkreporter=new ExtentSparkReporter("extentreport.html");
		extentreport.attachReporter(sparkreporter);
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\geckodriver\\geckodriver.exe");
		ob=new FirefoxDriver();
	}
	
	@AfterSuite
	public void close()
	{
		ob.close();
		extentreport.flush();
	}
	
	@Test
	public void google()
	{
		testcase=extentreport.createTest("Executing the google page");
		ob.get("https://www.google.com");
		String title= ob.getTitle();
		
		if(title.equals("Google"))
		{
			testcase.log(Status.PASS, "The title is equal");
		}
		
		else
		{
			testcase.log(Status.FAIL, "The title is equal");
		}
			
	}
	
	@Test
	public void bing() throws IOException
	{
		testcase=extentreport.createTest("Executing the bing page");
		ob.get("https://www.bing.com");
		
		String title= ob.getTitle();
		
		if(title.equals("bing"))
		{
			testcase.log(Status.PASS, "The title is equal");
		}
		
		else
		{
			testcase.log(Status.FAIL, "The title is equal").addScreenCaptureFromPath("bing.png");
			
			TakesScreenshot screenshot=(TakesScreenshot) ob;
			File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
			File destinationfile=new File("bing.png");
			FileHandler.copy(sourcefile, destinationfile);
			
			
		}
	}

	public static void main(String[] args) {
		
	}

}
