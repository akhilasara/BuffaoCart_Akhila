package com.buffalocart.Scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.HomePage;


public class HomeTest extends BaseTest {
	public void verifyUser() {
		HomePage obj = new HomePage(driver);
		obj.clickUserProfile();
		String username="Aju Mathew";
         SoftAssert sa= new SoftAssert();
         sa.assertEquals(Constants.usernamevalid1, username);
         sa.assertAll();
	}
		
	@Test(priority=2)
	public void verifyClaculorTitle() {
		HomePage obj = new HomePage(driver);
		obj.clickCalculator();
		String expe="Calculator";
		if(obj.vCalculatorTitle()=="Calculator"&& expe=="Calculator") {
		Assert.assertTrue(true);
		}
	}
  @Test(priority=3)
  public void verifyUserClick() throws InterruptedException {
	  
	  HomePage obj= new HomePage(driver);
	 obj.clickUsermangmt();
	
	  obj.userClick();
	  String usertitle=driver.getTitle();
	  SoftAssert sa= new SoftAssert();
	  sa.assertEquals(usertitle, Constants.USERTITLE);
	  sa.assertAll();
	    }
  @Test(priority=4)
  public void verifyShowEntries() throws InterruptedException {
	  HomePage obj= new HomePage(driver);
	  obj.showEntries();
	  String expectvalue="25";
	  Thread.sleep(5000);
	  if(obj.isDisplayed()=="25" && expectvalue=="25") {
	  Assert.assertTrue(true);
	  }
	 
  }
  @Test(priority=5)
  public void verifyClickSearch() throws Exception {
	  HomePage obj= new HomePage(driver);
	  obj.searchUser();
	  String expectSearch="akhila";
	  Thread.sleep(5000);
	  if(obj.searchIsDiplayed()=="akhila" && expectSearch=="akhila") {
	  
	  Assert.assertTrue(true);
	  }
  }
  @Test(priority=1,groups={"sanity"})
  public void verifyendtour() {
	  HomePage obj= new HomePage(driver);
	  obj.clickapplicationtour();
  }
}
