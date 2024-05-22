package com.comcast.crm.generic.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplementationClass.class)

public class BaseClass {
// create objects for utility classes and make them public to access across the test scripts
	public DataBaseUtility dLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;// declaring it globally to use across the class
	
	public static WebDriver staticDriver; /* The driver object has the browser session ID inside the @BeforeClass annotation method,
	and we cannot create an object inside the BaseClass since baseclass has configuration methods, they are just instructions to test methods
	and creating an object will not take any effect since @BeforeClass is a configuration annotation
	to use the local varibale outside the method inside Listener implementation class
	i have declared WebDriver as 'static' variable. But, static variables will not participate in parallel execution
	hence, i have created a seperate UtilityClassObject to create instances of static variables
	using ThreadLocal object. After making the 'driver' object as static, we need to pass the session id to 'sdriver'*/
	
	@BeforeSuite(groups = { "smoke test", "regression test" })
	public void beforeSuiteTest() throws SQLException {
		Reporter.log("====connect to Database, Report config====",true);
		//		dLib.getDBConnection();

	}

	// Parameters annotation from testNG, whenever we pass the parameter from testNG.xml file we use this annotation 
	@Parameters(/* "Browser" */)
	@BeforeClass(groups = { "smoke test", "regression test" })
	public void beforeClassTest(/* String browser */) throws IOException {
		Reporter.log("==launch the browser==",true);
		/*String Browser = browser;*/
		String browser = fLib.getDataFromMavenCMD("browser", fLib.getDataFromPropertiesFile("browser"));

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		staticDriver = driver;// staticDriver is temperory variable to use the driver object inside the
								// Listener implementation class
		UtilityClassObject.setDriver(driver);

	}

	@Parameters(/* {"url", "username", "password"} */)
	@BeforeMethod(groups = { "smoke test", "regression test" })
	public void beforeMethodTest(/* String url, String username, String password */) throws IOException {
		Reporter.log("==login to application==",true);
		String url = fLib.getDataFromMavenCMD("url", fLib.getDataFromPropertiesFile("url"));
		String username = fLib.getDataFromMavenCMD("username", fLib.getDataFromPropertiesFile("username"));
		String password = fLib.getDataFromMavenCMD("password", fLib.getDataFromPropertiesFile("password"));

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);

	}

	@AfterMethod(groups = { "smoke test", "regression test" })
	public void afterMethodTest() throws InterruptedException {
		Reporter.log("==logout of application==",true);
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.logOut();
	}

	@AfterClass(groups = { "smoke test", "regression test" })
	public void afterClassTest() {
		Reporter.log("==close the browser==",true);
		driver.quit();
	}

	@AfterSuite(groups = { "smoke test", "regression test" })
	public void afterSuiteTest() throws SQLException {
		Reporter.log("====close Databse, Report backup====",true);
//		dLib.closeConnection();

	}

}
