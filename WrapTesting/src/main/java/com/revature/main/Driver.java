package com.revature.main;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver 
{	
	static WebDriver driver;
	static String url = "http://localhost:4200";
	static Logger logger = Logger.getLogger(Driver.class.toString());
	
	public static void main(String[] args) throws InterruptedException
	{
		logger.info("Start");
		
//		try
//		{
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			//Chrome Setup
			driver = new ChromeDriver();
			driver.get(url);
			
			
			checkTitle("Wrap Recipes");
			
			driver.findElement(By.name("login")).sendKeys("BenTest");
			driver.findElement(By.name("password")).sendKeys("asdf");
			driver.findElement(By.name("commit")).click();
			Thread.sleep(10000);
			driver.quit();
//		}
//		catch(Exception caughtException)
//		{
//			logger.info("Exception thrown: " + caughtException.getMessage());
//			driver.quit();
//		}
		
		logger.info("End");
	}
	
	public static void checkTitle(String expectedIn)
	{
		String testString = "TEST";
		String actualTitle = driver.getTitle();
		if(!actualTitle.equals(expectedIn))
		{
			logger.info(testString + " FAILED!");
			logger.info("EXPECTED: \"" + expectedIn + "\"");
			logger.info("ACTUAL: \"" + actualTitle + "\"");
		}
		else
		{
			logger.info("Title Check PASSED!!");
		}
	}
}
