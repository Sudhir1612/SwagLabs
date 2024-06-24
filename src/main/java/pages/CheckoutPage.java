package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class CheckoutPage extends Test_Base
{
	@FindBy(xpath = "//span[@class='title']")private WebElement yourinfotitle;
	@FindBy(xpath = "//input[@id='first-name']")private WebElement firstnametxtbox;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement lastnametxtbox;
	@FindBy(xpath = "//input[@id='postal-code']")private WebElement pincodetxtbox;
	@FindBy(xpath = "//button[@id='cancel']")private WebElement cancelbtn;
	@FindBy(xpath = "//input[@id='continue']")private WebElement continuebtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement text;
	
	public CheckoutPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyinfotitle()
	{
		return yourinfotitle.getText();
		
	}
	public String Inputinformation()
	{
		firstnametxtbox.sendKeys("Sudhir");
		lastnametxtbox.sendKeys("Madiwal");
		pincodetxtbox.sendKeys("591108");
		continuebtn.click();
		return driver.getCurrentUrl();
		
	}
	public boolean verifycancelbtn()
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

}
