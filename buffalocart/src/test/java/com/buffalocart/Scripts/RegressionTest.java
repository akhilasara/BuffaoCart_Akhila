package com.buffalocart.Scripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.ContactsPage;
import com.buffalocart.Pages.HomePage;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Utilities.ExcelUtilities;

public class RegressionTest extends BaseTest{
	WebDriver driver;
	LoginPage objLogin;
	 
	 HomePage objHome;
  
  @Test(dataProvider="validuservalidpass",priority=1)
  
  public void verifyvaliduservalidpass(String username ,String password) throws InterruptedException {
 	  objLogin=new LoginPage(driver);
 	  objLogin.setUserName(username);
 	  objLogin.setPassword(password);
 	   objLogin.clickLogin();
 	  
 	   Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE1);
  }
@Test(priority=3)
  
public void verifyUser() {
	HomePage obj = new HomePage(driver);
	obj.clickUserProfile();
	String username="Aju Mathew";
     SoftAssert sa= new SoftAssert();
     sa.assertEquals(Constants.usernamevalid1, username);
     sa.assertAll();
}
@Test(priority=2)
public void verifyendtour() {
	   objHome= new HomePage(driver);
	  objHome.clickapplicationtour();
}
@DataProvider
public Object[][]validuservalidpass() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "validuserValidpass");
	  return data;
}
}
