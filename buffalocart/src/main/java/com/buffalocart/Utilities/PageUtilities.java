package com.buffalocart.Utilities;

import java.util.concurrent.TimeUnit;
 import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PageUtilities {
	
	
	public  void clickOnElement(WebElement element) {
		element.click();
	}

	public  void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public  String getElementText(WebElement element) {
		return element.getText();

	}
	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}


	public  void clearText(WebElement element) {
		element.clear();
	}

	
	public void handleAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public  void threadWait() throws InterruptedException {
		Thread.sleep(2000);
	}
	public  Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public  Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public  Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public void hitEnter(WebDriver driver,WebElement element)
	{
		element.sendKeys(Keys.ENTER);
	}
	public void sendTestusingMouseAction(WebDriver driver,WebElement element ,String text)
	{
		Actions action= new Actions(driver);
		action.sendKeys(element, text).build().perform();
	}
	public static  void moveToWebElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();

	}

	public void doubleClickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void rightClickOnElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	public static void ScrollBy(WebDriver driver) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript("window.scrollBy(0,1000)"); 
	}
	public void pageScrollelement(WebDriver driver, WebElement element) {
		
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
	
	public WebElement dropdownTxt(WebDriver driver,WebElement element,String text ) {
		Select drpelement=new Select(element);
		drpelement.selectByVisibleText(text);
		return element;
	}
	public WebElement dropdownIndex(WebDriver driver,WebElement element,int index ) {
		Select drpelement=new Select(element);
		drpelement.selectByIndex(index);
		return element;
	}
	
}
	