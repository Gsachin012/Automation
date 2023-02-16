package util;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void doClick(By locator)
	{
		System.out.println("Inside doClick Method");
		System.out.println("Locator : " + locator);
		try {
		driver.findElement(locator).click();
		System.out.println("Click successful");
		}
		catch(Exception e)
		{
			System.out.println("Click not successful");
			e.printStackTrace();
		}
	
		
	}
	
	public void doClick(String xpath)
	{
		System.out.println("Inside doClick Method");
		System.out.println("Xpath : " + xpath);
		try {
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("Click successful");
		}
		catch(Exception e)
		{
			System.out.println("Click not successful");
			e.printStackTrace();
		}
	
	}
	
	public void doClick(WebElement ele)
	{
		System.out.println("Inside doClick Method with WebElement");
		
		try {
		ele.click();
		System.out.println("Click successful");
		}
		catch(Exception e)
		{
			System.out.println("Click not successful");
			e.printStackTrace();
		}
	
	}
	
	
	
	public void enterText(By locator, String text)
	{
		System.out.println("Inside enterText Method");
		System.out.println("Locator : " + locator);
		try {
			driver.findElement(locator).sendKeys(text);
			System.out.println("Text Entered successfully");
		}
		catch(Exception e)
		{
			System.out.println("Text not Entered successfully");
			e.printStackTrace();
		}
		
	}
	
	
	public boolean isElementPresent(By locator, int time)
	{
		System.out.println("Inside isElementPresent Method");
		System.out.println("Locator : " + locator);
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver,time);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			System.out.println("Element is present within " + time);
			return true;
				
		}
		catch(TimeoutException e)
		{
			System.out.println("Element is not present");
			e.printStackTrace();
			return false;
		}
	}
	

}
