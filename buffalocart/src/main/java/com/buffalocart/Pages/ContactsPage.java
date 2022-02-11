package com.buffalocart.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;

public class ContactsPage {
	PageUtilities objPgUtilities;
	WaitUtilities waitutilities;
	public WebDriver driver;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement lnkContact;
	@FindBy(xpath="//a[text()=' Suppliers']")
	WebElement lnksuppliers;
	@FindBy(xpath="(//button[text()='Actions'])[1]")
	WebElement btnActions;
	@FindBy(xpath="(//a[text()=' Delete'])[1]")
	WebElement btndelete;
	@FindBy(xpath="//input[@type='search']")
	WebElement txtSearch;
	@FindBy(xpath="//a[text()=' Customers']")
	WebElement lnkCustomer;
	@FindBy(xpath="//input[@type='search']")
	WebElement txtCustSearch;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement btnCustAction;
	@FindBy(xpath="//a[text()=' View']")
	WebElement btnview;
	@FindBy(xpath="//input[@id='document']")
	WebElement btnupload;
	@FindBy(xpath="//button[text()='Save']")
	WebElement btnSave;
	@FindBy(xpath="//textarea[@name='note']")
	WebElement txtTextArea;
	@FindBy(xpath="//select[@name='contact_table_length']")
	WebElement drpentries;

public void clickContactPage() {
	objPgUtilities.clickOnElement(lnkContact);
	objPgUtilities.clickOnElement(lnksuppliers);
	objPgUtilities.ScrollBy(driver);
}
public boolean dropdownisDisplayed() {
	 objPgUtilities.isElementDisplayed(drpentries);
	 return true;
}

public void searchButton() throws InterruptedException {
	objPgUtilities.enterText(txtSearch, "anu");
	
	waitutilities.waitForElementTobeVisible(driver,txtSearch);
	
}
public boolean searchbtnisDisplayed() {
	objPgUtilities.isElementDisplayed(txtSearch);
	return true;
}

public void clickCustomer() {
	objPgUtilities.clickOnElement(lnkCustomer);
	
	
}
public void searchCust() throws InterruptedException {
	
	objPgUtilities.clearText(txtCustSearch);
	objPgUtilities.enterText(txtCustSearch, "jack");
	
	waitutilities.waitForElementTobeVisible(driver, txtCustSearch);
	}
public boolean txtSearchIsdisplayed() {
	objPgUtilities.isElementDisplayed(txtCustSearch);
	return true;
}
public String vSearchUser() {
	
	return objPgUtilities.getElementText(txtCustSearch);
	
}
public void clickcustAction() {
	objPgUtilities.clickOnElement(btnCustAction);
	waitutilities.elementTobeClickable(driver, btnActions);
	
}
public boolean isCustActionDisplayed() {
	objPgUtilities.isElementDisplayed(btnCustAction);
	return true;
}

public void clickView() {
	objPgUtilities.clickOnElement(btnview);
	waitutilities.elementTobeClickable(driver, btnview);
	
	}
public boolean isClickViewDisplayed() {
	objPgUtilities.isElementDisplayed(btnview);
	return true;
}

public ContactsPage(WebDriver driver) {
	 objPgUtilities= new PageUtilities();
	 waitutilities=new WaitUtilities();
this.driver=driver;
PageFactory.initElements(driver, this);

}
}

