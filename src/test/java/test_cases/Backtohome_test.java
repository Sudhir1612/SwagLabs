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
import pages.BackToHome_Page;
import pages.BackToHome_Page;
import pages.Cart_page;
import pages.CheckoutPage;
import pages.Inventory_Page;
import pages.Login_Page;
import pages.Payment_Finish_Page;
import utility.Read_Data;
import utility.Screenshot;

public class Backtohome_test extends Test_Base
{
	Login_Page login;
	Inventory_Page invent;
	Cart_page cart;
	CheckoutPage check1;
	Payment_Finish_Page finish;
	BackToHome_Page home;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();	
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new Cart_page();
		check1 = new CheckoutPage();
		finish = new Payment_Finish_Page();
		home = new BackToHome_Page();
		login.loginToApplication();
		invent.add6products();
		invent.clickoncarticon();
		cart.verifychechoutbtn();
		check1.Inputinformation();
		finish.clickonfinishbtn();
		//home.clickonbackbtn();
	}
	@Test
	public void verifycompletetitletest()
	{
		String expTitle = "Checkout: Complete!";
		String actTitle = home.verifycompletetitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout complete Title =" + actTitle);
	}
	@Test
	public void verifyimagetest()
	{
		boolean Result = home.verifyimage();
		Assert.assertEquals(Result, true);
		Reporter.log("image is Displayed = " + Result);
	}
	@Test
	public void verifythankyoutitletest()
	{
		String expTitle = "Thank you for your order!";
		String actTitle = home.verifythankyoutitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("checkout thank you Title =" + actTitle);
	}
	@Test
	public void verifytexttest()
	{
		String exptext = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String acttext = home.verifytext();
		Assert.assertEquals(exptext, acttext);
		Reporter.log("checkout thank you Text =" + acttext);
	}
	@Test
	public void clickonbackbtntest()
	{
		String expURL = "https://www.saucedemo.com/inventory.html";
		String actURL = home.clickonbackbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Back To Home Product Page =" + actURL);
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
