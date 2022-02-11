package com.buffalocart.Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Pages.ProductPage;
import com.buffalocart.Pages.SignOut;
import com.buffalocart.Utilities.ExcelUtilities;

public class SanityTest extends BaseTest {
	WebDriver driver;
	ProductPage objpdctpg;
	LoginPage objlogin;
	 SignOut obj;
	
	 @Test(dataProvider="validuservalidpass",priority=1)
	  
	  public void verifyvaliduservalidpass(String username ,String password) throws InterruptedException {
		 objlogin=new LoginPage(driver);
		 objlogin.setUserName(username);
		 objlogin.setPassword(password);
		 objlogin.clickLogin();
	 	  
	 	   Assert.assertEquals(objlogin.getHomePageTitle(), Constants.HOMETITLE1);
	  }
  @Test(priority=4)
  public void verifyPdctLnk() {
	   objpdctpg=new ProductPage(driver);
	  objpdctpg.clickPdctLnk();
	  boolean check= objpdctpg.pdcttypeIsDisplayed();
	  Assert.assertTrue(check);
	  
  }
  @Test(priority=5)
  public void verifysignOut() {
	   obj=new SignOut(driver);
	   objlogin= new LoginPage(driver);
	   obj.clickProfile();
	  obj.clicksignout();
	  Assert.assertEquals(objlogin.getActualTitle(), Constants.expeclogintitle);
	  
	  
  }
  @DataProvider
  public Object[][]validuservalidpass() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "validuserValidpass");
	  return data;
  }
}
