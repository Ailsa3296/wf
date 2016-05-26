/**
 * @Title: Configure.java 
 * @Package com.pinganfang.WTD.util 
 * @Description: Global information
 * @author hekun hekun@pinganfang.com
 * * @date 2014年10月17日 下午3:50:18 
 * @version V1.0   
 */
package utils;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
//import testcases.ui.MainUIController;

/**
 * @author hekun
 * 
 */
public class GlobalInfo {

	public static String rootPath = null;//the rootPath is the project path
	public static String pcIP;//the test server's ip
	public static String pcHostName;// the test server's hostname
	public static WebDriver currentWebDriver;
	public static HashMap<String, String> bid=new HashMap<String,String>();
	public static boolean isLaunchByUI=false;
	public static boolean isOnlineTest=true;
	public static String HostName="";
	public static HashMap<String, String> varibles=new HashMap<String,String>();
//	public static MainUIController mainUIController=null;
}
