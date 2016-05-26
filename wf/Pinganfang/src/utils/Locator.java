package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utils.Config;

import org.ho.yaml.Yaml;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locator {
	private WebDriver driver;
	private String yamlFile;
	
	public Locator(WebDriver driver) throws FileNotFoundException{
		yamlFile="demo";
		this.getYamlFile();
		this.driver=driver;
		
	}
	private HashMap<String,HashMap<String,String>>ml;
	public void getYamlFile() throws FileNotFoundException {
		
		File f=new File("locator/"+yamlFile+".yaml");
	
			   ml=Yaml.loadType(new FileInputStream(f.getAbsoluteFile()), HashMap.class);
		      // System.out.println(ml.get("baidu_input").get("type"));
			  // System.out.println(ml.get("baidu_button").get("value"));	
			
		
	
		}
		
	

  private By getBy(String type,String value){
	  By by=null;
	  if(type.equals("id")){
		  by=By.id(value);
	  }
	  if(type.equals("name")){
		  by=By.id(value);
	  }
	  if(type.equals("xpath")){
		  by=By.id(value);
	  }
	  if(type.equals("classname")){
		  by=By.id(value);
	  }
	  if(type.equals("linkText")){
		  by=By.id(value);
	  }
	  if(type.equals("css")){
		  by=By.id(value);
	  }
	  
	  
	return by;
  }

  
  private WebElement waitForElement(final By by){
	  WebElement element=null;
	  int 	waitTime=Config.waitTime;
	  try{
	  
	element=new WebDriverWait(driver,waitTime).until(new ExpectedCondition<WebElement>()
		
			  {
		       public   WebElement apply(WebDriver d){
			   return driver.findElement(by);
			   }
		  });
		  
	  
  }catch(Exception e){
	  System.out.println(by.toString()+"is not exist until"+waitTime);
  }
	  return element;
  }
  
  
  private boolean waitElementToBeDisplayed(final WebElement element) {
	    boolean wait = false;
	    if (element == null)
	        return wait;
	    try {
	        wait = new WebDriverWait(driver, Config
	                .getConfig("waitTime"))
	                .until(new ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver d) {
	                        return element.isDisplayed();
	                    }
	                });
	    } catch (Exception e) {
	        System.out.println(element.toString() + " is not displayed");
	    }
	    return wait;
	}
  
  public boolean waitElementToBeNonDisplayed(final WebElement element) {
	    boolean wait = false;
	    if (element == null)
	        return wait;
	    try {
	        wait = new WebDriverWait(driver,Config
	                .getConfig("waitTime"))
	                .until(new ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver d) {
	                        return !element.isDisplayed();
	                    }
	                });
	    } catch (Exception e) {
	        System.out.println("Locator [" + element.toString()
	                + "] is also displayed");
	    }
	    return wait;
	}
	 
 
  private String getLocatorString(String locatorString, String[] ss) {
	    for (String s : ss) {
	        locatorString = locatorString.replaceFirst("%s", s);
	    }
	    return locatorString;
	}
  private WebElement getLocator(String key,String[] replace, boolean wait) {
	    WebElement element = null;
	    if (ml.containsKey(key)) {
	        HashMap<String, String> m = ml.get(key);
	        String type = m.get("type");
	        String value = m.get("value");         
	        if(replace!=null)
	        	value=this.getLocatorString(value, replace);
	         By by = this.getBy(type, value);
	        if (wait) {
	            element = this.waitForElement(by);
	            boolean flag = this.waitElementToBeDisplayed(element);
	            if (!flag)
	                element = null;
	        } else {
	            try {
	                element = driver.findElement(by);
	            } catch (Exception e) {
	                element = null;
	            }
	        }
	    } else
	        System.out.println("Locator " + key + " is not exist in " + yamlFile
	                + ".yaml");
	    return element;
	}
  
  
  public void setLocatorVariableValue(String variable, String value){
	    Set<String> keys = ml.keySet();
	    for(String key:keys){
	         String v = ml.get(key).get("value").replaceAll("%"+variable+"%", value);
	         ml.get(key).put("value",v);
	    }
	}
  //公共的locator 放在一个文件中
  private HashMap<String, HashMap<String, String>> extendLocator;
  @SuppressWarnings("unchecked")
  public void loadExtendLocator(String fileName){
      File f = new File("locator/" + fileName + ".yaml");
      try {
          extendLocator = Yaml.loadType(new FileInputStream(f.getAbsolutePath()),
                  HashMap.class);
          ml.putAll(extendLocator);
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
  }
  public WebElement getElement(String key){
	    return this.getLocator(key,null, true);
}
  public WebElement getElementNoWait(String key) {
	   
	    return this.getLocator(key,null,false);
	}
  public WebElement getElement(String key,String[] replace){
	    return this.getLocator(key,replace, true);
}
  public WebElement getElementNoWait(String key,String[] replace) {
	   
	    return this.getLocator(key,replace, false);
	}
}
  
 



