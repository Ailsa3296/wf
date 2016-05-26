package testcases.zc;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Constant;
import utils.Locator;
import base.SeleniumDriver;

public class CrowdFunding {
	
	public void main() throws FileNotFoundException{
		
		SeleniumDriver  selenium=new SeleniumDriver();
		
		WebDriver driver=selenium.getDriver();
		
		driver.get(Constant.URL);
			
		driver.manage().window().maximize();
		 
		  Locator d=new Locator(driver);
	  
		  WebElement element=d.getElement("baidu_input");
		  
		  element.sendKeys("");
		
	}
	 
	 

}
