package com.revature.testNg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.pages.UserHome;
import com.revature.pages.WrapHome;

public class WrapHome0 
{
  public static WebDriver driver;
  public final String URL = "http://localhost:4200";
  
  @BeforeClass
  public void setUp()
  {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(URL);
  }
  
  @AfterClass
  public void tearDown() throws InterruptedException
  {
	 Thread.sleep(10000);
	 driver.quit();
  }
  
  @Test
  public void confirmHomePage()
  {
	  WrapHome mc = new WrapHome(driver);
	  assertEquals(driver.getTitle(), mc.title);
  }
  
  @Test(dependsOnMethods= {"confirmHomePage"})
  public void logIntoWrapRecipes()
  {
	  WrapHome mc = new WrapHome(driver);
	  UserHome ff = new UserHome(driver);
	  mc.logIntoWrap("BenTest", "asdf");
	  assertEquals(driver.getTitle(), ff.title);
  }
}
