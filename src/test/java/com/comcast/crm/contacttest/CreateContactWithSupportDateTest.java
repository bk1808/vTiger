package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {		
		//		step-1: read the data from property file
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");

		//		create the random number using Random Class of Java.util package
		//		read test script data from the excel file, as we shouldn't hardcode

		String lastName = eLib.getDataFromExcel("contact", 4, 3)+jLib.getRandomNumber();
		
		WebDriver driver=null;

		if(browser.equals("chrome")) {
			driver=new ChromeDriver();	
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();	
		}
		//		step-1: login to 
		wLib.waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		driver.get(url);
		lp.loginToApp(un, pwd);
		
		//		step-2: navigate to contacts module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//		step-3: click on create contacts button
		
		ContactsPage cnp=new ContactsPage(driver);
		cnp.getCreateNewContPage().click();
		
		//		step-4: enter all the details and create new organization
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);
		
		//		capture the system date from java.util package and change it as needed

		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getrequiredDateYYYYMMDD(30);

		cncp.getSuppStartDate().sendKeys(startDate);
		cncp.getSuppEndDate().sendKeys(endDate);

		//		step-5: save the contact
		
		cncp.getSaveBtn().click();

		//		verify the contact info with support start date and support end date

		String actualStartDate = cncp.getActSuppStartDate().getText();
		String actualEndDate = cncp.getActSuppEndDate().getText();
		
		if(actualStartDate.equals(startDate)) {
			System.out.println(startDate+" information is verified==PASS");
		}else {
			System.out.println(startDate+" information is not verified==FAIL");
		}

		if(actualEndDate.equals(endDate)) {
			System.out.println(endDate+" information is verified==PASS");
		}else {
			System.out.println(endDate+" information is not verified==FAIL");
		}

		//		step-6: cick on logout
		hp.logOut();
		driver.quit();
		
	}

}
