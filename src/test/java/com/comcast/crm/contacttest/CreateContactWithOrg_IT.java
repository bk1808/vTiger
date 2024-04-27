package com.comcast.crm.contacttest;

import java.io.IOException;

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
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildPopupPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrg_IT {

	public static void main(String[] args) throws IOException, InterruptedException {
//		NOTE: Pre-condition - at-least one organization should be created
		
		/* Converting manual test case into test script for regression testing to check whether the contact is created along with organization or not
		Expted result: Contacts should be created along with organization and displayed in contact details page and verify the contact 
		*/

//		step-1: read the data from property file
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
				
		String browser = fLib.getDataFromPropertiesFile("browser");
		String url = fLib.getDataFromPropertiesFile("url");
		String un = fLib.getDataFromPropertiesFile("username");
		String pwd = fLib.getDataFromPropertiesFile("password");	
		
//		read test script data from the excel file, as we shouldn't hardcode
		
		String orgName=eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNumber();
		String lastName=eLib.getDataFromExcel("contact", 7, 3)+jLib.getRandomNumber();
		String orgIn = eLib.getDataFromExcel("org", 10, 3);
		
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
		driver.get(url);
		lp.loginToApp(un, pwd);
		
//		step-2: navigate to organization module 
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();		
		
//		step-3: click on create organization button
		OrganizationsPage onp=new OrganizationsPage(driver);
		onp.getCreateNewOrgBtn().click();		
		
//		step-4: enter all the details and create new organization
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createOrg(orgName);
	
//		step-5: navigate to contact module
		Thread.sleep(3000);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		oip.getContactsLink().click();
		
//		step-6: click on create contact button
		ContactsPage cnp=new ContactsPage(driver);
		cnp.getCreateNewContPage().click();

//`		step-7: enter all the details and create new contact
		CreateNewContactsPage cncp=new CreateNewContactsPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);
		
//		step-8: click on look-up window, select organization by searching 
		cncp.getClickOnLookup().click();
		
//		switch to child window
		
		wLib.switchToTabOnUrl(driver, "module=Accounts");
		
		OrganizationChildPopupPage opop=new OrganizationChildPopupPage(driver);
		opop.selectSearchDD(orgIn, orgName);
		
		
		
//		driver.findElement(By.id("search_txt")).sendKeys(orgName);
//		
//		driver.findElement(By.name("search")).click();
////		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();//this xpath is created dynamically during run-time so we need to take the same reference to verify

//		switch to parent window
		
		wLib.switchToTabOnUrl(driver, "Contacts&action");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//		verify the header message expected result 
		String headerMessg=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(headerMessg.contains(lastName)) {
			System.out.println(lastName+" is created===PASS");
		}
		else {
			System.out.println(lastName+" is not created==FAIL");
		}

//		verify the header orgName expected result 
		String actualOrgNameinfo=driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		if(actualOrgNameinfo.trim().equals(orgName)) {
			System.out.println(orgName+" is created===PASS");
		}else {
			System.out.println(orgName+" is not created===FAIL");
		}
		
//		step-6: cick on logout
		
		WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		wLib.mouseMoveOnElement(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}
