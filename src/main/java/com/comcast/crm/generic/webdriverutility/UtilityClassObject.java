package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
// This class is for using static variables inside the framework, ThreadLocal object will create instances of static variables
	
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>(); 
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	
//	We need to provide the getters and setters method to access and to use the ExtentTest and WebDriver object
	public static ExtentTest gettest() {
	
		return test.get();
	}
	
	public static void setTest(ExtentTest actTest) {
		
		test.set(actTest);
	}
	
	public static WebDriver getDriver() {
		
		return driver.get();
		
	}
	
	public static void setDriver(WebDriver actDriver) {
		
		driver.set(actDriver);
	}
	
}
