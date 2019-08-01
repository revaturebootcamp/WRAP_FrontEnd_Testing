package com.revature.pages;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UserHome 
{
    public String title = "Wrap Recipes";
//    @FindBy(xpath="//input[@name='tripType']")
//    public List<WebElement> tripType;
//    @FindBy(xpath="//input[@name='fromPort']/option")
//    public List<WebElement> fromPorts;
//    @FindBy(xpath="//input[@name='toPort']/option")
//    public List<WebElement> toPorts;
    
    public UserHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
//    public void selectToPort(String port) {
//        for(WebElement e: toPorts) {
//            if((e.getAttribute("value").toLowerCase().equals(port.toLowerCase()))) {
//                e.click();
//                return;
//            }
//        }
//        throw new NoSuchElementException("Specified port does not exist...");
//    }
}