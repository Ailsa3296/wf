package automationFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MultipleTest {
	public WebDriver driver;
  @Test
  public void One() {
	  System.out.println("This is the Test case number one");
  }
  @Test(priority = 1)
  public void Two() {
	  System.out.println("This is the Test case number two");
  }
  @Test(priority =2)
   public void Three() {
		  System.out.println("This is the Test case number Three");
  }
  @Test(priority = 3)
   public void Four() {
		  System.out.println("This is the Test case number Four");
  }
}
 