package com.revature.testNg;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.pages.UserHome;
import com.revature.pages.WrapHome;

public class WrapHomeAdvanced 
{
	public static WebDriver driver;
	public final String URL = "http://localhost:4200";
	
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement username;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//input[@name='commit']")
	public WebElement loginButton;
	
	@BeforeClass(groups= {"setup"})
	  public void setUp()
	  {
		  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get(URL);
	  }
	  
	  @AfterClass(groups= {"teardown"})
	  public void tearDown() throws InterruptedException
	  {
		 Thread.sleep(10000);
		 driver.quit();
	  }
	  
//	  @Test
//		public void dataDrivenLogin(String usernameIn, String passwordIn)
//		{
//			WrapHome mh = new WrapHome(driver);
//			mh.logIntoWrap(usernameIn, passwordIn);		
//		}
	  
	  @Test(groups= {"smoke"})
	  public void confirmHomePage()
	  {
		  WrapHome wh = new WrapHome(driver);
		  assertEquals(driver.getTitle(), wh.title);
	  }
	  
	  @Test
	  public void logIntoWrap()
	  {
		  WrapHome wh = new WrapHome(driver);
		  UserHome uh = new UserHome(driver);
		  wh.logIntoWrap("BenTest", "asdf");
		  assertEquals(driver.getTitle(), uh.title);
	  }
	
  /*
   * the dataprovider seeks to take in a 2d array of data for use in a data drive framework. For each record of data, the test that 
   * utilizes the provider will run each time
   * */
	
	@DataProvider(name="wrapData")
	public Object[][] accountDetails()
	{
		Object[][] data = null;
		try(Workbook wb = new XSSFWorkbook(new FileInputStream("src/test/resources/WrapData.xlsx")))
		{
			Sheet sheet = wb.getSheet("Sheet1");//Grabs correct spread sheet
			int rowCount = sheet.getLastRowNum();
			data = new Object[rowCount][2];
			
			for(int i = 1; i <= rowCount; i++)
			{
				Row row = sheet.getRow(i);
				data[i - 1] = new Object[]
				{
					row.getCell(0).getStringCellValue(),
					row.getCell(1).getStringCellValue()
				};
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
		}
	}
