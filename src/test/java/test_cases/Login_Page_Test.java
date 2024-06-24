package test_cases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Login_Page;
import utility.Read_Data;
import utility.Screenshot;

public class Login_Page_Test extends Test_Base
{
	Login_Page login;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new Login_Page();
	}
	@Test (groups = "Retest")
	public void verifyurlofapplicationTest() throws EncryptedDocumentException, IOException
	{
		String expurl = Read_Data.Readexcel(0, 0);    //"https://www.saucedemo.com/";(0.0)
		String acturl = login.verifyurlofapplication();
		Assert.assertEquals(expurl, acturl);
	}
	@Test (priority = 8 , groups = "Sanity")
	public void verifytitleofapplicationTest () throws EncryptedDocumentException, IOException
	{
		String exptitle = Read_Data.Readexcel(0, 1);         //"Swag Labs"; (0,1)
		String acttitle = login.verifytitleofapplication();
		Assert.assertEquals(exptitle, acttitle);
	}
	
	@Test (groups = "Retest")
	public void loginToApplicationTest() throws IOException
	{
		String expUrl= Read_Data.Readexcel(0, 2);       //"https://www.saucedemo.com/inventory.html"; (0,3)
		String actUrl = login.loginToApplication();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Log In Is Successful =" + actUrl);
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