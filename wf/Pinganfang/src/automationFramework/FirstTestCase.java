package automationFramework;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase {
	 
	public static void main(String[] args) throws Exception {
		
		  WebDriver driver ;
	      String baseUrl;
		// TODO Auto-generated method stub
		   System.setProperty("webdirver.chrome.driver","D:\\drivers\\chromedriver.exe");
		   driver = new ChromeDriver();
		   //driver.get(Constant.URL);
		   baseUrl="http://www.wf3.qa.anhouse.com.cn";
		   driver.get(baseUrl+"/");
		   driver.manage().window().maximize();
		   driver.findElement(By.id("topLogin")).click();
		   driver.findElement(By.name("sMobile")).sendKeys("15618241286");
		   driver.findElement(By.name("sPassword")).sendKeys("123456");
		   driver.findElement(By.className("login_btn")).click();
		   Thread.sleep(3000);
		   driver.quit();
		   
		  /* LoginPage loginPage=new LoginPage(driver);
		   HomePage homePage=new HomePage(driver);
		   homePage.lnk_MyAccount().click();
		   loginPage.userName().sendKeys("15618241286");
		   loginPage.password().sendKeys("123456");
		   loginPage.loginButton().click();
		   Thread.sleep(3000);
		   driver.quit();
		   */
	}


}


