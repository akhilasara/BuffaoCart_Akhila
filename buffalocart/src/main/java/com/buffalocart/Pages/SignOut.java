package com.buffalocart.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;

public class SignOut {
	public WebDriver driver;
    PageUtilities objPageUtilities;
    
    WaitUtilities waitutilities;
	@FindBy(xpath="//span[text()='Aju Mathew']")
	WebElement lnkprofile;
	@FindBy(xpath="//div[@class='pull-right']")
	WebElement btnSignout;
	
	public void clickProfile() {
		waitutilities.elementTobeClickable(driver, lnkprofile);	
		objPageUtilities.clickOnElement(lnkprofile);
		
	}
	
	public LoginPage clicksignout() {
				
        waitutilities.elementTobeClickable(driver, btnSignout);
        objPageUtilities.clickOnElement(btnSignout);
		return new LoginPage(driver);
	}
	public SignOut(WebDriver driver) {
		objPageUtilities=new PageUtilities();
		waitutilities =new WaitUtilities();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
}
