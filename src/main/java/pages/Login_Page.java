package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;
import utility.Read_Data;

public class Login_Page extends Test_Base
{
	@FindBy (xpath="//input[@id='user-name']")private  WebElement UserTxtBox;
	@FindBy(xpath="//input[@id='password']")private WebElement PwdTxtBox;
	@FindBy (xpath = "//input[@id='login-button']")private WebElement LoginBtn;
	public Login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String loginToApplication() throws IOException
	{
		UserTxtBox.sendKeys(Read_Data.Readpropertyfile("UserName"));
		PwdTxtBox.sendKeys(Read_Data.Readpropertyfile("Password"));
		LoginBtn.click();
		return driver.getCurrentUrl();
	}

	public String verifyurlofapplication ()
	{
		return driver.getCurrentUrl();
		
	} 
	public String verifytitleofapplication ()
	{
		return driver.getTitle();
	}
	public String verifymulticredentials(String un, String Pwd)
	{
		UserTxtBox.sendKeys(un);
		PwdTxtBox.sendKeys(Pwd);
		LoginBtn.click();
		return driver.getCurrentUrl();
	}
   
}
