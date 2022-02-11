package com.buffalocart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.WaitUtilities;

public class SideBarPage {
	public WebDriver driver;
	PageUtilities objpageutilities;
	WaitUtilities objwaitutilities;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']/li/a/i/following-sibling::span[1]")
	WebElement sidebar;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement lnkusermngmt;
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement lnkContact;
	@FindBy(xpath="//span[text()='Products']")
	WebElement lnkpdts;
	@FindBy(xpath="(//span[@class='title'])[2]")
	WebElement lnkusers;
	@FindBy(xpath="//a[text()=' Suppliers']")
	WebElement lnksuppliers;
	@FindBy(xpath="//a[text()='List Products']")
	WebElement lnkListPdct;
	
		public boolean verifyLinksUser() {
		objpageutilities.moveToWebElement(lnkusermngmt, driver);
		objwaitutilities.elementTobeClickable(driver, lnkusermngmt);
		boolean actualuser=objpageutilities.isElementEnabled(lnkusers);
		objwaitutilities.waitForElementTobeVisible(driver, lnkusers);
		
		return actualuser;
	}
	public String verifyLinkContact() {
		objpageutilities.moveToWebElement(lnkContact, driver);
		objwaitutilities.elementTobeClickable(driver, lnkContact);
		String actualcontact= objpageutilities.getElementText(lnksuppliers);
		objwaitutilities.waitForElementTobeVisible(driver, lnksuppliers);
		return actualcontact;
		
	}
	public String verifyLnkPdct() {
		objpageutilities.moveToWebElement(lnkpdts, driver);
		objwaitutilities.elementTobeClickable(driver, lnkpdts);
		String actualpdct= objpageutilities.getElementText(lnkListPdct);
		objwaitutilities.waitForElementTobeVisible(driver, lnkListPdct);
		return actualpdct;
		
	}
	
	
public SideBarPage(WebDriver driver) {
	objpageutilities=new PageUtilities();
	objwaitutilities=new WaitUtilities();
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
}
