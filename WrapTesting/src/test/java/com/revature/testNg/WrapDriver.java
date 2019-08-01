package com.revature.testNg;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WrapDriver 
{
	static WebDriver driver;
	static String url;
	
	@BeforeClass
	public void setup() 
	{
		// Chrome setup
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterClass
	public void teardown() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.quit();
	}
	
	@Test
	public void logIntoWrap() 
	{
		assertEquals(driver.getTitle(), "Wrap Recipes");
		driver.findElement(By.name("login")).sendKeys("BenTest");
		driver.findElement(By.name("password")).sendKeys("asdf");
		driver.findElement(By.name("commit")).click();
		
		assertEquals(driver.getTitle(), "Wrap Recipes");
	}
}
