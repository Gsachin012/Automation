package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;

public class LoginTest extends TestBase{
	

	@Test
	public void loginTest()
	{
		LoginPage login = new LoginPage(driver);
		HomePage homePage = login.doLogin("Admin", "admin123");
		
		boolean flag = homePage.isUserNamePresent();
		Assert.assertEquals(flag, true, "Username element not displayed");

		String username = homePage.getUserName();
		Assert.assertEquals(username, Constants.HOMEPAGE_USERNAME);
	
	}	
	
	
	@Test
	public void invalidLogin()
	{
		LoginPage login = new LoginPage(driver);
		login.doLogin("Admin", "admin");
		boolean isPresent = login.isInvalidCredMsgPresent();
		Assert.assertEquals(isPresent, true);
		String actual = login.getInvalidMsgText();
		Assert.assertEquals(actual, Constants.INVALID_CRED_MSG);
	}
	
	@Test
	public void redirectToResetPasswordPageLinkPresent()
	{
		boolean flag;
		try {
			driver.findElement(By.className("orangehrm-login-forgot-header"));
			flag=true;
		}
		catch(NoSuchElementException e)
		{
			flag=false;
		}
		Assert.assertEquals(flag, true);
	}
	
	
	@Test(dependsOnMethods = {"redirectToResetPasswordPageLinkPresent"})
	public void navigateToResetPassword()
	{
		driver.findElement(By.className("orangehrm-login-forgot-header")).click();
		boolean flag;
		String str="";		
		try {
			////h6[text()='Reset Password']
			
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("orangehrm-forgot-password-title")));
			flag=true;
			str = element.getText();
		}
		catch (Exception e) {
			flag=false;
		}
		
		Assert.assertEquals(flag, true);
		Assert.assertEquals(str, Constants.RESET_PASSWORD_PAGE_HEADER);
	}
	
}
