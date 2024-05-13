package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM class represents the web elements of Products List page on CRM application
 * 
 * @author Praveen
 * 
 *  13-May-2024
 */
public class ProductsListPage {

	@FindBy (xpath = "//img[@alt='Create Product...']")
	private WebElement ele1;
	
	@FindBy (xpath = "//input[@name='submit']")
	private WebElement ele3;

	public WebElement getCreateProdImage() {
		return ele1;
	}
		
	//step-2 commented by SAM
	
	public WebElement getSearchNowBtn() {
		return ele3;
	}

	public ProductsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
