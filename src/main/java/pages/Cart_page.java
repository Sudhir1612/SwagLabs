package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class Cart_page extends Test_Base 
{
	@FindBy(xpath = "//div[@class='app_logo']")private WebElement pagetitle;
	@FindBy(xpath = "//span[@class='title']")private WebElement yourcarttitle;
	@FindBy(xpath = "//div[@class='cart_quantity_label']")private WebElement quantitylable;
	@FindBy(xpath = "//div[@class='cart_desc_label']")private WebElement descriptionlable;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement threelinebtn;
	@FindBy(xpath = "//button[@id='continue-shopping']")private WebElement continueshoppingbtn;
	@FindBy(xpath = "//button[@id='checkout']")private WebElement checkoutbtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement text;
	
	public Cart_page()
	{
		PageFactory.initElements(driver, this);
		
	}
	public String verifycartpageUrl()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifypagetitle()
	{
		return pagetitle.getText() ;
	}
	public String verifycarttitle()
	{
		return yourcarttitle.getText();
	}
	public String verifyquantitylable()
	{
		return quantitylable.getText();
	}
	public String verifydiscriptionlable()
	{
		return descriptionlable.getText();
	}
	public boolean verifythreelinebtn()
	{
		return threelinebtn.isEnabled();
	}
	public boolean verifycontinueshoppingbtn()
	{
		return continueshoppingbtn.isDisplayed();
	}
	
	public String verifychechoutbtn()
	{
		checkoutbtn.click();
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
   
