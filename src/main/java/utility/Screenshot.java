package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.Test_Base;

public class Screenshot extends Test_Base
{
	public static String getdate()
	{
		return new SimpleDateFormat("dd-MM-YYYY HH-mm-ss").format(new Date());
		
	}
	public static void ss(String nameofmethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File ("C:\\Users\\Sudhir\\eclipse-workspace\\selenium_framework\\Screenshot_Data\\" +nameofmethod+ "--" +getdate()+ ".jpeg");
		FileHandler.copy(source, dest);
	}
	

}
