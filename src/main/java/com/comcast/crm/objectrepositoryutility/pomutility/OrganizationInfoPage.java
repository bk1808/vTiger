package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility{

	@FindBy (className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy (id = "dtlview_Industry")
	private WebElement industry;
	
	@FindBy (id = "dtlview_Type")
	private WebElement Indtype; 
	
	@FindAll({@FindBy (linkText = "Contacts"), @FindBy(xpath = "//a[@href=\"index.php?module=Contacts&action=index\"]")})
	private WebElement contactsLink;
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return Indtype;
	}

	public WebElement getContactsLink() {
		
		return contactsLink;
	}

	
}
