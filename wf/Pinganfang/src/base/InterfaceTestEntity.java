/**
* @Title: InterfaceParam.java 
* @Package com.pinganfang.WTD.entities 
* @Description: To do something
* @author hekun hekun@pinganfang.com
* @date 2014年8月21日 下午2:18:06 
* @version V1.0   
 */
package base;

import java.util.List;

/**
 * @author hekun
 * the interface test test entity
 */
public class InterfaceTestEntity extends BaseEntity{

	private String  name;// the name of the parameter
	
	private String expectContansString;// the type of the parameter
	
	private List<InterfaceParam> interfaceParams;
	
	private String preExcution="";
	
	private String method="";

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the expectContansString
	 */
	public String getExpectContansString() {
		return expectContansString;
	}

	/**
	 * @param expectContansString the expectContansString to set
	 */
	public void setExpectContansString(String expectContansString) {
		this.expectContansString = expectContansString;
	}

	/**
	 * @return the preExcution
	 */
	public String getPreExcution() {
		return preExcution;
	}

	/**
	 * @param preExcution the preExcution to set
	 */
	public void setPreExcution(String preExcution) {
		this.preExcution = preExcution;
	}

	/**
	 * @return the value
	 */
	public List<InterfaceParam> getInterfaceParams() {
		return interfaceParams;
	}

	/**
	 * @param value the value to set
	 */
	public void setInterfaceParams(List<InterfaceParam> interfaceParams) {
		this.interfaceParams = interfaceParams;
	}


}
