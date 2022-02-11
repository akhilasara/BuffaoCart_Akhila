package com.buffalocart.Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.buffalocart.Constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterTest;

public class BaseTest {
	public static Properties prop=null;
	  public static WebDriver driver;
	   public static void testBase()
	   {
		   try {
			   prop= new Properties();
			   FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources"+"\\config.properties");
		   prop.load(ip);
		   }
		   catch(FileNotFoundException e) {
			   e.printStackTrace();
		   }catch(IOException e){
			   e.printStackTrace();
			   
		   }
	   }
	   
	   
		
  @AfterMethod
  public void takeScreenshotOnFailure(ITestResult iTestResult) throws IOException {
	 if(iTestResult.getStatus()==iTestResult.FAILURE)
	  {
		  takesScreenshotOnFailure(iTestResult.getName());
	  }
	  
  }
  public String takesScreenshotOnFailure(String name) throws IOException
  {
	  String dateName =new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  String destination=System.getProperty("user.dir")+"\\target\\" + name + dateName +".jpeg";
  File fileDestination= new File(destination);
  FileUtils.copyFile(source, fileDestination);
  return destination;
  
 
  }
  
@Parameters("browser")
  @BeforeTest(alwaysRun=true)
  public void beforeTest(String browser) throws Exception {
	  testBase();
	  if(browser.equalsIgnoreCase(Constants.FIREFOXBROWSER)) {
		  WebDriverManager.firefoxdriver().setup();
		  driver= new FirefoxDriver();}
	  
	   if(browser.equalsIgnoreCase(Constants.EDGEBROWSER)) {
		  WebDriverManager.edgedriver().setup();
		  driver= new EdgeDriver();
	  }
	  else if(browser.equalsIgnoreCase(Constants.CHROMEBROWSER)) {
		  WebDriverManager.chromedriver().setup();
		  driver= new ChromeDriver();
	  }
	  else {
		  throw new Exception(Constants.BROWSERNOTCORRECT);
	  }
	   driver.manage().window().maximize();
	  String baseUrl=prop.getProperty("baseUrl");
	  driver.get(baseUrl);
	
	  
  }

  @AfterTest
  public void afterTest() {
	 
	 driver.close();
  }

}
