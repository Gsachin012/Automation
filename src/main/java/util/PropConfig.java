package util;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropConfig {
	static Properties prop;
	
	public static Properties init_properties(String env)
	{
		
		String userDir = System.getProperty("user.dir");
		String filePath="";
		if(env.equals("SIT"))
		{
			filePath = userDir + "\\src\\main\\java\\config\\config_SIT.properties";
		}
		else if(env.equals("UAT"))
		{
			 filePath = userDir + "\\src\\main\\java\\config\\config_UAT.properties";
		}
		System.out.println(filePath);
		File file = new File(filePath);
		try {
		FileReader fileReader = new FileReader(file);
			prop = new Properties();
			prop.load(fileReader);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return prop;
	}
	

}
