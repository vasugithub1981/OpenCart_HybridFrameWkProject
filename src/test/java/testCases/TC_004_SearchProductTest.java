package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

@Test
public class TC_004_SearchProductTest extends BaseClass {

	public void test_productSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
		
			//sp.isProductExist("MacBook");
			//sp.isProductExist("Mac%");
			Thread.sleep(2000);
			Assert.assertEquals(sp.isProductExist("mac%"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
