package automationFramework;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.SeleniumDriver;
import utils.Constant;
import utils.Locator;

public class test{



public static void main(String[] args) throws FileNotFoundException {


  SeleniumDriver  selenium=new SeleniumDriver();
  WebDriver driver=selenium.getDriver();
  
  driver.get(Constant.URL);
  driver.manage().window().maximize();
  Locator d=new Locator(driver);
 WebElement element=d.getElement("baidu_input");
 element.sendKeys("学霸");
 WebElement element1=d.getElement("baidu_button");
 element1.click();
 


}
  }
