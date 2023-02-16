package tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;

public class HomeTest extends TestBase{

	@Test
	public void verifyLinks()
	{
		
		
		LoginPage login = new LoginPage(driver);
		HomePage homePage = login.doLogin("Admin", "admin123");
		
		Assert.assertEquals(homePage.isUserNamePresent(), true);
		
		ArrayList<String> list = homePage.getLinks();
		
		Assert.assertEquals(list.size(), Constants.HOMEPAGE_MENU_LINKS.size());
		
		Assert.assertEquals(list, Constants.HOMEPAGE_MENU_LINKS);
		
	}
	
	
	@Test
	public void verifyAdminButtonNavigatesToAdminPage()
	{

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		try
		{
			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
			element.click();
		}
		catch(TimeoutException e)
		{
			Assert.assertEquals(false, true, "Admin Element is not found");
		}
		
		WebElement topbarElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-topbar-header-breadcrumb")));
		String text = topbarElement.getText();
		
		Assert.assertEquals(text, Constants.ADMIN_USERMANAGEMENT_HEADER);
	}	
}
