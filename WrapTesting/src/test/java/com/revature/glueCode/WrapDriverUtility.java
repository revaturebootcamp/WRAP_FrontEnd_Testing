package com.revature.glueCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WrapDriverUtility 
{
	public static WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}
	
	@After
	public void tearDown()
	{
		try 
		{
			Thread.sleep(10000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		if(driver != null)
		{
			driver.quit();
		}
	}
}
