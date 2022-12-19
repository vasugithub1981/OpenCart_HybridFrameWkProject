//This page is for the Home page of the Website - PAGE OBJCET

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class HomePage extends BasePage
{
	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver); //super keyword will invoke parent class constructor
	}		
	
	//Elements
		@FindBy(xpath = "//span[text()='My Account']")
		static WebElement lnkMyaccount;

		@FindBy(linkText = "Register")
		WebElement lnkRegister;
		
		// for login Page - below
		@FindBy(linkText= "Login")    
		WebElement linklogin;
		
		
	//Action Methods
		static public void clickMyAccount()
		{
			lnkMyaccount.click();
		}

		public void clickRegister()
		{
			lnkRegister.click();
		}
		
		public void clickLogin()
		{
			linklogin.click();
		}
			
}


