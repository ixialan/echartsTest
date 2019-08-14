package com.tecsoon.www.dao.entity;

import java.io.Serializable;

public class ChartSettingParam implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8822243977251227596L;
	
	private String templateId;
	private String chartType;
	private String userId;
	private String chartTitle;
	private String chartColor;
	private String datasourceType;
	
	public ChartSettingParam() {
	}
	
	public ChartSettingParam(String templateId, String chartType, String userId, String chartTitle, String chartColor,
			String datasourceType) {
		super();
		this.templateId = templateId;
		this.chartType = chartType;
		this.userId = userId;
		this.chartTitle = chartTitle;
		this.chartColor = chartColor;
		this.datasourceType = datasourceType;
	}
	
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChartTitle() {
		return chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}
	public String getChartColor() {
		return chartColor;
	}
	public void setChartColor(String chartColor) {
		this.chartColor = chartColor;
	}
	public String getDatasourceType() {
		return datasourceType;
	}
	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}
}
