package practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SampleTestToTakeScreenshot {

	@Test
	public void amazonTakeScreenshotTest() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
//		step-1: create an object to event firing webdriver
		
//		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);[depricated ]
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./takesScreenshot/screenshot.png");
		
		FileUtils.copyFile(src, dest);
		
		
		
	}
	
}
