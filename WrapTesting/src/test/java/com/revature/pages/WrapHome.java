package com.revature.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WrapHome 
{
	public String title = "Wrap Recipes";
	
	@FindBy(xpath="//input[@name='login']")
	public WebElement username;
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	@FindBy(xpath="//input[@name='commit']")
	public WebElement loginButton;
	@FindBy(xpath="//li[@id='logOut']")
	public WebElement logOut;
	
	public WrapHome(WebDriver driverIn)
	{
		PageFactory.initElements(driverIn, this);
	}
	
	public void logIntoWrap(String usernameIn, String passwordIn)
	{
		this.username.sendKeys(usernameIn);
		this.password.sendKeys(passwordIn);
		this.loginButton.click();
	}
	
	public void logOutOfWrap()
	{
		this.logOut.click();
	}
	
}
