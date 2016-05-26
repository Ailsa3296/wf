package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.*;

// Import Package utility.*

import utils.Constant;
import utils.ExcelUtils;
import appModules.SighIn_Action;

public class Apache_POI_TC {
	
	
	public static void main(String[] args) throws Exception {

    //打开Excel文件， 将文件路径和文件名称，表格名称作为方法的参数
    WebDriver driver = null;
		 
    ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");

    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get(Constant.URL);
    
    driver.manage().window().maximize();

    SighIn_Action.Execute(driver);

    System.out.println("Login Successfully!");

    Home_Page.lnk_LogOut(driver).click();  

    driver.quit();
    //将用例执行的结果放在Excel的表格

    ExcelUtils.setCellData("Pass", 1, 3);
    

	}
}
