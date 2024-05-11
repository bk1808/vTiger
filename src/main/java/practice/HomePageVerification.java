package practice;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageVerification {

	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test==Starts");
		String expectedPage="Home page";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
//		if(actTitle.equals(expectedPage)) {
//			System.out.println("expected page is verified==PASS");
//		}
//		else {
//			System.out.println("expected page is not verified==FAIL");
//		}
//		Hard-Assert method:
		Assert.assertEquals(actTitle, expectedPage);
		
		driver.quit();
	}
	
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test==Starts");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
//		if(status==true) {
//			System.out.println("Logo is verified==PASS");
//		}
//		else {
//			System.out.println("Logo is not verified==FAIL");
//		}
//		Hard-Assert method:	
		Assert.assertTrue(status);
		
		driver.quit();
	}
	
	// Example of hard assert
	
	@Test
	public void homePageHardAssertTest(Method mtd) {
		
		System.out.println(mtd.getName()+" test start");
		System.out.println("Step-1");
		Assert.assertEquals("Home", "Home-P age");
		System.out.println("Step-2");
		System.out.println("Step-3");
		Assert.assertEquals("Home-CRM", "Home-CRM");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+" test end");
		
	}
	
	@Test
	public void verifyLogoHomePageHardAssertTest(Method mtd) {
		
		System.out.println(mtd.getName()+" test start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+" test end");
		
	}
	
//	Example of soft assert:
	
	@Test
	public void homePageSoftAssertTest(Method mtd) {
		
		System.out.println(mtd.getName()+" test start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("Step-1");
		Assert.assertEquals("Home", "Home-Page");
		System.out.println("Step-2");
		assertObj.assertEquals("Title", "Title-1");//actual, expected
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+" test end");
		assertObj.assertAll();//The compiler will connect the exception, assertAll method will print the exception in console. It'll fail the test case 
		
	}
	
	@Test
	public void verifyLogoHomePageSoftAssertTest(Method mtd) {
		
		System.out.println(mtd.getName()+" test start");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("Step-1");
		assertObj.assertTrue(true);
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(mtd.getName()+" test end");
		assertObj.assertAll();//It's mandatory to use this method whenever we use soft assert methods
		
	}
	
}
