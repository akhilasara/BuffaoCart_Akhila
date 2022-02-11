package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Pages.SignOut;

public class SignOutTest extends BaseTest {
	LoginPage objlogin;
	
		
  @Test(priority=1)
  public void verifysignOut() {
	  SignOut obj=new SignOut(driver);
	   objlogin= new LoginPage(driver);
	   obj.clickProfile();
	  obj.clicksignout();
	  Assert.assertEquals(objlogin.getActualTitle(), Constants.expeclogintitle);
	  
	  
  }
}
