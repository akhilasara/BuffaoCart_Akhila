package com.buffalocart.Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.buffalocart.Utilities.PageUtilities;
import com.buffalocart.Utilities.RobotClassUtility;
import com.buffalocart.Utilities.WaitUtilities;

public class UserManagementPage {
	PageUtilities objpageutilities;
	public WebDriver driver;
	RobotClassUtility objrobot;
	WaitUtilities objwaitutility;
	
	@FindBy(xpath="(//span[@class='title'])[2]")
	WebElement lnkusers;
	@FindBy(xpath="(//span[@class='title'])[4]")
	WebElement lnksalescommisionagent;
	@FindBy(xpath="//a[text()=' Add']")
	WebElement btnadd;
	@FindBy(xpath="//input[@id='surname']")
	WebElement txtsurname;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtFirstname;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement txtLastname;
	@FindBy(xpath="//input[@id='email']")
	WebElement txtemail;
	@FindBy(xpath="//select[@id='role']")
	WebElement drproles;
	@FindBy(xpath="//input[@id='password']")
	WebElement txtpass;
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement txtconfpass;
	@FindBy(xpath="//input[@id='cmmsn_percent']")
	WebElement txtcommpercent;
	@FindBy(xpath="//input[@id='selected_contacts']")
	WebElement chkselectedcontacts;
	@FindBy(xpath="//ul[@class='select2-selection__rendered']")
	WebElement txtselectcontact;
	@FindBy(xpath="//input[@value='active']")
	WebElement chkisactive;
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement btnSave;
	@FindBy(xpath ="//h3[text()='All users']")
	WebElement txtuser;
	@FindBy(xpath="//h1[text()='Add user']")
	WebElement txtadduser;
	
	public void clickadd() {
		objpageutilities.clickOnElement(btnadd);
			}
	public String getUser() {
		
		String actualtxt=txtuser.getText();
		return actualtxt;
	}
	public String getAddUser() {
		String actualtext=txtadduser.getText();
		return actualtext;
	}
	
	public void setsurname(String strsurname) {
		txtsurname.sendKeys(strsurname);
	}
	public void setfirstname(String strfirstname) {
		txtFirstname.sendKeys(strfirstname);
		
	}
	public void setlastname(String strlastname) {
		txtLastname.sendKeys(strlastname);
	}
	public void setemail(String stremail) {
		txtemail.sendKeys(stremail);
	}
	public void setdroprole(String drprole) {
		objpageutilities.dropdownIndex(driver, drproles, 1);
		
		
	}
	public void setpass(String strpass) {
		txtpass.sendKeys(strpass);
	}
	public void setconfpass(String strconfpass) {
		txtconfpass.sendKeys(strconfpass);
	}
	public void setcommpercent(String strcommper) {
		txtcommpercent.sendKeys(strcommper);
	}
	public void setchkselectedcontacts(String strchkselectcontact) {
		objpageutilities.clickOnElement(chkselectedcontacts);
		
	}
	public void setselectedContacts(String strSelectedContacts ) {
		txtselectcontact.sendKeys(strSelectedContacts);
	}
	 public void setchkisactive(String strchkisactive) {
		 objpageutilities.clickOnElement(chkisactive);
		 
	 }
	 public void setSave() throws AWTException {
		 objrobot.keyEnter();
		 objwaitutility.elementTobeClickable(driver, btnSave);
		 
	 }
	
public UserManagementPage(WebDriver driver) {
	
	objpageutilities=new PageUtilities();
	objrobot= new RobotClassUtility();
	objwaitutility= new WaitUtilities();
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
