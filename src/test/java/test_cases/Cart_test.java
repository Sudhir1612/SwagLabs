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
import pages.Inventory_Page;
import pages.Login_Page;
import utility.Read_Data;
import utility.Screenshot;

public class Cart_test extends Test_Base
{
	Login_Page login;
	Inventory_Page invent;
	Cart_page cart;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		
		login = new Login_Page();
		invent = new Inventory_Page();
		cart = new Cart_page();
		login.loginToApplication();
		invent.add6products();
		invent.clickoncarticon();
	}
	@Test
	public void verifycartpageUrltest() throws EncryptedDocumentException, IOException
	{
		String expURL = Read_Data.Readexcel(1, 0);
		String actURL = cart.verifycartpageUrl();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page URL =" + actURL);
		
	}
	@Test
	public void verifypagetitletest() throws EncryptedDocumentException, IOException
	{
		String exptitle = Read_Data.Readexcel(0, 1);
		String acttitle = cart.verifypagetitle();
		Assert.assertEquals(exptitle, acttitle);
		Reporter.log("Cart Page Title =" + acttitle);
	}
	@Test
	public void verifycarttitletest() throws EncryptedDocumentException, IOException
	{
		String exptitle = Read_Data.Readexcel(1, 1);
		String acttitle = cart.verifycarttitle();
		Assert.assertEquals(exptitle, acttitle);
		Reporter.log("Cart Title =" + acttitle);
	}
	@Test
	public void verifyquantitylabletest() throws EncryptedDocumentException, IOException
	{
		String expQlable = Read_Data.Readexcel(1, 2);
		String actQlable = cart.verifyquantitylable();
		Assert.assertEquals(expQlable, actQlable);
		Reporter.log("QTY Lable =" + actQlable);
	}
	@Test
	public void verifydiscriptionlabletest() throws EncryptedDocumentException, IOException
	{
		String expDeslable = Read_Data.Readexcel(1, 3);
		String actDeslable = cart.verifydiscriptionlable();
		Assert.assertEquals(expDeslable, actDeslable);
		Reporter.log("Description Lable =" + actDeslable);
	}
	@Test
	public void verifythreelinebtntest() throws EncryptedDocumentException, IOException
	{
		boolean Result = cart.verifythreelinebtn();
	    Assert.assertEquals(Result, true);
	    Reporter.log("Three line button Is Present = " + Result);
	}
	@Test
	public void verifycontinueshoppingbtntest()
	{
		boolean Result = cart.verifycontinueshoppingbtn();
	    Assert.assertEquals(Result, true);
	    Reporter.log("Continue Shopping Button Is Present = " + Result);
	}
	@Test
	public void verifychechoutbtntest() throws EncryptedDocumentException, IOException
	{
		String expURL = Read_Data.Readexcel(1, 4);
		String actURL = cart.verifychechoutbtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("checkout Page Step1 URL =" + actURL);
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
