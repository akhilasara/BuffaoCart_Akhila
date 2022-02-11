package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.HomePage;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Pages.SideBarPage;
import com.buffalocart.Pages.SignOut;
import com.buffalocart.Utilities.ExcelUtilities;

public class SidebarTest extends BaseTest {
	LoginPage objLogin;
	SignOut objsignout;
	
	
	
  @Test(priority=1)
  public void verifyUserMngmt() {
	  
	  HomePage objHome =new HomePage(driver);
	  objHome.clickhome();
	  SideBarPage obj= new SideBarPage(driver);
	 boolean actual= obj.verifyLinksUser();
	 Assert.assertEquals(actual, true);
	  
	   }
  @Test(priority=2)
  public void verifyContact() {
	  SideBarPage obj= new SideBarPage(driver);
	  String actual=obj.verifyLinkContact();
	  String expected=" Suppliers";
	  if(actual==" Suppliers"&&expected==" Suppliers") {
	  Assert.assertTrue(true);
	  }
	  
  }
  @Test(priority=3)
  public void verifyPdct() {
	  SideBarPage obj= new SideBarPage(driver);
	  String actual=obj.verifyLnkPdct();
	  String expected="List Products";
	  Assert.assertEquals(actual, expected);
	  objsignout.clicksignout();
	  
  }
}
