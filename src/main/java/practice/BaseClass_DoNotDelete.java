//package practice;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.beust.jcommander.Parameter;
//import com.comcast.crm.generic.databaseutility.DataBaseUtility;
//import com.comcast.crm.generic.fileutility.ExcelUtility;
//import com.comcast.crm.generic.fileutility.FileUtility;
//import com.comcast.crm.generic.webdriverutility.JavaUtility;
//import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
//import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
//import com.comcast.crm.objectrepositoryutility.HomePage;
//import com.comcast.crm.objectrepositoryutility.LoginPage;
//
//import lombok.experimental.UtilityClass;
//
//public class BaseClass_DoNotDelete {
//// create objects for utility classes and make them public to access across the test scripts
//	public DataBaseUtility dLib=new DataBaseUtility();
//	public FileUtility fLib=new FileUtility();
//	public JavaUtility jLib=new JavaUtility();
//	public ExcelUtility eLib=new ExcelUtility();
//	public WebDriverUtility wLib=new WebDriverUtility();
//	public WebDriver driver;//declaring it globally to use across the class
//	public static WebDriver staticDriver;//to use the local varibale outside the test method
//	
//	@BeforeSuite (groups = {"smoke test", "regression test"})
//	public void beforeSuiteTest() throws SQLException	{
//		System.out.println("====connect to Database, Report config====");
////		dLib.getDBConnection();
//		
//	}
//	//Parameters annotation from testNG
//	@Parameters (/*"Browser"*/)
//	@BeforeClass (groups = {"smoke test", "regression test"})
//	public void beforeClassTest(/*String browser*/) throws IOException	{
//		System.out.println("==launch the browser==");
//
////		String browser = fLib.getDataFromPropMvnCMDXML("browser", "browser", "browser");
//		
//		//		Mvn command
////		String browser = fLib.getDataFromMavenCMD("browser", fLib.getDataFromPropertiesFile("browser"));
//		
//		String browser = fLib.getDataFromPropertiesFile("browser"); //browser; 
//		
//		if(browser.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(browser.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		else if(browser.equals("edge")) {
//			driver=new EdgeDriver();
//		}
//		else {
//			driver=new ChromeDriver();
//		}
//		staticDriver = driver;//staticDriver is temperory variable to use the driver object inside the Listener implementation class
//		UtilityClassObject.setDriver(driver);
//	
//	}
//	@Parameters (/*{"url", "username", "password"}*/)
//	@BeforeMethod (groups = {"smoke test", "regression test"})
//	public void beforeMethodTest(/*String url, String username, String password*/) throws IOException	{
//		System.out.println("==login to application==");
//		
//		String url = fLib.getDataFromPropMvnCMDXML("url", "url", "url");
//		String username = fLib.getDataFromPropMvnCMDXML("username", "username", "username");
//		String password = fLib.getDataFromPropMvnCMDXML("password", "password", "password");
//		
////		String url = fLib.getDataFromMavenCMD("url", fLib.getDataFromPropertiesFile("url"));
////		String username = fLib.getDataFromMavenCMD("username", fLib.getDataFromPropertiesFile("username"));
////		String password = fLib.getDataFromMavenCMD("password", fLib.getDataFromPropertiesFile("password"));
////		
////		String url = fLib.getDataFromPropertiesFile("url");
////		String username = fLib.getDataFromPropertiesFile("username");
////		String password = fLib.getDataFromPropertiesFile("password");
//		LoginPage lp=new LoginPage(driver);
//		lp.loginToApp(url, username, password);
//				
//	}
//	@AfterMethod (groups = {"smoke test", "regression test"})
//	public void afterMethodTest() throws InterruptedException {
//		System.out.println("==logout of application==");
//		HomePage hp=new HomePage(driver);
//		Thread.sleep(3000);
//		hp.logOut();
//	}
//	
//	@AfterClass (groups = {"smoke test", "regression test"})
//	public void afterClassTest() {
//		System.out.println("==close the browser==");
//		driver.quit();
//	}
//	
//	@AfterSuite (groups = {"smoke test", "regression test"})
//	public void afterSuiteTest() throws SQLException {
//		System.out.println("====close Databse, Report backup====");
//		
////		dLib.closeConnection();
//				
//	}
//	
//	
//}
