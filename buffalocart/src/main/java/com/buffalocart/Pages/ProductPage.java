package com.buffalocart.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;

public class ProductPage {
	PageUtilities objPageUtilities;
	WaitUtilities objwaitutilities;
	public WebDriver driver;
@FindBy(xpath="//span[text()='Products']")
WebElement lnkpdct;
@FindBy(xpath="//a[text()='List Products']")
WebElement lnkAddList;
@FindBy(xpath="//a[text()=' Stock Report']")
WebElement lnkstckrpt;
@FindBy(xpath="(//a[text()='2'])[2]")
WebElement btntwo;
@FindBy(xpath="(//input[@type='search'])[2]")
WebElement txtSearch;
@FindBy(xpath="//select[@id='product_list_filter_type']")
WebElement drpPdctType;
@FindBy(xpath="//select[@id='product_list_filter_category_id']")
WebElement drpCategory;
@FindBy(xpath="//select[@id='product_list_filter_unit_id']")
WebElement drpUnit;
@FindBy(xpath="//select[@id='product_list_filter_tax_id']")
WebElement drptax;
@FindBy(xpath="//select[@id='product_list_filter_brand_id']")
WebElement drpBrand;
@FindBy(xpath="//option[text()='VKC']")
WebElement brandtxt;
@FindBy(xpath="//table[@id='stock_report_table']")
WebElement stcktable;

public void clickPdctLnk() {
	objPageUtilities.clickOnElement(lnkpdct);
	objPageUtilities.ScrollBy(driver);
	objPageUtilities.clickOnElement(lnkAddList);
	
}
public boolean pdcttypeIsDisplayed() {
	objPageUtilities.isElementDisplayed(drpPdctType);
	return true;
}
public void clickStockRpt() {
	
	objPageUtilities.clickOnElement(lnkstckrpt);
}
public boolean stcktableIsdisplayed() {
	objPageUtilities.isElementDisplayed(stcktable);
	return true;
}
public void clickBtnTwo() {
	
	objPageUtilities.clickOnElement(btntwo);
}
public boolean clickBtnTwoIsDisplayed() {
	objPageUtilities.isElementSelected(btntwo);
	return true;
}

public void verifySearch() throws InterruptedException {
	
	objPageUtilities.enterText(txtSearch, "pen");

	objwaitutilities.waitForElementTobeVisible(driver, txtSearch);
		
}
public String vSearch() {
	return objPageUtilities.getElementText(txtSearch);
	
	
}
public void drpFilters() throws InterruptedException {
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	
	objPageUtilities.dropdownTxt(driver, drpPdctType, "Single"); 
	objPageUtilities.dropdownTxt(driver, drpCategory, "Groceries");
	objPageUtilities.dropdownTxt(driver, drpUnit, "Box");
	objPageUtilities.dropdownTxt(driver, drptax, "Tax1");
	objPageUtilities.dropdownTxt(driver, drpBrand, "VKC");
	
}
public String vFilters() {
	return objPageUtilities.getElementText(brandtxt);
	
}
public  ProductPage(WebDriver driver) 
	
{
	objPageUtilities= new PageUtilities();
	objwaitutilities= new WaitUtilities();
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

}