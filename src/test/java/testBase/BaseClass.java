//This page is BAse clas for Test CASE.

package testBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;		//for logging
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;



//import io.github.bonigarcia.wdm.WebDriverManager; not needed in new selenium

public class BaseClass 
{
	public static WebDriver driver; //make it static so that in EXTENT REPORTS we need to create an object then it will be conflict
	// if its static no need to create object
	// we need to add log here
	
	public Logger logger;
	public ResourceBundle rb; //import from java.util package - for importing data from config file 
	
	@BeforeClass(groups= {"Master", "Sanity", "Regression"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config"); //loading config file
		
		logger=LogManager.getLogger(this.getClass()); // this will display current class-logging
		

//		we dont need to use webdriver in the latest selenium, its inbuild.
		//just use driver keyword.
		//we can directly write webDriver driver= new chromeDriver()
//		WebDriverManager.chromedriver().setup(); // WebdriverMAnager Dependency added in POM
		//we declared webdriver above globally
	
			if(br.equals("chrome"))
		{
			driver=new ChromeDriver();	
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			Assert.fail();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		driver.get("https://demo.opencart.com/index.php"); // live website is not accepting automation registrations
	//	driver.get("http://localhost/opencart/upload/index.php");
		driver.get(rb.getString("appURL1")); // getting data from congif file
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(groups= {"Master", "Sanity", "Regression"})
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	public String randomeString() // to generate random String for email
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
//	public String randomeNumber()
//	{
//		String generatedString2=RandomStringUtils.randomNumeric(10);
//		return(generatedString2);
//	}
	
	public String randomAlphaNumberic()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(st+"@"+num);  // to generate random password Ex: "test@123" format - 8 characters
	}
	
	public String captureScreen(String tname) throws IOException // MEthod for capture screen 
	{ 
		
	//	SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
	//	Date dt= new Date(); //import from java.util
	//	String timeStamp=df.format(dt);
	// instead of above 3 lines you can write in single line below	 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e)
		{
			e.getMessage();
		}
		return destination;
	}

}