package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	/* RULES to create classes
	 Rule-1: create a seperate java classs
	 Rule-2: object creation
	 Rule-3: object initialization
	 Rule-4: object Encapsulation
	 Rule-5: we can provide action using business methods [loginToApp()]
	  */

	@FindBy (name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy (name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy (id = "submitButton")
	private WebElement loginBtn;
	
//	initialization should be done inside a constructor
	WebDriver driver;//declare driver object as global variable so this can be used across the class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
// 	single elements utilization using these element methods we can perform action
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
//	multiple elements utilization using this single method we can perform action
// this method is specific to business which cannot be used any other application
	public void loginToApp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}
