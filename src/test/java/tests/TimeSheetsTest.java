package tests;

import testbase.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Attendance;
import pages.HomePage;
import pages.LoginPage;
import pages.TimeTimeSheetsPage;
public class TimeSheetsTest extends TestBase {
	
	
	@Test
	public void timesheetsTest1() throws InterruptedException
	{
		LoginPage login = new LoginPage(driver);
		HomePage homePage = login.doLogin("Admin", "admin123");
		Assert.assertEquals(homePage.isUserNamePresent(), true);
		TimeTimeSheetsPage timesheetPage = homePage.clickTimeLink();
		String actual = timesheetPage.getTitle();
		Assert.assertEquals(actual, "Time / Timesheets");
		
		Attendance attPage = timesheetPage.clickMyReports();
		
		boolean actualFlag = attPage.isHeaderCorrect("Attendance", "Attendance");
	
		Assert.assertEquals(actualFlag, true);
		
	}

}
