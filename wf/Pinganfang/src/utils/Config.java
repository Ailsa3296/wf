package utils;

public class Config {
	public static String browser;
	public static int waitTime;

	
	static {
		 ParseXml px = null;
		try {
			px = new ParseXml("config/config.xml");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  browser =px.getElementText("/config/browse");
		 // System.out.println(browser);
		 waitTime=Integer.valueOf(px.getElementText("/config/waitTime"));
		// System.out.println(waitTime);
		 
	} 
	
   public static void main(String[] args){
       System.out.println(Config.browser);
       System.out.println(Config.waitTime);
	 
   }

public static int getConfig(String string) {
	return Config.waitTime ;
}









}

