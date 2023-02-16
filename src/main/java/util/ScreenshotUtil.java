package util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	
	public static void takeScreenshot(WebDriver driver, String sceenshotName)
	{
		String path = System.getProperty("user.dir");
		String filePath = path + "\\screenshots\\" + sceenshotName +".jpg";
		System.out.println(filePath);
		
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(file, new File(filePath));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
