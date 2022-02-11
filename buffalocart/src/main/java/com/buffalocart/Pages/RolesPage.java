package com.buffalocart.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.Utilities.PageUtilities;

public class RolesPage {
	public WebDriver driver;
	PageUtilities objPageutilities;
	@FindBy(xpath="(//span[@class='title'])[3]")
	WebElement lnkRoles;
	@FindBy(xpath="//select[@class='form-control input-sm']")
	WebElement drpenRoleEntries;
	@FindBy(xpath="//input[@type='search']")
	WebElement txtSearch;
	@FindBy(xpath="//h3[text()='All roles']")
	WebElement txtRole;
	
	public void clickroles() {
		objPageutilities.clickOnElement(lnkRoles);
		
	}
	public String getTextRole() {
		return objPageutilities.getElementText(txtRole);
		
	}
	public void showEntries() {
		objPageutilities.dropdownTxt(driver, drpenRoleEntries, "50");
		

}
	public String vShowentry() {
		return objPageutilities.getElementText(drpenRoleEntries);
		
		
	}
	
	public void clickSearch() {
		objPageutilities.enterText(drpenRoleEntries, "admin");
		
	}
	public String vClickSearch() {
		return objPageutilities.getElementText(txtSearch);
		
	}
	public  RolesPage(WebDriver driver) {
		objPageutilities=new PageUtilities();
		
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
	}
}