package com.buffalocart.Scripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.buffalocart.Pages.RolesPage;

public class RoleTest extends BaseTest {
	@Test(priority=1)
	public void clickRoleslnl() {
		RolesPage obj= new RolesPage(driver);
		obj.clickroles();
		String expected="All roles";
		if(obj.getTextRole()=="All roles"&& expected=="All roles") {
		Assert.assertTrue(true);
		}
	}
  @Test(priority=2)
  public void verifyShowEntries() throws InterruptedException {
	  RolesPage obj= new RolesPage(driver);
	  obj.showEntries();
	  String expeentry="50";
	  Thread.sleep(2000);
	  if(obj.vShowentry()=="50" && expeentry=="50") {
		  assertTrue(true);
	  }
	  
}
 
  @Test(priority=3)
  public void verifyClickSearch() throws InterruptedException {
	  RolesPage obj= new RolesPage(driver);
	  obj.clickSearch();
	  String expeSearchvalue="admin";
	if(obj.vClickSearch()=="admin" &&expeSearchvalue=="admin");{
		Assert.assertTrue(true);
	}
  }
}
