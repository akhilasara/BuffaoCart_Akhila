package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Utilities.ExcelUtilities;
import com.buffalocart.Utilities.PageUtilities;

public class LoginTest extends BaseTest {
	LoginPage objLogin;
	PageUtilities objPageUtilities;
  @Test(dataProvider="validuserinvalidpass",priority=1)
		  
  public void verifyvaliduserinvalidpass(String username ,String password) throws InterruptedException {
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(username);
	  objLogin.setPassword(password);
	   objLogin.clickLogin();
	  
	  Assert.assertEquals(objLogin.getInvalidLoginMessage(), Constants.InvalidLoginMessage);
  }
  @Test(dataProvider="invaliduservalidpass", groups={"sanity"},priority=2)
  
  public void verifyinvaliduservalidpass(String username ,String password) throws InterruptedException {
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(username);
	  objLogin.setPassword(password);
	   objLogin.clickLogin();
	  Assert.assertEquals(objLogin.getInvalidLoginMessage(), Constants.InvalidLoginMessage);
  }
    
 @Test(dataProvider="invaliduserinvalidpass",priority=3)
  
  public void verifyinvaliduserinvalidpass(String username ,String password) throws InterruptedException {
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(username);
	  objLogin.setPassword(password);
	   objLogin.clickLogin();
	  Assert.assertEquals(objLogin.getInvalidLoginMessage(), Constants.InvalidLoginMessage);
  }
 @Test(dataProvider="validuservalidpass",priority=5)
 
 public void verifyvaliduservalidpass(String username ,String password) throws InterruptedException {
	  objLogin=new LoginPage(driver);
	  objLogin.setUserName(username);
	  objLogin.setPassword(password);
	   objLogin.clickLogin();
	  
	   Assert.assertEquals(objLogin.getHomePageTitle(), Constants.HOMETITLE1);
 }
 
	  @DataProvider
	  public Object[][]validuserinvalidpass() throws Exception{
		  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "validuserInvalidpass");
		  return data;
	  }
  @DataProvider
  public Object[][]invaliduservalidpass() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "InvaliduserValidpass");
	  return data;
  }
  @DataProvider
  public Object[][]invaliduserinvalidpass() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "InvaliduserInvalidpass");
	  return data;
  }
  @DataProvider
  public Object[][]validuservalidpass() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "validuserValidpass");
	  return data;
  }
  @Test(priority=4)
  public void clickRemember() {
	  objLogin=new LoginPage(driver);
	  objLogin.clickRememberme();
	  Assert.assertEquals(objLogin.getRememberme(), true);
  }
 
  
}
