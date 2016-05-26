package appModules;
import pageObjects.Home_Page;

import org.openqa.selenium.WebDriver;

import pageObjects.LogIn_Page;
import utils.ExcelUtils;

public class SighIn_Action {
	
	public static void Execute(WebDriver driver) throws Exception{
		 
		//从Excel表格取值， 表格的行，列作为getCellData方法的传递参数

		String sUserName = ExcelUtils.getCellData(1, 1);

		String sPassword = ExcelUtils.getCellData(1, 2);
		
		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);

		LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);

		LogIn_Page.btn_LogIn(driver).click();
		
	
		
		
    }

}
