package com.comcast.crm.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImplementationClass extends BaseClass implements ITestListener, ISuiteListener {
	
	public ExtentSparkReporter spark;
	public static ExtentTest test;
	public ExtentReports report;//delclared globally to use across the script and generate advanced report
	
	@Override
	public void onStart(ISuite suite) {
	System.out.println("Report configuration");
	
//	Advanced reporting script
	
	String time = new Date().toString().replace(" ", "_").replace(":", "_");//attaching a timeStamp to capture the screenshot as per the current time
	ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReport/report"+time+".html");
	spark.config().setDocumentTitle("CRM test suite results");
	spark.config().setReportName("CRM report");
	spark.config().setTheme(Theme.DARK);
	report = new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows 10");
	report.setSystemInfo("Browser", "Chrome 100");
	
	}
	
	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("Report backup");
				
//		flush the report to save the report and to take backup of it
		report.flush();//it's a must to take a back up and save the report, if we do not use this method our reports will not be saved

	}
	
	@Override
	public void onTestStart(ITestResult result) {

//	System.out.println("===="+result.getMethod().getMethodName()+"==START==");
	
	test = report.createTest(result.getMethod().getMethodName());
	UtilityClassObject.setTest(test);
	test.log(Status.INFO, result.getMethod().getMethodName()+"==STARTED==");
	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

//	System.out.println("===="+result.getMethod().getMethodName()+"==END==");
		
	test.log(Status.PASS, result.getMethod().getMethodName()+"==COMPLETED==");
	
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
//		String testName = result.getName();
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.staticDriver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
		
//		TakesScreenshot ts = (TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String testName = result.getMethod().getMethodName();// Or the below method also works
		String time = new Date().toString().replace(" ", "_").replace(":", "_");//attaching a timeStamp to capture the screenshot as per the current time
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		
		test.log(Status.FAIL, result.getMethod().getMethodName()+"==FAILED==");
//		File dest = new File("./takesScreenshot/"+name+time+".png");
		
/*		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();*/
		
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
}
