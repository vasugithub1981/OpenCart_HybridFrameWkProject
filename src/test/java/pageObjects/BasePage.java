package pageObjects;

//instead of creating driver in every page we create base page and extends other classes

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
WebDriver driver;

public BasePage(WebDriver driver) 
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}
