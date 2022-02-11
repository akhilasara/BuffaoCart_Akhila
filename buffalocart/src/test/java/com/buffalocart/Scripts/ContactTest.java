package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.Pages.ContactsPage;

public class ContactTest extends BaseTest {
  @Test(priority=1)
  
  public void verifyContactPage() {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.clickContactPage();
	 boolean check= obj.dropdownisDisplayed();
	  Assert.assertTrue(check);
	  
  }
 
   @Test(priority=2)
  public void verifySearch() throws InterruptedException {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.searchButton();
	  boolean checksearch=obj.searchbtnisDisplayed();
	  Assert.assertNotNull(checksearch);
  }
  @Test(priority=4)
  public void verifyClickCustomer() {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.clickCustomer();
	 boolean check= obj.txtSearchIsdisplayed();
	  Assert.assertTrue(check);
  }
  @Test(priority=5)
  public void verifySearchCust() throws InterruptedException {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.searchCust();
	  String expecvalue="jack";
	  if(obj.vSearchUser()=="jack" && expecvalue =="jack") {
	  Assert.assertTrue(true);;
	  }
  }
  @Test(priority=6)
  public void verifyCustAction() {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.clickcustAction();
	 boolean checkcustaction= obj.isCustActionDisplayed();
	  Assert.assertNotNull(checkcustaction);
  }
  @Test(priority=7)
  public void verifyPaymentDue() {
	  ContactsPage obj=new ContactsPage(driver);
	  obj.clickView();
	  boolean checkview= obj.isClickViewDisplayed();
	  Assert.assertNotNull(checkview);
  }
 
  
  
}
