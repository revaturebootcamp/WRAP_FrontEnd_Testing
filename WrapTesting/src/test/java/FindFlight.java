import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindFlight 
{
	public String title = "Wrap Recipes";
	
	@FindBy(xpath="//input[@name='tripType']")
	public List<WebElement> tripType;
	
	@FindBy(xpath="//input[@fromPort='fromPort']/option")
	public List<WebElement> fromPort;
	
	@FindBy(xpath="//input[@fromPort='toPort']/option")
	public List<WebElement> toPort;
	
	public FindFlight(WebDriver driverIn)
	{
		PageFactory.initElements(driverIn, this);
	}
	
	public void selectToPort(String portIn)
	{
		for(WebElement e: toPort)
		{
			if(e.getAttribute("value").toLowerCase().equals(portIn.toLowerCase()))
			{
				e.click();
				return;
			}
		}
		throw new NoSuchElementException("Specified port does not exist....");
	}
	
}
