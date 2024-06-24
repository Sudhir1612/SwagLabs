package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class BackToHome_Page extends Test_Base
{
	@FindBy(xpath = "//span[text()='Checkout: Complete!']")private WebElement completetext;
	@FindBy(xpath = "//img[@class='pony_express']")private WebElement image;
	@FindBy(xpath = "//h2[@class='complete-header']")private WebElement thankyoutext;
	@FindBy(xpath = "//div[@class='complete-text']")private WebElement text1;
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small']")private WebElement backbtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement text;
	
	public BackToHome_Page()
	{
		PageFactory.initElements(driver , this);
	}
	public String verifycompletetitle()
	{
		return completetext.getText();
		
	}
	public boolean verifyimage()
	{
		return image.isDisplayed();
		
	}
	public String verifythankyoutitle()
	{
		return thankyoutext.getText();
	}
	public String verifytext()
	{
		return text1.getText();
	}
	public String clickonbackbtn()
	{
		backbtn.click();
		return driver.getCurrentUrl();
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
