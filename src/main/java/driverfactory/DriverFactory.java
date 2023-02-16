package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.sun.corba.se.pept.transport.EventHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import listener.WebDriverListenerClass;

public class DriverFactory {
	
	static WebDriver  driver;
	
	public static WebDriver init_driver(String browser)
	{
		if(browser.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		}
		else if (browser.equals("FF"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Enter correct browser name [chrome, FF]");
			System.exit(0);
		}
		driver.manage().window().maximize();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		WebDriverListenerClass driverListener = new WebDriverListenerClass();
		eDriver.register(driverListener);
		driver = (WebDriver)eDriver;
		return driver;
	}
	
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
