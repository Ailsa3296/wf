package utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;






public class ParseXml {
	private static final Element Element = null;
	private String filePath;
	private Document document;
	
	public ParseXml(String filePath) throws Exception{
		this.filePath=filePath;
		this.load(this.filePath);
		
	

}
	private Element load(String filePath) throws DocumentException{
		File file =new File (filePath);
		if(file.exists()){
			SAXReader reader=new SAXReader();
			document=reader.read(file);
		}
		return null;	
		
	}


/*
 * elementPath 是一个xpath路径，比如“/config/driver”
 * @return 返回的是一个节点Element对象
 */
private Element getElementObject(String elementPath){
	return (Element)
	document.selectSingleNode(elementPath);
	
}
//用Xpath来判断一个结点对象是否存在
public boolean isExist(String elementPath){
	boolean flag=false;
	Element element=this.getElementObject(elementPath);
	if(element!=null) 
		flag=true;
	return flag;
	
}
/*
 * 用Xpath来取得一个结点对象的值
 */
public String getElementText(String elementPath){
	Element element=this.getElementObject(elementPath);
		if(element!=null){
			return element.getText().trim();}
		else {
			return null;
		}
			
		}
			
	
}

