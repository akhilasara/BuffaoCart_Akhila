package com.buffalocart.Pages; 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;

public class HomePage {
	
	PageUtilities ObjpgUtilities;
	public WebDriver driver;
	
	WaitUtilities waitutility;
	
	@FindBy(xpath="//i[@class='fa fa-calculator fa-lg']")
	WebElement btnCalculator; 
	@FindBy(xpath="//h3[text()='Application Tour']")
	WebElement lnkapptour;
	@FindBy(xpath="//button[text()='End tour']")
	WebElement btnEndtour;
	@FindBy(xpath="//button[text()='Next »']")
	WebElement btnNext;
	@FindBy(xpath="(//span[@class='title'])[2]")
	WebElement lnkusers;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement lnkUsermngt;
	
	@FindBy(xpath="//select[@name='users_table_length']")
	WebElement drpsearch;
	@FindBy(xpath="//input[@type='search']")
	WebElement txtSearch;
	@FindBy(xpath="//li[@class='dropdown user user-menu open']")
	WebElement lnkusersprofile;
	@FindBy(xpath="//span[text()='Aju Mathew']")
	WebElement usernamevalid;
	@FindBy(xpath="//h3[@class='popover-title']")
	WebElement txtclacutitle;
	@FindBy(xpath="//a[@href='https://buffalocart.com/demo/billing/public/home']")
	WebElement lnkhome;
	
	public void clickUserProfile() {
		
		ObjpgUtilities.clickOnElement(lnkusersprofile);
		
		}
	public void clickCalculator() {
		ObjpgUtilities.clickOnElement(btnCalculator);
		
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	public String vCalculatorTitle() {
		
		return ObjpgUtilities.getElementText(txtclacutitle);
		
	}
	
	public void clickUsermangmt() {
		
		ObjpgUtilities.clickOnElement(lnkUsermngt);
		
	}
	public void clickapplicationtour() {
		
		ObjpgUtilities.clickOnElement(btnEndtour);
	}
	
	public void userClick() {
		ObjpgUtilities.clickOnElement(lnkusers);
		
		
		waitutility.waitForElementTobeVisible(driver, lnkusers);		
		
	}
	public void clickhome() {
		ObjpgUtilities.clickOnElement(lnkhome);
		waitutility.elementTobeClickable(driver, lnkhome);
	}
	
	public void showEntries() throws InterruptedException {
		
		waitutility.waitForElementTobeVisible(driver, drpsearch);
		ObjpgUtilities.dropdownTxt(driver, drpsearch, "25");
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	public String verifyShowEntries() {
		
		return ObjpgUtilities.getElementText(drpsearch);
	}
	
	public void searchUser() throws Exception {
		waitutility.waitForElementTobeVisible(driver, txtSearch);
		ObjpgUtilities.enterText(txtSearch, "akhila");
		ObjpgUtilities.threadWait();
		
	}
	public String isDisplayed() {
		return ObjpgUtilities.getElementText(drpsearch);
		
	}
	public String searchIsDiplayed() {
		return ObjpgUtilities.getElementText(txtSearch);
		
	}
	
	
		public HomePage(WebDriver driver) {
			 ObjpgUtilities = new PageUtilities();
			 waitutility =new WaitUtilities();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
