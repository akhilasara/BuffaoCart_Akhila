package com.buffalocart.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static final long EXPLICIT_WAIT = 50;
	
	public WebElement elementTobeClickable(WebDriver driver,WebElement elementclickable)
	{
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(elementclickable));
		return element;
	}
	
	public WebElement waitForElementTobeVisible(WebDriver driver,WebElement elementtobeloaded)
	{
		WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
		WebElement element=wait.until(ExpectedConditions.visibilityOf(elementtobeloaded));
		return element;
	}
	
	
		public static void waitForElementToBePresent(WebDriver driver, WebElement target,String value) {
			WebDriverWait wait = new WebDriverWait(driver, TimeUnit.SECONDS.toSeconds(EXPLICIT_WAIT));
			wait.until(ExpectedConditions.textToBePresentInElement(target, value));
	}
	

}
