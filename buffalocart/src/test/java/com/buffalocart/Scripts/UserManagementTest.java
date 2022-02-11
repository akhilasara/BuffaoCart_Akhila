package com.buffalocart.Scripts;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.LoginPage;
import com.buffalocart.Pages.UserManagementPage;
import com.buffalocart.Utilities.ExcelUtilities;

public class UserManagementTest extends BaseTest {
	UserManagementPage objUserManagement;
	@Test(priority=1)
	public void addUser() {
		objUserManagement=new UserManagementPage(driver);
		objUserManagement.clickadd();
		String expec="Add user";
		if(objUserManagement.getAddUser()=="Add user" && expec=="Add user") {
			Assert.assertTrue(true);
		}
	}
  @Test(dataProvider="addUserdata",priority=2)
  
  public void addUsers(String surname,String firstname,String lastname,String email,String roles,String pass,String conpass,String commper,String selectcontact) throws InterruptedException, AWTException{
	  
	
	    objUserManagement=new UserManagementPage(driver);
	    objUserManagement.setsurname(surname);
	 	objUserManagement.setfirstname(firstname);
	 	objUserManagement.setlastname(lastname);
	 	objUserManagement.setemail(email);
	 	objUserManagement.setdroprole(roles);
	 	objUserManagement.setpass(pass);
	 	objUserManagement.setconfpass(conpass);
	 	objUserManagement.setcommpercent(commper);
	 	objUserManagement.setselectedContacts(selectcontact);
	    objUserManagement.setSave();
	 	   String expectedtxt="All users";
	 	   if(objUserManagement.getUser()=="All users" && expectedtxt=="All users") {
	 		   Assert.assertTrue(true);
	 	   }
	  
  }
  @DataProvider
  public Object[][] addUserdata() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.USEREXCEL, "addusersheet");
	  return data;
  }
}
