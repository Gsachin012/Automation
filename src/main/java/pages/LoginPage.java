package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	//WebElements
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.className("orangehrm-login-button");
	By invalidCredMsg = By.className("oxd-alert-content-text");
	
	String name = "pravash";
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementUtils = new ElementUtils(driver);
	}
	
	
	//PageActions
	public void enterUsername(String user)
	{
		
		elementUtils.enterText(username, user);
		
	}
	
	public void enterPassword(String pass)
	{
		
		elementUtils.enterText(password, pass);

	}
	
	public HomePage clickLoginButton()
	{
		elementUtils.doClick(loginButton);
	
		return new HomePage(driver);
	}
	
	
	public HomePage doLogin(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		return clickLoginButton();
	}
	
	
	public boolean isInvalidCredMsgPresent()
	{
		return elementUtils.isElementPresent(invalidCredMsg, 10);
	}
	
	public String getInvalidMsgText()
	{
		WebElement element = driver.findElement(invalidCredMsg);
		return element.getText();
	}

}
