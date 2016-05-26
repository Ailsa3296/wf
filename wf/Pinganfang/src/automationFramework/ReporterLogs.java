package automationFramework;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
 
import org.apache.log4j.xml.DOMConfigurator;
 
import org.junit.Test;
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utils.Log;
public class ReporterLogs {
	private static WebDriver driver;
	private static Logger Log = Logger.getLogger(Log.class.getName());
	@Test
	public static void test() {
		 
		DOMConfigurator.configure("log4j.xml");
 
        driver = new ChromeDriver();
 
        Log.info("New driver instantiated");
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        Log.info("Implicit wait applied on the driver for 10 seconds");
 
        driver.get("http://www.wf.qa.anhouse.com.cn/");
 
        Log.info("Web application launched");
 
        // Our first step is complete, so we produce a main event log here for our reports.
 
        Reporter.log("Application Lauched successfully | ");
 
        driver.findElement(By.id("topLogin")).click();
 
        Log.info("Click action performed on My Account link");
 
        driver.findElement(By.name("sMobile")).sendKeys("15618241286");
 
        Log.info("Username entered in the Username text box");
 
        driver.findElement(By.name("sPassword")).sendKeys("123456");
 
        Log.info("Password entered in the Password text box");
 
        driver.findElement(By.xpath(".//button[@id='pt_login_btn']")).click();
 
        Log.info("Click action performed on Submit button");
 
        // Here we are done with our Second main event
 
        Reporter.log("Sign In Successful | " );
 
        driver.findElement(By.id("topLogout"));
 
        Log.info("Click action performed on Log out link");
 
        driver.quit();
 
        Log.info("Browser closed");
 
        // This is the third main event
 
        Reporter.log("User is Logged out and Application is closed | ");
 
	}

}
