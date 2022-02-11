package com.buffalocart.Scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.ForgotPasswordPage;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Utilities.ExcelUtilities;

public class ForgotPasswordTest extends BaseTest {
	
	LoginPage objLogin;
	@Test(dataProvider="invaliduservalidpass" ,priority = 1, enabled = true)
	public void verifyResetPasswordWithInvalidEmailid(String email ) throws IOException, InterruptedException {
		ForgotPasswordPage objforgortpassword=new ForgotPasswordPage(driver);
		objLogin = new LoginPage(driver);
		objforgortpassword = objLogin.clickOnForgotPasswordLink();
		objforgortpassword.enterEmail(email);
		objforgortpassword.ClickOnSendPasswordResetLinkButton();
		String actualMessage = objforgortpassword.getInvalidUserEmailMessage();
		String expectedMessage = "We can't find a user with that e-mail address.";
		Assert.assertEquals(actualMessage, expectedMessage, "user email not registered");
	}
	
	
	
	@DataProvider
	  public Object[][]invaliduservalidpass() throws Exception{
		  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.LOGINEXCEL, "forgotpassword");
		  return data;
	  }
}
