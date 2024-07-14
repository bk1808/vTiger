package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactsPage extends WebDriverUtility {

	@FindBy (name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy (name = "support_start_date")
	private WebElement suppStartDate;
	
	@FindBy (name = "support_end_date")
	private WebElement suppEndDate;
	
	@FindBy (id = "dtlview_Support Start Date")
	private WebElement actSuppStartDate;
	
	@FindBy (id = "dtlview_Support End Date")
	private WebElement actSuppEndDate;
	
	@FindBy (xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement clickOnLookup;
	
	
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSuppStartDate() {
		return suppStartDate;
	}

	public WebElement getSuppEndDate() {
		return suppEndDate;
	}

	public WebElement getActSuppStartDate() {
		return actSuppStartDate;
	}

	public WebElement getActSuppEndDate() {
		return actSuppEndDate;
	}
	
	public WebElement getClickOnLookup() {
		return clickOnLookup;
	}

	
	
}
