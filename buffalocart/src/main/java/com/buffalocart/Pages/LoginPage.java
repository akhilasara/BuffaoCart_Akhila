package com.buffalocart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;

public class LoginPage {
	PageUtilities objPageUtilities;
	public WebDriver driver;
	@FindBy(xpath="//input[@id='username']")
	WebElement txtusername;
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpassword;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnsubmit;
	@FindBy(xpath="//div[@class='checkbox']")
	WebElement lnkrememberme;
	@FindBy(xpath="//h1[text()='Demo POS']")
	WebElement lactualtitle;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement lnkForgotpass;
	@FindBy(xpath="//span[@class='help-block']")
	WebElement invalidLoginMessage;
	
	public LoginPage(WebDriver driver)
	{
		objPageUtilities= new PageUtilities();
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setUserName(String strUserName) throws InterruptedException {
		objPageUtilities.clearText(txtusername);
		
		txtusername.sendKeys(strUserName);
		
		
	}
	public String getActualTitle() {
		
		return objPageUtilities.getElementText(lactualtitle);
	}

	public void setPassword(String strPassword)
	{
		objPageUtilities.clearText(txtpassword);
		
		txtpassword.sendKeys(strPassword);
		
		
	}

	public void clickLogin()
	{
		objPageUtilities.clickOnElement(btnsubmit);
		
	}
	public void clickRememberme()
	{
		objPageUtilities.clickOnElement(lnkrememberme);
		
	}
	public ForgotPasswordPage clickOnForgotPasswordLink() {
		objPageUtilities.clickOnElement(lnkForgotpass);
		return new ForgotPasswordPage(driver);
	}
	public String getHomePageTitle()
	{
		String title=driver.getTitle();
		return title;
		
	}
	
	public String getInvalidLoginMessage() {
		return objPageUtilities.getElementText(invalidLoginMessage);
	}
	public  boolean getRememberme() {
		
		lnkrememberme.isSelected();
		return true;
	}

}
