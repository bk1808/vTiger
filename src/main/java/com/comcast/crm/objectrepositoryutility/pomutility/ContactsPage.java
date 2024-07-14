package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	@FindBy (xpath = "//img[@alt='Create Contact...']")
	private WebElement createNewContPage;
	
	public WebElement getCreateNewContPage() {
		return createNewContPage;
	}

	public ContactsPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
