package com.buffalocart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;

public class CustomerGroup {
	public WebDriver driver;
	PageUtilities pageutilities ;
	@FindBy(xpath=" //a[@href='https://buffalocart.com/demo/billing/public/customer-group']")
	WebElement lnkCustgp;
	@FindBy(xpath="//button[text()=' Add']")
	WebElement btnAdd;
	@FindBy(xpath="//input[@id='name']")
    WebElement txtcustgpName;
	@FindBy(xpath="//input[@id='amount']")
	WebElement txtamount;
	@FindBy(xpath="//button[text()='Save']")
	WebElement btnSave;
	@FindBy(xpath="//button[text()='Close']")
	WebElement btnClose;
	@FindBy(xpath="//button[@class='close']")
	WebElement btntopClose;
	@FindBy(xpath="//h3[text()='All Customer Groups']")
	WebElement txtcustgp;
	@FindBy(xpath="//h4[text()='Add Customer Group']")
	WebElement txtaddcustgp;
	
	public void custGpClick() {
		pageutilities.clickOnElement(lnkCustgp);
		
	}
	public String getCustgpText() {
		String actualtxt=txtcustgp.getText();
		return actualtxt;
	}
	public void add() {
		pageutilities.clickOnElement(btnAdd);
		
	}
	public String getAddCustgp() {
		String actualname=txtaddcustgp.getText();
		return actualname;
	}
	public void addCustGpName(String strGroupName) {
		pageutilities.clearText(txtcustgpName);
		
		
		txtcustgpName.sendKeys(strGroupName);
		
	}
	public void addCustGpCalculanPer(String strPercentage) {
		pageutilities.clearText(txtamount);
		
		txtamount.sendKeys(strPercentage);
	}
	public void clicksubmit() {
		pageutilities.clickOnElement(btnSave);
		
	}
	public void clickClose() {
		pageutilities.clickOnElement(btnClose);
		
	}
	public void clickTopClose() {
		pageutilities.clickOnElement(btntopClose);
		btntopClose.click();
	}
	public String getPercentagevalue(){
	return pageutilities.getElementText(txtamount);
		
		
	}
	public CustomerGroup(WebDriver driver) {
		pageutilities = new PageUtilities();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
