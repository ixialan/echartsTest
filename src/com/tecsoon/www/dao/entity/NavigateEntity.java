/**
 * 
 */
package com.tecsoon.www.dao.entity;

import java.io.Serializable;

/**
 * @author ZEROONE
 *
 */
public class NavigateEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1022903163473537107L;
	
	private String objecType;
	private String objcetName;
	private String nums;
	
	public NavigateEntity() {}

	/**
	 * @param objecType
	 * @param objcetName
	 * @param nums
	 */
	public NavigateEntity(String objecType, String objcetName, String nums) {
		this.objecType = objecType;
		this.objcetName = objcetName;
		this.nums = nums;
	}

	/**  
	 * 获取objecType  
	 * @return objecType objecType  
	 */
	public String getObjecType() {
		return objecType;
	}

	/**  
	 * 设置objecType  
	 * @param objecType objecType  
	 */
	public void setObjecType(String objecType) {
		this.objecType = objecType;
	}

	/**  
	 * 获取objcetName  
	 * @return objcetName objcetName  
	 */
	public String getObjcetName() {
		return objcetName;
	}

	/**  
	 * 设置objcetName  
	 * @param objcetName objcetName  
	 */
	public void setObjcetName(String objcetName) {
		this.objcetName = objcetName;
	}

	/**  
	 * 获取nums  
	 * @return nums nums  
	 */
	public String getNums() {
		return nums;
	}

	/**  
	 * 设置nums  
	 * @param nums nums  
	 */
	public void setNums(String nums) {
		this.nums = nums;
	}

}
