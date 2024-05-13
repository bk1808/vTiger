package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsListPage {

		   
	    //Yashoda
		@FindBy (id ="bas_searchfield")
		private WebElement ele2;

		public WebElement getEle2() {
			return ele2;
		
	}
	
}
