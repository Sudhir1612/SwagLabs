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
import pages.Payment_Finish_Page;
import utility.Read_Data;
import utility.Screenshot;

public class Payment_Finish_Test extends Test_Base
{
	Login_Page login;
	Inventory_Page invent;
	Cart_page cart;
	CheckoutPage check1;
	Payment_Finish_Page finish;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();	
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new Cart_page();
		check1 = new CheckoutPage();
		finish = new Payment_Finish_Page();
		login.loginToApplication();
		invent.add6products();
		invent.clickoncarticon();
		cart.verifychechoutbtn();
		check1.Inputinformation();
		
	}
	@Test
	public void Verifyoverviewtitletest()
	{
		String expTitle = "Checkout: Overview";
		String actTitle = finish.Verifyoverviewtitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Finish Page Overview Title =" + actTitle);
	}
	@Test
	public void Verifypaymentinfotest()
	{
		String expTitle = "Payment Information:";
		String actTitle = finish.Verifypaymentinfo();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Finish Page Payment Title =" + actTitle);
	}
	@Test
	public void Verifyshippinginfotest()
	{
		String expTitle = "Shipping Information:";
		String actTitle = finish.Verifyshippinginfo();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Finish Page Shipping Title =" + actTitle);
	}
	@Test
	public void Verifypricetitaltest()
	{
		String expTitle = "Price Total";
		String actTitle = finish.Verifypricetitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Finish Page Price Total Title =" + actTitle);
	}
	@Test
	public void Verifycancelbtntest()
	{
		boolean Result = finish.Verifycancelbtn();
		Assert.assertEquals(Result, true);
		Reporter.log("Cancel Button is Displayed = " + Result);
	}
	@Test
	public void Clickonfinishbtntest()
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL = finish.clickonfinishbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Finish Page home URL =" + actURL);
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
