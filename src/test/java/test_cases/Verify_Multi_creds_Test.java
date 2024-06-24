package test_cases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import base.Test_Base;
import pages.Login_Page;
import utility.Screenshot;

public class Verify_Multi_creds_Test extends Test_Base
{
	Login_Page login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new Login_Page();
	}
	@DataProvider(name = "validation")
	public Object [][]getdata()
	{
		return new Object [][]
		{
			{"standard_user" , "secret_sauce"},
			{"locked_out_user" , "secret_sauce"},
			{"problem_user" , "secret_sauce"},
			{"performance_glitch_user" , "secret_sauce"},
			{"error_user" , "secret_sauce"},
			{"visual_user" , "secret_sauce"},	
		};
	}
	@Test(dataProvider = "validation")
	public void verifymulticredentialstest(String un, String Pwd)
	{
		SoftAssert s = new SoftAssert();
		String expurl = "https://www.saucedemo.com/inventory.html";
		String acturl = login.verifymulticredentials(un, Pwd);
		s.assertEquals(expurl, acturl);
		s.assertAll();
	}
	@AfterMethod
	public void closebrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.ss(it.getName());
		}
		driver.close();
    }

}
