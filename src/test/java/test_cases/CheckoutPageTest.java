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
import pages.Cart_page;
import pages.CheckoutPage;
import pages.Inventory_Page;
import pages.Login_Page;
import utility.Read_Data;
import utility.Screenshot;

public class CheckoutPageTest extends Test_Base
{
	Login_Page login;
	Inventory_Page invent;
	Cart_page cart;
	CheckoutPage check1;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();	
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new Cart_page();
		check1 = new CheckoutPage();
		login.loginToApplication();
		invent.add6products();
		invent.clickoncarticon();
		cart.verifychechoutbtn();
	}
	@Test
	public void verifyinfotitletest()
	{
		String expTitle = "Checkout: Your Information";
		String actTitle = check1.verifyinfotitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout Page Step2 Info Title =" + actTitle);
	}
	@Test
	public void inputinformationtest()
	{
		String expUrl = "https://www.saucedemo.com/checkout-step-two.html";
		String actUrl = check1.Inputinformation();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("checkout Page Step2 URL =" + actUrl);
	}
	@Test
	public void verifycancelbtntest()
	{
		boolean Result = check1.verifycancelbtn();
		Assert.assertEquals(Result, true);
		Reporter.log("Cancel Button is Displayed = " + Result);
	}
	@Test
	public void verifyTwitterLogoTest()
	{
		boolean Result = invent.VerifyTwitterlogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Twitter Logo Is Present = " + Result);
	}
	@Test
	public void verifyfacebooklogotest()
	{
		boolean Result = invent.Verifyfacebooklogo();
		Assert.assertEquals(Result, true);
		Reporter.log("Facebook Logo Is Present = " + Result);
	}
	@Test
	public void verifylinkedinlogotest()
	{
		boolean Result = invent.Verifylinkedinlogo();
		Assert.assertEquals(Result, true);
		Reporter.log("linkedin Logo Is Present = " + Result);
	}
	@Test
	public void verifyTexttest() throws EncryptedDocumentException, IOException
	{
		String exptext = Read_Data.Readexcel(0, 4);    //"© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";(0,4)
		String acttext = invent.VerifyText();
		Assert.assertEquals(exptext , acttext);
		Reporter.log("text is Visible = " + acttext);
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
