package com.comcast.crm.objectrepositoryutility.pomutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


public class ProductsListPage extends WebDriverUtility {

	@FindBy (xpath = "//img[@alt='Create Product...']")
	private WebElement createProdImage;

	@FindBy (xpath = "//input[@class='txtBox']")
	private WebElement searchFieldEdt;

	@FindBy (xpath = "//input[@name='submit']")
	private WebElement searchNowBtn;

	WebDriver driver;
	public ProductsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateProdImage() {
		return createProdImage;
	}
		
	public WebElement getSearchFieldEdt() {
		return searchFieldEdt;
	}
	
	public WebElement getSearchNowBtn() {
		return createProdImage;
	}
	
}
