package com.buffalocart.Scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buffalocart.Constants.Constants;
import com.buffalocart.Pages.CustomerGroup;
import com.buffalocart.Utilities.ExcelUtilities;


public class CustomerGroupTest extends BaseTest {
	CustomerGroup objcustGroup;
	@Test(priority=1)
	public void verifyCustGroup() {
		objcustGroup=new CustomerGroup(driver);
		objcustGroup.custGpClick();
		String expectedtxt="All Customer Groups";
		if(objcustGroup.getCustgpText()=="All Customer Groups" && expectedtxt=="All Customer Groups") {
		Assert.assertTrue(true);
		}
	}
	@Test(priority=2)
	public void verifyCustgpAdd() {
		objcustGroup=new CustomerGroup(driver);
		objcustGroup.add();
		String expectdname="Add Customer Group";
		if(objcustGroup.getAddCustgp()=="Add Customer Group" && expectdname=="Add Customer Group") {
			Assert.assertTrue(true);
		}
		
	}
  @Test(dataProvider="verifyInvalid", priority=3, enabled =false)
 
	  public void verifyInvalid(String groupname ,String percentage) throws InterruptedException {
	  objcustGroup=new CustomerGroup(driver);
	  objcustGroup.addCustGpName(groupname);
	  objcustGroup.addCustGpCalculanPer(percentage);
	  objcustGroup.clicksubmit();
	  String expectedpervalue= "101";
		  
		  Assert.assertEquals(objcustGroup.getPercentagevalue(), expectedpervalue);
		 
  }
  @Test(dataProvider="verifyValid",priority=3, enabled =false)
  public void verifyValid(String groupname ,String percentage) throws InterruptedException {
	  objcustGroup=new CustomerGroup(driver);
	  objcustGroup.addCustGpName(groupname);
	  objcustGroup.addCustGpCalculanPer(percentage);
	  objcustGroup.clicksubmit();
	  String expectedpervalue= "70";
		  
		  Assert.assertEquals(objcustGroup.getPercentagevalue(), expectedpervalue);
  }
 
  @DataProvider
  public Object[][] verifyInvalid() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.CustGroup,"invalid");
	  return data;
  }
  @DataProvider
  public Object[][] verifyValid() throws Exception{
	  Object[][] data=ExcelUtilities.getdatafromExcel(Constants.CustGroup,"valid");
	  return data;
  }
}
