

package pageObjects;


import org.openqa.selenium.*;

public class LogIn_Page {

       private static WebElement element = null;
      

   public static WebElement txtbx_UserName(WebDriver driver){

        element = driver.findElement(By.name("sMobile"));
	  
        return element;

        }

    public static WebElement txtbx_Password(WebDriver driver){

        element = driver.findElement(By.name("sPassword"));

        return element;

        }

    public static WebElement btn_LogIn(WebDriver driver){

        element = driver.findElement(By.className("login_btn"));

        return element;

        }

}