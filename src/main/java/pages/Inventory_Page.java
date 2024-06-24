package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.Test_Base;
import utility.HandleDropDownList;

public class Inventory_Page extends Test_Base
{

	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") private WebElement productbackpack;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") private WebElement productbikelight;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement productTshirt;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-fleece-jacket']")private WebElement productjacket;
	@FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-onesie']") private WebElement productlabs;
	@FindBy(xpath = "//button[@name='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement productredtshirt;
	@FindBy(xpath = "//span[@class='title']")private WebElement productTitle;
	@FindBy(xpath = "//div[@class='app_logo']")private WebElement pagelogo;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")private WebElement menuebutton;
	@FindBy(xpath = "//select[@class='product_sort_container']")private WebElement dropdown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement cartcount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement carticon;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']")private WebElement facebooklogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkedinlogo;
	@FindBy(xpath = "//div[@class='footer_copy']")private WebElement text;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-fleece-jacket']")private WebElement removeproductjacket;
	@FindBy(xpath = "//button[@name='remove-sauce-labs-onesie']")private WebElement removeproductlabs;
	
	public Inventory_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyproductTitle()
	{
		return productTitle.getText();
	}
	public boolean Verifypagelogo()
	{
		return pagelogo.isDisplayed();
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
	public String add6products()
	{
		HandleDropDownList.handleselect(dropdown, "Price (high to low)");
		productbackpack.click();
		productbikelight.click();
		productTshirt.click();
		productjacket.click();
		productlabs.click();
		productredtshirt.click();
		return carticon.getText();
	}
	public void clickoncarticon()
	{
		carticon.click();
	}
	
	public String remove2products()
	{
		add6products();
		removeproductjacket.click();
		removeproductlabs.click();
		return cartcount.getText();
	}
	
}