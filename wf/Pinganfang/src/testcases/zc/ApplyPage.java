package testcases.zc;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
 
import org.testng.annotations.BeforeMethod;
 
import org.testng.annotations.AfterMethod;

import appModules.SighIn_Action;
 
 
 
import utils.Constant;
import utils.ExcelUtils;
import utils.Log;
/*
 * @author wangfang
 */
public class ApplyPage {
	public WebDriver driver;
	private WebElement searchInputBox;
	@BeforeMethod
	public void beforeMethod() throws Exception {
		 
	  	DOMConfigurator.configure("log4j.xml");
 
		Log.startTestCase("Selenium_Test_001");
 
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
 
		Log.info(" 打开Excel表格");
 
		driver = new ChromeDriver();
 
		Log.info("New driver 初始化");
 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
		Log.info("等待10秒");
 
		driver.get(Constant.URL);
		
	    driver.manage().window().maximize();
 
        }
 
	@Test
 
  public void main() throws Exception {
   // 用户登录
		
       
		SighIn_Action.Execute(driver);
    //点击好房首页“好房金融”tab页
		driver.findElement(By.linkText("好房金融"));
        Log.info("点击首页好房金融tab页");
    //在好房金融弹出的下拉框选择“e房钱”，并点击之进入e房钱首页
		driver.get("http://gold.wf3.qa.anhouse.com.cn/efq/home/index.html");
		Log.info("在好房金融弹出下拉框选择e房钱 ");
	   AssertTrue(driver.getPageSource().contains("e房钱"));
	    System.out.println("成功进入e 房钱首页");
	    Log.info("进入e 房钱首页");
	    Reporter.log("成功进入e房钱首页|  ");
     //在e 房钱首页，点击链接“申请e房钱”，进入e房钱申请页面
	    driver.findElement(By.linkText("申请e房钱")).click();
	    Log.info("点击申请e房钱链接");
	   AssertTrue(driver.getPageSource().contains("申请信息"));
	    System.out.println("进入e房钱申请页面"); 
	    Reporter.log("成功进入e房钱申请页面|  ");  
     
	
      //获取当前window的句柄，并切换到当前windows 句柄
	    String currentHandle = driver.getWindowHandle();
		Set<String> windowshandles = driver.getWindowHandles();
		for (String s : windowshandles) {
			if (s.contains(currentHandle)) {
				continue;
			} else {
				driver.switchTo().window(s);
			}
		}
		 
    //【小区名称】输入关键字匹配然后选中包含关键字的信息
	 driver.findElement(By.id("sCommunityName")).clear();
	searchInputBox = driver.findElement(By.id("sCommunityName"));
   //手动输入关键字"临"
	searchInputBox.sendKeys("临");
	Thread.sleep(3000);
	List<WebElement>suggetionOptions=driver.findElements(By.xpath(".//*[@id='addName']/ul/li"));
	for(WebElement element:suggetionOptions){
		if(element.getText().contains("临沂八村")){
			System.out.println(element.getText());
			element.click();
			break;
		}
	 
		
	}
	  Log.info("输入【小区名称】信息");
	//输入【物业地址】，【产证面积】选项
	
	 driver.findElement(By.id("sAddr")).clear();
	 Thread.sleep(3000);
	 driver.findElement(By.id("sAddr")).sendKeys(Constant.Address);
	 Log.info("输入【物业地址】信息");
	 driver.findElement(By.id("iAreNum")).clear();
	 Thread.sleep(3000);
	 driver.findElement(By.id("iAreaNum")).sendKeys(Constant.AreaNum);
	 Log.info("输入【产证面积】信息");
	 Thread.sleep(3000);
	 //选择【抵押情况 】选项	
	 List<WebElement>  oRadioButton1 = driver.findElements(By.name("iMortgageType"));
	 for(WebElement radiobutton:oRadioButton1){
   		 if(radiobutton.getAttribute("value").equals("1")){
   			 if(!radiobutton.isSelected())
   				 radiobutton.click();
   			   continue;
   		 }   
	 Log.info("选择【抵押情况】信息");
   //输入【期望售价】选项
	 driver.findElement(By.id("iExpctPrice")).clear();
	 Thread.sleep(3000);
	 driver.findElement(By.id("iExpctPrice")).sendKeys(Constant.ExpctPrice); 
	 Log.info("选择【期望售价】信息");
	//输入【申请人姓名】选项
	 driver.findElement(By.name("sUserName")).clear();
	 Thread.sleep(3000);
	 Log.info("选择【申请人姓名】信息");
	 driver.findElement(By.name("sUserName")).sendKeys(Constant.UserName);
	 //输入【身份证号码】选项
	 driver.findElement(By.name("sCardID")).clear();
	 Thread.sleep(3000);
	 Log.info("选择【身份证号码】信息");
     driver.findElement(By.name("sCardID")).sendKeys(Constant.CardID);
     //输入【联系电话】选项  
     driver.findElement(By.name("sMobile")).clear();
     Thread.sleep(3000);
     Log.info("选择【联系电话】信息");
     driver.findElement(By.name("sMobile")).sendKeys(Constant.Mobile);
     
     
   //选择【是否是中介推荐 】选项	
     Thread.sleep(3000);
   	 List<WebElement>  oRadioButton = driver.findElements(By.name("sCompanyType"));
   	 for(WebElement radiobutton1:oRadioButton){
   		 if(radiobutton1.getAttribute("value").equals("1")){
   			 if(!radiobutton1.isSelected())
   				 radiobutton1.click();
   			   continue;
   		 }
   	 }
   	  Log.info("选择【是否是中介推荐】信息");
   	 //输入【好房专员】选项--选填
   	    driver.findElement(By.id("sAgentMobile")).sendKeys("15618241286");
   	    Log.info("输入【好房专员】信息");
   	 // 点击按钮【下一步，上传资料】
   	    driver.findElement(By.id("submit-apply")).click();
   	    Log.info("点击按钮【下一步，上传资料】");
	    System.out.println("e 房钱申请提交成功");	
	    Log.info("e 房钱申请提交成功");
	}
}


   private void AssertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}

@AfterMethod
 
  public void afterMethod() {
	   
	     driver.quit();
	     Log.info("关闭浏览器");
	     Reporter.log(" e 房钱申请提交成功| ");
        }


 
}
