package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driverfactory.DriverFactory;
import util.ScreenshotUtil;

public class TestNGListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("OnTestStart");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	//ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), result.getMethod().getMethodName());
		System.out.println("onTestFailure");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedWithTimeout");
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");
		
	}

}
