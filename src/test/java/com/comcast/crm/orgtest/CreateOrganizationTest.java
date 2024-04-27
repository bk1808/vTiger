package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
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
//		create an object of ExcelUtility class to read the data from excel file
		
		String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();;
			
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
		
		LoginPage lp=new LoginPage(driver);
//		lp.getUsernameEdt().sendKeys(un);
//		lp.getPasswordEdt().sendKeys(pwd);
//		lp.getLoginBtn().click();

		lp.loginToApp(url, un, pwd);
		
//		step-2: navigate to organization module 
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();		
		
//		step-3: click on create organization button
		OrganizationsPage onp=new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();		
		
//		step-4: enter all the details and create new organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
//		verify organization name
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgName=oip.getHeaderMsg().getText();
		
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+" is verified==PASS");
		}
		else {
			System.out.println(orgName+" is not verified==FAIL");
		}		
		
//		step-5: cick on logout
		
		hp.logOut();
		driver.quit();
		
	}

}
