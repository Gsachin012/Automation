package testbase;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import driverfactory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.PropConfig;
import util.ScreenshotUtil;

public class TestBase {

	protected WebDriver driver;
	protected WebDriverWait wait;
	Properties prop;
	
	@BeforeTest
	public void beforeTest()
	{
		prop = PropConfig.init_properties("UAT");
	}
	
	
	@BeforeMethod
	public void beforeMethod(ITestResult result)
	{
		System.out.println("--------------Execution started for Testcase " + result.getMethod().getMethodName()+ "---------");
		String browser = prop.getProperty("browser");
		driver = DriverFactory.init_driver(browser);
		String urlValue = prop.getProperty("url");
		driver.get(urlValue);
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	}
	

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
		}
		driver.quit();
	}


}
