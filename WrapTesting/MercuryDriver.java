import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MercuryDriver 
{
  @Test
  public void f() 
  {
	  static WebDriver driver;
		static String url = "http://newtours.demoaut.com";
		
		public void setUp()
		{
			System.out.println("Start");
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			//Chrome Setup
			driver = new ChromeDriver();
			driver.get(url);
			Thread.sleep(30000);
			driver.quit();
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			
			//driver = new FirefoxDriver();
			driver.get(url); 
		}
		
		public void tearDown()
		{
			Thread.sleep(30000);
			driver.quit();
		}
		
		public static void main(String[] args) throws InterruptedException
		{
			setUp();
			tearDown();
//			System.out.println("Start");
//			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//			//Chrome Setup
//			driver = new ChromeDriver();
//			driver.get(url);
//			Thread.sleep(30000);
//			driver.quit();
//			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//			
//			//driver = new FirefoxDriver();
//			driver.get(url); 
//			
//			checkTitle("Welcome: Mercury Tours");
//			
//			driver.findElement(By.name("userName")).sendKeys("bobbert");
//			driver.findElement(By.name("password")).sendKeys("bobbert");
//			driver.findElement(By.name("login")).click();
//			
//			System.out.println("End");
		}
		
		public void logIntoMercuryTours()
		{
			assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
			driver.findElement(By.name("userName")).sendKeys("bobbert");
			driver.findElement(By.name("password")).sendKeys("bobbert");
			driver.findElement(By.name("login")).click();
			
			assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
			
			List<WebElement> els = driver.findElements(By.xpath("//input{@name='tripType'}"));
			
			for(int i = 0; i < els.size(); i++)
			{
				els.get(i).click();
				assertEquals(els.get(i).getAttribute("checked", "true"));
			}
			
			els = driver.findElements(By.xpath("//select{@name='fromPort'}/option"));
			
			for(WebElement e: els)
			{
				e.click();
			}
		}
		
		public static void checkTitle(String expectedIn)
		{
			String testString = "TEST";
			String actualTitle = driver.getTitle();
			if(!actualTitle.equals(expectedIn))
			{
				System.out.println(testString + " FAILED!");
				System.out.println("EXPECTED: \"" + expectedIn + "\"");
				System.out.println("ACTUAL: \"" + actualTitle + "\"");
			}
			else
			{
				System.out.println("PASSED!!");
			}
		}
  
}
