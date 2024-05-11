package com.comcast.crm.basetest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class GridBaseClass {
// create objects for utility classes and make them public to access across the test scripts
	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public RemoteWebDriver driver = null;//declaring it globally to use across the class
	public static RemoteWebDriver sdriver = null;//to use the local varibale outside the test method
	
	@BeforeSuite (/*groups = {"smoke test", "regression test"}*/)
	public void beforeSuiteTest() throws SQLException	{
		System.out.println("====connect to Database, Report config====");
//		dLib.getDBConnection();
		
	}
	//Parameters annotation from testNG
//	@Parameters ("browser")
	@BeforeClass (/*groups = {"smoke test", "regression test"}*/)
	public void beforeClassTest(/*String browser*/) throws IOException, URISyntaxException	{
		System.out.println("==launch the browser==");
		String browser = fLib.getDataFromPropertiesFile("browser");
		DesiredCapabilities dc = new DesiredCapabilities();
		
/*		URL url = new URL("http://192.168.26.1:4444"); [It's depricated]
		NOTE::
		java.net.URL is an ancient class, dating from Java 1. That class does not encode or decode any URL components according to the RFC 2396 escaping mechanism.
		java.net.URI class came later, in Java 4. */
		
		String url = "http://192.168.26.1:4444";
		driver = new RemoteWebDriver((new URI(url)).toURL(),dc);
		
		if(browser.equalsIgnoreCase("chrome")) {
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.WINDOWS);
//			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			dc.setBrowserName("edge");
			dc.setPlatform(Platform.WINDOWS);
//			driver=new EdgeDriver();
		}
		else {
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.WINDOWS);
//			driver=new ChromeDriver();
		}
		
		sdriver = driver;//staticDriver is temperory variable to use the driver object inside the Listener implementation class
		UtilityClassObject.setDriver(driver);
	
	}
	@Parameters (/*{"url", "username", "password"}*/)
	@BeforeMethod (/*groups = {"smoke test", "regression test"}*/)
	public void beforeMethodTest(/*String url, String username, String password*/) throws IOException	{
		System.out.println("==login to application==");
		String url = fLib.getDataFromPropertiesFile("url");
		String username = fLib.getDataFromPropertiesFile("username");
		String password = fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(url, username, password);
				
	}
	@AfterMethod (/*groups = {"smoke test", "regression test"}*/)
	public void afterMethodTest() throws InterruptedException {
		System.out.println("==logout of application==");
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.logOut();
	}
	
	@AfterClass (/*groups = {"smoke test", "regression test"}*/)
	public void afterClassTest() {
		System.out.println("==close the browser==");
		driver.quit();
	}
	
	@AfterSuite (/*groups = {"smoke test", "regression test"}*/)
	public void afterSuiteTest() throws SQLException {
		System.out.println("====close Databse, Report backup====");
		
//		dLib.closeConnection();
				
	}
	
	
}
