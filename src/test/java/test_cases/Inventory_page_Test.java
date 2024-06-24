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
import pages.Inventory_Page;
import pages.Login_Page;
import utility.Read_Data;
import utility.Screenshot;

public class Inventory_page_Test extends Test_Base
{
	Login_Page login;
	Inventory_Page invent;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		login = new Login_Page();
		invent = new Inventory_Page();
		login.loginToApplication();
	}
	@Test (groups = "Sanity")
	public void verifyproductTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle = Read_Data.Readexcel(0, 3);      //"Products"; (0,3)
		String actTitle = invent.VerifyproductTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Product Title = " + actTitle);
	}
	@Test 
	public void verifypagelogoTest()
	{
		boolean Result = invent.Verifypagelogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Page Logo Is Present = " + Result);
	}
	@Test(groups = "Retest")
	public void verifyTwitterLogoTest()
	{
		boolean Result = invent.VerifyTwitterlogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Twitter Logo Is Present = " + Result);
	}
	@Test(groups = "Sanity")
	public void verifyfacebooklogotest()
	{
		boolean Result = invent.Verifyfacebooklogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Facebook Logo Is Present = " + Result);
	}
	@Test( groups = "Retest")
	public void verifylinkedinlogotest()
	{
		boolean Result = invent.Verifylinkedinlogo();
		Assert.assertEquals(Result, true);
		Reporter.log("linkedin Logo Is Present = " + Result);
	}
	@Test( groups = "Sanity")
	public void verifyTexttest() throws EncryptedDocumentException, IOException
	{
		String exptext = Read_Data.Readexcel(0, 4);    //"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";(0,4)
		String acttext = invent.VerifyText();
		Assert.assertEquals(exptext , acttext);
		Reporter.log("text is Visible = " + acttext);
	}
	@Test( groups = "Retest")
	public void add6productstest() throws EncryptedDocumentException, IOException
	{
		String expcount = Read_Data.Readexcel(0, 5);     //"6";(0,5)
		String actcount = invent.add6products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Total Products add to Cart = " + actcount);
	}
	@Test( groups = "Sanity")
	public void remove2productstest() throws EncryptedDocumentException, IOException
	{
		String expcount = Read_Data.Readexcel(0, 6); //"4";(0,6)
		String actcount = invent.remove2products();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("Total Products After Remove To The Cart = " + actcount);
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
