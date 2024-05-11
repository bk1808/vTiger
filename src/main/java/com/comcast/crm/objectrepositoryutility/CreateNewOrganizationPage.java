package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{

	@FindBy (name = "accountname")
	private WebElement orgNameEdt;

	@FindBy (xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy (name = "industry")
	private WebElement industryDD;

	@FindBy (name = "accounttype")
	private WebElement typeDD;

	@FindBy (id = "phone")
	private WebElement phoneNumber;
	
	@FindBy (id = "dtlview_Phone")
	private WebElement actualPhNum;
	
	
	public CreateNewOrganizationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getPhoneNum() {
		return phoneNumber;
	}	

	public WebElement getActualPhNum() {
		return actualPhNum;
	}

	// we will use business method since there are two actions needs to be peroformed together	
	public void createOrg(String orgName) throws InterruptedException {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		Thread.sleep(3000);
	}

	public void createOrg(String orgName, String industry, String type, WebDriverUtility wLib) {
		orgNameEdt.sendKeys(orgName);
		getOptions(industryDD);
		select(industryDD, industry);
		select(typeDD, type);
		saveBtn.click();
	}

	public void createOrg(String orgName, String phoneNum) {
		orgNameEdt.sendKeys(orgName);
		phoneNumber.sendKeys(phoneNum);
		saveBtn.click();
	}
	
	public void traverseOrgToContact() {
	
		
		
	}

}
