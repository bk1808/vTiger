package practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*
public class SampleReportTest {
// To use the below program inside every test scripts, we need to add it to configuration methods
	
	ExtentReports report;//delclared globally to use across the script 
	
/*	@BeforeSuite
	public void configBS() {
		// FIRST STAGE: Spark report config steps
//		step-1: create an object of ExtentSparkReporter for specifying the location where you want to generate a report
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport/report.html");
		
//		step-2: using spark object configure document title
		
		spark.config().setDocumentTitle("CRM test suite results");
		
//		step-3: using spark object create report name
		
		spark.config().setReportName("CRM report");
		
//		ste-4: set the type of the theme
		
		spark.config().setTheme(Theme.DARK);	
		
		//ADD environment information and create test
		
//		step-5: create an object of ExtentReports and pass the config(1)
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Browser", "Chrome 100");
	}
	
	@AfterSuite
	public void configAS(){
	
		report.flush();//it's a must to take a back up and save the report, if we do not use this method our reports will not be saved
		
	}
	
	@Test
	public void createContactTest() {

		ExtentTest test = report.createTest("createContacTest");
		
//		LOG: create log instead of SOP statements
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "create contact");
		}
		else {
			test.log(Status.FAIL, "create contact");
		}
		
		report.flush();
		
	}
	
	@Test
	public void createContactWithOrg() {

		ExtentTest test = report.createTest("createContactWithOrg");
		
//		LOG: create log instead of SOP statements
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "createContactWithOrg");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created with org");
		}
		else {
			test.log(Status.FAIL, "contact is not created with org");
		}
		
		report.flush();
		
	}
	
	@Test
	public void createContactWithPhoneNumber() {

		ExtentTest test = report.createTest("createContactWithPhoneNumber");
		
//		LOG: create log instead of SOP statements
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "createContactWithPhoneNumber");
		
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact created with phone no.");
		}
		else {
			test.log(Status.FAIL, "contact is not created with phone no.");
		}
		
		report.flush();
		
	}
	
	@Test
	public void createContactTestTS() {

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8888");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContacTest");
		
//		LOG: create log instead of SOP statements
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		
		if("HDFC".equals("HFDC")) {
			test.log(Status.PASS, "create contact");
		}
		else {
			test.log(Status.FAIL, "create contact");
			
			test.addScreenCaptureFromBase64String(filePath, "Error File");
			
		}
		driver.close();
		report.flush();
		
	}
	
}
*/