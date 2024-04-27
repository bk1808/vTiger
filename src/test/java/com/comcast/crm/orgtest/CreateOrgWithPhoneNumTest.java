package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgWithPhoneNumTest{

	public static void main(String[] args) throws IOException {
		//		create object of FileUtility for reading the data from commondata.properties and fetch the details
		FileUtility flib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		ExcelUtility eLib=new ExcelUtility();
		WebDriverUtility wLib=new WebDriverUtility();

		String browser = flib.getDataFromPropertiesFile("browser");
		String url = flib.getDataFromPropertiesFile("url");
		String un = flib.getDataFromPropertiesFile("username");
		String pwd = flib.getDataFromPropertiesFile("password");

		//		create the random number using Random Class of Java.util package
		//		read test script data from the excel file, as we shouldn't hardcode

		String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
		String phoneNum=eLib.getDataFromExcel("org", 7, 3)+jLib.getRandomNumber();
		
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);


		LoginPage lp=new LoginPage(driver);
		//		lp.getUsernameEdt().sendKeys(un);
		//		lp.getPasswordEdt().sendKeys(pwd);
		//		lp.getLoginBtn().click();

		lp.loginToApp(un, pwd);

		//		step-2: navigate to organization module 
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();	

		//		step-3: click on create organization button
		OrganizationsPage cnp=new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();		

		//		step-4: enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName, phoneNum);
		
		//		verify the drop-down industry and type info
		String actualPhoneNum = cnop.getActualPhNum().getText();
	
		if(actualPhoneNum.equals(phoneNum)) {
			System.out.println(phoneNum+" is created==PASS");
		}
		else {
			System.out.println(phoneNum+" is not created==FAIL");
		}
		//		step-7: cick on logout
		hp.logOut();		
		driver.quit();
	}

}
