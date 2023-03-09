package tesing;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RunningGoogle {

	public static void main(String[] args) throws IOException {
		
		WebDriver ob;
		ExtentReports extentreport;
		ExtentSparkReporter sparkreporter;
		ExtentTest testcase;
		
		
		extentreport=new ExtentReports();
		sparkreporter=new ExtentSparkReporter("Googlereport.html");
		extentreport.attachReporter(sparkreporter);
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\geckodriver\\geckodriver.exe");
		ob=new FirefoxDriver();
		testcase=extentreport.createTest("Executing the google page");
		ob.get("https://www.google.com");
		String title= ob.getTitle();
		
		if(title.equals("google"))
		{
			testcase.log(Status.PASS, "The title is equal");
		}
		
		else
		{
			testcase.log(Status.FAIL, "The title not is equal").addScreenCaptureFromPath("google.png");
		}
			
		TakesScreenshot screenshot=(TakesScreenshot) ob;
		File sourcefile= screenshot.getScreenshotAs(OutputType.FILE);
		File destinationfile=new File("google.png");
		FileHandler.copy(sourcefile, destinationfile);
		
		
		ob.close();
		extentreport.flush();
	}

}
