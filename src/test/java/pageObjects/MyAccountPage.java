package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage 
{
//Constructor
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//Elements	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	//@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	//@FindBy(xpath="a[@class='list-group-item'][text()='Logout']")
	@FindBy(xpath="//a[@class='dropdown-item'][text()='Logout']")
	WebElement lnkLogout;
	

//Action Methods
	public boolean isMyAccountPageExists()
	{
		try
		{
		return msgHeading.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout() throws InterruptedException 
	{
		Thread.sleep(2000);
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END); // Page scroll Down
		

		//HomePage.clickMyAccount();
		HomePage.lnkMyaccount.click();
	//	driver.findElement(By.xpath("//a[@class='dropdown-item'][text()='Logout']")).click();
		Thread.sleep(2000);
		lnkLogout.click();
		Thread.sleep(2000);
	}
	
}
