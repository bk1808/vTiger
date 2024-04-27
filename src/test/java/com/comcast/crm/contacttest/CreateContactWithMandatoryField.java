package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithMandatoryField {

	public static void main(String[] args) throws IOException {
		/* TODO Converting manual test case into test script for regression testing to check whether the contact is created with mandatory fields or not
		Expted result: Contacts should be create and displayed in contact details page along with mandatory fileds 
		 */

		//		step-1: read the data from property file
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");

		//		create the random number using Random Class of Java.util package
		//		read test script data from the excel file, as we shouldn't hardcode
		
		String lastName = eLib.getDataFromExcel("contact", 1, 3)+jLib.getRandomNumber();
		
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
		//		step-1: login to application
		wLib.waitForPageToLoad(driver);
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(url, un, pwd);

		//		step-2: navigate to contacts module 
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();

		//		step-3: click on create contacts button
		
		ContactsPage cnp=new ContactsPage(driver);
		cnp.getCreateNewContPage().click();

		//		step-4: enter all the details and create new organization
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);

		//		step-5: save the contact
		
		cncp.getSaveBtn().click();
 
		//		verify the header and the contact info with last name mandatory field
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String actualLastName = cip.getActualLastName().getText();
		String actualContact = cip.getHeaderContact().getText();
		
		if(actualContact.contains(lastName)) {
			System.out.println(lastName+" is created in header==PASS");
		}
		else {
			System.out.println(lastName+" is not created in header==FAIL");
		}

		if(actualLastName.equals(lastName)) {
			System.out.println(lastName+" is created==PASS");
		}
		else {
			System.out.println(lastName+" is not created==FAIL");
		}
		//		step-6: cick on logout

		hp.logOut();
		driver.quit();

	}

}
