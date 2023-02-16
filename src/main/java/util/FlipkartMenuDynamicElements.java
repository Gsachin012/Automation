package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartMenuDynamicElements {
	
	static String xpath = "//a[text()='REPLACE']";

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium - Dec batch\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.className("_2doB4z")).click();
		
		WebElement fashion = driver.findElement(By.xpath("//img[@alt='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(fashion).perform();
		
		//WebElement kids = driver.findElement(By.xpath(getXpath("Kids")));
		
		WebElement kids = driver.findElement(By.xpath(getNewXpath(xpath, "Kids")));
		
		action.moveToElement(kids).perform();
		
	//	WebElement girlsDresses = driver.findElement(By.xpath(getXpath("Girls Dresses")));
		
		WebElement girlsDresses = driver.findElement(By.xpath(getNewXpath(xpath, "Girls Dresses")));
		
		girlsDresses.click();
		Thread.sleep(5000);
		
		ScreenshotUtil.takeScreenshot(driver, "Screen3");
		
		
		
		

	}
	
	
	public static String getXpath(String value)
	{
		
		String xpath1 = "//a[text()='";
		
		String xpath2 = "']";
		
		String totalXpath = xpath1+value+xpath2;
		
		System.out.println(totalXpath);
		
		return totalXpath;
		
	}
	
	public static String getNewXpath(String xpath, String value)
	{
		
		String newXpath = xpath.replace("REPLACE", value);
		
		System.out.println(newXpath);
		
		return newXpath;
		
		
	}

}
