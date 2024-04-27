package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationChildPopupPage extends WebDriverUtility {

	@FindBy (id = "search_txt")
	private WebElement orgSearchEdt;
	
	@FindBy (name = "search")
	private WebElement orgSearchDD;
	
	@FindBy (name = "search_field")
	private WebElement selectEle;
	
	@FindBy (name = "search")
	private WebElement searchBtn;
	
	WebDriver driver;
	public OrganizationChildPopupPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectSearchDD(String value, String orgName) {
		select(selectEle, value);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	}
	
}
