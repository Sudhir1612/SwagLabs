package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Payment_Finish_Page extends Test_Base
{
	@FindBy(xpath = "//span[@class='title']")private WebElement overviewtitle;
	@FindBy(xpath = "//div[text()='Payment Information:']")private WebElement paymentinfo;
	@FindBy(xpath = "//div[text()='Shipping Information:']")private WebElement shippinginfo;
	@FindBy(xpath = "//div[text()='Price Total']")private WebElement pricetotal;
	@FindBy(xpath = "//button[@id='cancel']")private WebElement cancelbtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement text;
	@FindBy(xpath = "//button[@id='finish']")private WebElement finishbtn;
	public Payment_Finish_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String Verifyoverviewtitle()
	{
		return overviewtitle.getText();
	}
	public String Verifypaymentinfo()
	{
		return paymentinfo.getText();
		
	}
	public String Verifyshippinginfo()
	{
		return shippinginfo.getText();
		
	}
	public String Verifypricetitle()
	{
		return pricetotal.getText();
		
	}
	public boolean Verifycancelbtn()
	{
		return cancelbtn.isDisplayed();
	}
	public boolean VerifyTwitterlogo()
	{
		return TwitterLogo.isDisplayed();
	}
	public boolean Verifyfacebooklogo()
	{
		return facebooklogo.isDisplayed();
	}
	public boolean Verifylinkedinlogo()
	{
		return linkedinlogo.isDisplayed();
	}
	public String VerifyText()
	{
		return text.getText();
	}
	public String clickonfinishbtn()
	{
		finishbtn.click();
		return driver.getCurrentUrl();
	}

}
