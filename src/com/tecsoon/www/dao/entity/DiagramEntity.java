/**
 * 
 */
package com.tecsoon.www.dao.entity;

import java.io.Serializable;

/**
 * @author ZEROONE
 *
 */
public class DiagramEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8781873572175665594L;
	
	private String diagramName;
	private String diagramType;
	private String nums;
	
	public DiagramEntity() {}
	
	/**
	 * @param diagramName
	 * @param diagramType
	 * @param nums
	 */
	public DiagramEntity(String diagramName, String diagramType, String nums) {
		this.diagramName = diagramName;
		this.diagramType = diagramType;
		this.nums = nums;
	}
	/**  
	 * 获取diagramName  
	 * @return diagramName diagramName  
	 */
	public String getDiagramName() {
		return diagramName;
	}
	/**  
	 * 设置diagramName  
	 * @param diagramName diagramName  
	 */
	public void setDiagramName(String diagramName) {
		this.diagramName = diagramName;
	}
	/**  
	 * 获取diagramType  
	 * @return diagramType diagramType  
	 */
	public String getDiagramType() {
		return diagramType;
	}
	/**  
	 * 设置diagramType  
	 * @param diagramType diagramType  
	 */
	public void setDiagramType(String diagramType) {
		this.diagramType = diagramType;
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
