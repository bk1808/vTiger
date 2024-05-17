package practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {

	@Test (dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
//		search product on amazon
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox' and @name='field-keywords']")).sendKeys(brandName, Keys.ENTER);
		
//		capture the price of the product using dynamic Xpath get the data from data provider annotation
		String x="(//span[text()='"+productName+"'])[1]/../../../../div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]";
		String price=driver.findElement(By.xpath(x)).getText();
		Reporter.log(price, true);
		driver.quit();
				
	}

//	make use of data provider and provide the brand name and product name to above program
	
/*	@DataProvider
	public Object [][] getData() {
		
		Object [] [] objArray=new Object [3] [2];
		objArray [0][0]="iphone";
		objArray [0][1]="Apple iPhone 13 (128GB) - Green";
		
		objArray [1][0]="iphone";
		objArray [1][1]="Apple iPhone 15 (128 GB) - Blue";
		
		objArray [2][0]="iphone";
		objArray [2][1]="Apple iPhone 15 (128 GB) - Black";
		
		return objArray;
	}*/
	
//	We can retrieve the above data from excel - check this path
// NOTE: within thr for loops do not try to change the conditions not the initialization, it should start from '0' only 
	@DataProvider
	public Object [][] getData() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		int cellCount = eLib.getCellCount("product",0);
		
		Object [] [] objArray=new Object [rowCount] [cellCount];//rowCount=No. of rows value is present in the sheet, cellCount=No. of cells the value is present in sheet
		
		for(int i=0 ; i<rowCount; i++) {
			for(int j=0 ; j<cellCount ; j++) {
		objArray [i][j]=eLib.getDataFromExcel("product", i+1, j);//+1 for i & J is to ignore the first row and first cell as i am trying to fetch the data from next row and columns
		objArray [i][j]=eLib.getDataFromExcel("product", i+1, j);
		System.out.println("==");
		}
		}
		return objArray;
		
	}
	
}
