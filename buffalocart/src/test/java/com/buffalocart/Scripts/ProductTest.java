package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.buffalocart.Pages.ProductPage;

public class ProductTest extends BaseTest {
  @Test(priority=1)
  public void verifyPdctLnk() {
	  ProductPage objpdctpg=new ProductPage(driver);
	  objpdctpg.clickPdctLnk();
	  boolean check= objpdctpg.pdcttypeIsDisplayed();
	  Assert.assertNotNull(check);
	  
  }
  @Test(priority=2)
  public void verifyStockRpt() {
	  ProductPage objpdctpg=new ProductPage(driver);
	  objpdctpg.clickStockRpt();
	  boolean checkstckrpt= objpdctpg.stcktableIsdisplayed();
	  Assert.assertTrue(checkstckrpt);
  }
  @Test(priority=3)
  public void verifyBtnTwo() {
	  ProductPage objpdctpg=new ProductPage(driver);
	  objpdctpg.clickBtnTwo();
	  boolean checkbtnclick= objpdctpg.clickBtnTwoIsDisplayed();
	  Assert.assertNotNull(checkbtnclick); 
	  
  }
  @Test(priority=4)
  public void verifytxtSearch() throws InterruptedException {
	  ProductPage objpdctpg=new ProductPage(driver);
	  objpdctpg.verifySearch();
	  Thread.sleep(2000);
	  String expecval="pen";
	  if(objpdctpg.vSearch()=="pen" && expecval=="pen") {
		  Assert.assertTrue(true);
	  }
	  
  }
  @Test(priority=5)
  public void verifyFilters() throws InterruptedException {
	  ProductPage objpdctpg=new ProductPage(driver);
	  objpdctpg.drpFilters();
	  String expecbrand="VKC";
	  Thread.sleep(2000);
	  Assert.assertEquals(objpdctpg.vFilters(), expecbrand);
  }
}
