//This page is TEST CASE for both Home page and acount registration page page objects  - TEST CASE
//Main Class to RUN

package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups={"Regression","Master"}) // for grouping
//	@Test
	public void test_account_Registration() 
	{
		logger.debug("Application Logs..!");
		logger.info("**** TC_001 Account Registration Test ****");
		
		try
		{
				
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My ACcount");
		
		hp.clickRegister(); 
		logger.info("Clicked on Register"); 
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("PRoviding Customer Data");
		regpage.setFirstName(randomeString().toUpperCase()); 
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");
		
		String value=randomAlphaNumberic(); 
		//if you got password and re-enter password, for two options it picks different random values; so assign to variable
		regpage.setPassword(value);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("CLicked on Continue");
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating Expected Message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Hello Buddy..Expected Message not displayed");
		// above "expected message... - its output message only
		} 
		catch(Exception e)
		{
		Assert.fail();	
		}
		
		logger.info("Finised TC-001 Accoutn Registration Test");
	}

	
}
