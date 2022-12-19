package pageObjects;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{
//Constructor
	public ResourceBundle rb; //import from java.util package - for importing data from config file 
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//Elements
	@FindBy(id="input-email")
	WebElement txtEmailAddress;
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btnLogin;
	
//Action Methods
	
	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
}
