// you need to run this program in XML
package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity", "Master"})
	//@Test
	public void test_login()
	{
		try
		{
		logger.info("Starting TC_002_Login Test..");
		
		HomePage hp=new HomePage(driver);
		HomePage.clickMyAccount();
		logger.info("Clicked on My Account");
		
		hp.clickLogin();
		logger.info("Clicked on Login");
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing Login Details..");
		lp.setEmail(rb.getString("email")); //getting from config.properties
		lp.setPassword(rb.getString("pwd")); 
		lp.clickLogin();
		logger.info("Clicked on Login Button..");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true, "LOGIN TEST Failed");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("Finished TC-002 Login Test..");
	}
	
	
}
