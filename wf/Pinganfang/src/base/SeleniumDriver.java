package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.dom4j.dom.*;
import utils.Config;

public class SeleniumDriver {
	private WebDriver driver;
	public WebDriver getDriver(){
		return driver;
	}
	public SeleniumDriver(){
		this.initialDriver();
	}

	private void initialDriver(){

		if ("firefox".equals(Config.browser)){
			driver=new FirefoxDriver();
		}else if ("ie".equals(Config.browser)){
			System.setProperty("webdriver.ie.driver", "res/IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			driver=new InternetExplorerDriver(ieCapabilities);
			
		}else if ("chrome".equals(Config.browser)){
			System.setProperty("webdriver.ie.driver", "res/chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--test-type");
			driver =new ChromeDriver(options);
			
		}else{
			System.out.println(Config.browser+"的值不正确，请检查");
		}
			
		
	}
}


