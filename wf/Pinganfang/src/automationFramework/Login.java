package automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageObjects.Home_Page;
import utils.Constant;
import utils.ExcelUtils;
import utils.Log;
import appModules.SighIn_Action;
import base.SeleniumDriver;

public class Login {
	   SeleniumDriver selenium=new SeleniumDriver();
		WebDriver driver=selenium.getDriver();
	//public WebDriver driver;
  @Test
  public void main() throws Exception {
	    SighIn_Action.Execute(driver); 
		System.out.println("登陆成功");
		AssertTrue(driver.getPageSource().contains("退出"));
		Log.info("登陆成功");
		Home_Page.lnk_LogOut(driver).click(); 
 
		Log.info("退出登陆");
  }
  private void AssertTrue(boolean contains) {
	// TODO Auto-generated method stub
	
}
@BeforeMethod
  public void beforeMethod() throws Exception {
	 	      DOMConfigurator.configure("log4j.xml");
	 	 
	 			Log.startTestCase("Selenium_Test_001");
	 	 
	 			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
	 	 
	 			Log.info(" 打开Excel表格");
	 	 	   
	 				 
	 		 //  driver = new ChromeDriver();
	 			
	 			Log.info("New driver 初始化");
	 	 
	 			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	 
	 			Log.info("等待10秒");
	 	 
	 			driver.navigate().to(Constant.URL);
	 			
	 		    driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  
	    driver.quit();
  }

}
