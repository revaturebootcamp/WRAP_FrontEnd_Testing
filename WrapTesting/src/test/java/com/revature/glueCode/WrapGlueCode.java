package com.revature.glueCode;

import static com.revature.glueCode.WrapDriverUtility.driver;
import static org.testng.Assert.assertEquals;

import com.revature.pages.UserHome;
import com.revature.pages.WrapHome;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WrapGlueCode 
{
	public WrapHome wh;
	public UserHome hp;
	
//	@Given("^a user is at the homepage of Wrap Recipes$")
//	public void aUserIsAtTheHomepageOfWrapRecipes()
//	{
//		wh = new WrapHome0(driver);
//		assertEquals(wh.title, driver.getTitle());
//	}
//	
//	@When("^a user inputs their username and password and submit$")
//	public void theUserInputsTheirUsernameAndPasswordAndSubmit()
//	{
//		wh = new WrapHome0(driver);
//		wh.logIntoWrap("BenTest", "asdf");
//	}
//	
//	@Then("^the user is redirected to the home page$")
//	public void theUserIsRedirectedToTheHomePage()
//	{
//		hp = new UserHome(driver);
//		assertEquals(hp.title, driver.getTitle());
//	}
	
	@Given("^a user is at the homepage of Wrap Recipes$")
	public void aUserIsAtTheHomepageOfWrapRecipes()
	{
		wh = new WrapHome(driver);
		assertEquals(wh.title, driver.getTitle());
	}
	
	@When("^a user inputs their \"([^\"]*)\"$")
	public void aUserInputsTheir(String usernameIn)
	{
		wh = new WrapHome(driver);
		wh.username.sendKeys(usernameIn);
	}
	
	@When("^a user inputs their \"([^\"]*)\"$")
	public void their(String passwordIn)
	{
		wh = new WrapHome(driver);
		wh.password.sendKeys(passwordIn);
	}
	
	@When("^then submits the information$")
	public void thenSubmitsTheInformation()
	{
		wh = new WrapHome(driver);
		wh.loginButton.click();
	}
	
	@Then("^the user is redirected to the home page$")
	public void theUserIsRedirectedToTheHomePage()
	{
		hp = new UserHome(driver);
		assertEquals(hp.title, driver.getTitle());
	}
}
