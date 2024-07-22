package com.comcast.crm.generic.webdriverutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 *
 * This class consists of methods common for all web actions, these are reusable
 * methods
 * 
 * 16-May-2024
 */
public class WebDriverUtility {

	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	public void fullScreenWindow(WebDriver driver) {

		driver.manage().window().fullscreen();
	}

	public void openNewTab(WebDriver driver) {

		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void openNewWindow(WebDriver driver) {

		driver.switchTo().newWindow(WindowType.WINDOW);
	}

	public void deleteAllCookies(WebDriver driver) {

		driver.manage().deleteAllCookies();
	}

	public void navigateBack(WebDriver driver) {

		driver.navigate().back();
	}

	public void navigateForward(WebDriver driver) {

		driver.navigate().forward();
	}

	public void navigateRefresh(WebDriver driver) {

		driver.navigate().refresh();
	}

	public void activeElementEnter(WebDriver driver) {

		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	}

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void getURL(WebDriver driver, String url) {

		driver.get(url);
	}

	public void navigateToURL(WebDriver driver, String url) {

		driver.navigate().to(url);

	}

	public void getColorOfElement(WebDriver driver, WebElement ele, String attribute) {

		ele.getCssValue(attribute);
	}

	/*
	 * This method can be used to switch bw tabs or windows based on the partial
	 * text present in the URL
	 */
	public void switchToTabOnUrl(WebDriver driver, String partialURL) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			String windowID = i.next();

			driver.switchTo().window(windowID);

			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}

	}

	/*
	 * This method can be used to switch bw tabs or windows based on the partial
	 * title present in the tab or window
	 */
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {

		Set<String> set = driver.getWindowHandles();
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			String windowID = i.next();
			driver.switchTo().window(windowID);

			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {

		driver.switchTo().frame(nameID);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);
	}

	public void switchToParentFrame(WebDriver driver) {

		driver.switchTo().parentFrame();

	}

	public void switchToDefaultParentFrame(WebDriver driver) {

		driver.switchTo().defaultContent();

	}

	/*
	 * This method is useful to handle both dynamic and static dropdowns, and can be
	 * used for values also
	 */
	public void select(WebElement element, String text) {

		Select sel = new Select(element);

		sel.selectByVisibleText(text);
	}

	public void select(WebElement element, int index) {

		Select sel = new Select(element);

		sel.selectByIndex(index);
	}

	public void getAllSelectedOptions(WebElement element) {

		Select sel = new Select(element);
		List<WebElement> allSelected = sel.getAllSelectedOptions();

		Iterator<WebElement> i = allSelected.iterator();
		while (i.hasNext()) {
			String selected = i.next().getText();
			Reporter.log(selected, true);
		}

	}

	/* This method is used to select all the options and print on the report */
	public void getOptions(WebElement element) {

		Select sel = new Select(element);
		List<WebElement> allOptions = sel.getOptions();
		int count = allOptions.size();
		for (int i = 0; i < count; i++) {

			String option = allOptions.get(i).getText();
			Reporter.log(option, true);

		}

	}

	public void mouseMoveOnElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);

		act.moveToElement(element).perform();
	}

	public void dragAndDropElement(WebDriver driver, WebElement src, WebElement destination) {

		Actions act = new Actions(driver);

		act.dragAndDrop(src, destination);

	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);

		act.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);

		act.contextClick(element).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);

		act.scrollToElement(element).perform();
	}

	public void scrollByAmount(WebDriver driver, int xAxis, int yAxis) {

		Actions act = new Actions(driver);

		act.scrollByAmount(xAxis, yAxis).perform();
	}
	/*This method can be used to scroll to specific position from the origin*/
	public void scrollFromOrigin(WebDriver driver, WheelInput.ScrollOrigin origin, int xAxis, int yAxis) {

		Actions act = new Actions(driver);

		act.scrollFromOrigin(origin, xAxis, yAxis);
	}
	/*This method can be used to scroll to specific position*/
	public void scrollFromOriginToDestination(WebDriver driver, int xAxis, int yAxis) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(" + xAxis + ", " + yAxis + ")", "");

	}

	public void scrollToPosition(WebDriver driver, int xAxis, int yAxis) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(" + xAxis + ", " + yAxis + "");

	}

	public void scrollToHeight(WebDriver driver, int xAxis) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(" + xAxis + ", document.body.scrollHeight)");

	}

	public void switchToAlertAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	public void switchToAlertCancel(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertGetText(WebDriver driver) {

		driver.switchTo().alert().getText();

	}

	public void disableNotificationPopUp(WebDriver driver) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--diable-notifications");
		new ChromeDriver(option);

	}

	public void openWindowIncognito(WebDriver driver) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		new ChromeDriver(option);
	}

	public void startWindowMaxmized(WebDriver driver) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		new ChromeDriver(option);

	}

	public void startHeadlessExectuion(WebDriver driver) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		new ChromeDriver(option);

	}

	public void fileUploadPopUp(WebElement ele, String path) {
		File f = new File(path);
		String absPath = f.getAbsolutePath();
		ele.sendKeys(absPath);

	}

	public void authenticationPopUp(WebDriver driver, String path) {

		driver.get(path);
	}

	public void handlingPrintPopUp() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyPress(KeyEvent.VK_V);

	}

	public void addValueToDiabledElements(WebDriver driver, String value) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('d2').value='" + value + "'");

	}

	public void deleteValueFromDiabledElements(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('d2').value=''");

	}

	public void clickOnDiabledElements(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('d2').click();");

	}

}
