package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNG {
	public WebDriver driver;
  @Test
  public void main() {
	    Home_Page.lnk_MyAccount(driver).click();
		 
	     LogIn_Page.txtbx_UserName(driver).sendKeys("15618241286");
	 
	     LogIn_Page.txtbx_Password(driver).sendKeys("123456");
	 
	     LogIn_Page.btn_LogIn(driver).click();
	 
	     System.out.println("好房首页登录成功");
	 
	     Home_Page.lnk_LogOut(driver).click(); 
  }
 
  
  @BeforeMethod
  public void beforeMethod() {
	
	  
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.get("http://www.wf.qa.anhouse.com.cn/");
 
  }
  

  @AfterMethod
  public void afterMethod() {
	
	    driver.quit();
  }

}
