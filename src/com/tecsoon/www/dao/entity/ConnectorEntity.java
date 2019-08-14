/**
 * 
 */
package com.tecsoon.www.dao.entity;

import java.io.Serializable;

/**
 * @author ZEROONE
 *
 */
public class ConnectorEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1634654258384914743L;
	
	private String connName;
	private String connType;
	private String nums;
	
	public ConnectorEntity() {}

	/**
	 * @param objecType
	 * @param objcetName
	 * @param nums
	 */
	public ConnectorEntity(String connName, String connType, String nums) {
		this.connName = connName;
		this.connType = connType;
		this.nums = nums;
	}

	public String getConnName() {
		return connName;
	}

	public void setConnName(String connName) {
		this.connName = connName;
	}

	public String getConnType() {
		return connType;
	}

	public void setConnType(String connType) {
		this.connType = connType;
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
