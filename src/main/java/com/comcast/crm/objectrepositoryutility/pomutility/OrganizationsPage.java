package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{

	@FindBy (xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	@FindAll ({@FindBy(name = "search_text"),@FindBy(className = "txtBox")})
	private WebElement searchEdt;

	@FindBy (id = "bas_searchfield")
	private WebElement searchDD;

	@FindBy (name = "submit")
	private WebElement searchNowBtn;

	@FindBy (xpath = "//a[@title='Organizations']")
	private WebElement dynamicTxt;
	

	//	below are single element getter methods
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchOrgName() {
		return searchEdt;
	}

	public WebElement getSelectOrgAttribute() {
		return searchDD;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getDynamicTxt() {
		return dynamicTxt;
	}

//		Business logic/method to input dynamic data 
	public void dynamicData(String orgName) {
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
	}
}
