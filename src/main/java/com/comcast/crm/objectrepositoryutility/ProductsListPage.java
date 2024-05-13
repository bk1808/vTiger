package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsListPage {

	@FindBy (xpath = "//img[@alt='Create Product...']")
	private WebElement ele1;
	

	@FindBy (xpath = "//input[@class='txtBox']")
	private WebElement ele2;

	@FindBy (xpath = "//input[@name='submit']")
	private WebElement ele3;


	public WebElement getCreateProdImage() {
		return ele1;
	}
		
	public WebElement getSearchFieldEdt() {
		return ele2;
	}
	
	public WebElement getSearchNowBtn() {
		return ele3;

	}

	public ProductsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
