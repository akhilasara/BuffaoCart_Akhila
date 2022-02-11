package com.buffalocart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;


public class ForgotPasswordPage {
	
	public WebDriver driver;
	PageUtilities objPageUtilities;
	WaitUtilities objWaitutilities;
	@FindBy(xpath="//input[@id='email']")
	WebElement txtemail;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnpassreset;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement errormsg;
		
	
	public void enterEmail(String emailAddress) {
		objPageUtilities.enterText(txtemail, emailAddress);
	}

	public void ClickOnSendPasswordResetLinkButton() {
		objPageUtilities.clickOnElement(btnpassreset);

	}

	public String getInvalidUserEmailMessage() throws InterruptedException {
		
		objWaitutilities.waitForElementTobeVisible(driver, errormsg);
		return objPageUtilities.getElementText(errormsg);
	}
	
		
	public ForgotPasswordPage(WebDriver driver) {
		objPageUtilities= new PageUtilities();
		objWaitutilities=new WaitUtilities();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


}
