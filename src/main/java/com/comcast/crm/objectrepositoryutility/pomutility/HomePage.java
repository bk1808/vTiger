package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{

	
	@FindBy (linkText = "Products")
	private WebElement prodLink;
	
	@FindBy (linkText = "Organizations")
	private WebElement orgLink;

	@FindBy (linkText = "Contacts")
	private WebElement contactLink;

	@FindBy (linkText = "Campaigns")
	private WebElement campaignLink;

	@FindBy (linkText = "More")
	private WebElement moreLink;
	
	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutBtn;
	

	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	
	public WebElement getProdLink() {
		return prodLink;
	}

	/*	if required we provide a business library, it's not necessry for
	 * single actions like this!*/
	public void orgClick(WebDriver driver) {
		orgLink.click();
	}

	/*	if required we provide a business library, it's a need based and where you
	 * perform multiple actions on a web page and to combine all actions together
	 * and users can call this method to perform multiple actions in single method*/	

	public void navigateToCampaignPage(WebDriver driver) {
		mouseMoveOnElement(driver, moreLink);
		campaignLink.click();
	}
	
	public void logOut() {
		mouseMoveOnElement(driver, adminImg);
		signOutBtn.click();
	}
	
}
