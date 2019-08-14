package com.tecsoon.www.dao.entity;

import java.io.Serializable;

public class ChartSettingEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1540970665042943802L;
	
	private String templateId;
	private String userId;
	private String chartType1;
	private String chartType2;
	private String chartType3;
	private String chartType4;
	private String chartType5;
	private String datasourceType1;
	private String datasourceType2;
	private String datasourceType3;
	private String datasourceType4;
	private String datasourceType5;
	private String chartTitle1;
	private String chartTitle2;
	private String chartTitle3;
	private String chartTitle4;
	private String chartTitle5;
	private String chartColor1;
	private String chartColor2;
	private String chartColor3;
	private String chartColor4;
	private String chartColor5;
	
	public ChartSettingEntity() {
	}

	public ChartSettingEntity(String templateId, String userId, String chartType1, String chartType2, String chartType3,
			String chartType4, String chartType5, String datasourceType1, String datasourceType2,
			String datasourceType3, String datasourceType4, String datasourceType5, String chartTitle1,
			String chartTitle2, String chartTitle3, String chartTitle4, String chartTitle5, String chartColor1,
			String chartColor2, String chartColor3, String chartColor4, String chartColor5) {
		super();
		this.templateId = templateId;
		this.userId = userId;
		this.chartType1 = chartType1;
		this.chartType2 = chartType2;
		this.chartType3 = chartType3;
		this.chartType4 = chartType4;
		this.chartType5 = chartType5;
		this.datasourceType1 = datasourceType1;
		this.datasourceType2 = datasourceType2;
		this.datasourceType3 = datasourceType3;
		this.datasourceType4 = datasourceType4;
		this.datasourceType5 = datasourceType5;
		this.chartTitle1 = chartTitle1;
		this.chartTitle2 = chartTitle2;
		this.chartTitle3 = chartTitle3;
		this.chartTitle4 = chartTitle4;
		this.chartTitle5 = chartTitle5;
		this.chartColor1 = chartColor1;
		this.chartColor2 = chartColor2;
		this.chartColor3 = chartColor3;
		this.chartColor4 = chartColor4;
		this.chartColor5 = chartColor5;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChartType1() {
		return chartType1;
	}

	public void setChartType1(String chartType1) {
		this.chartType1 = chartType1;
	}

	public String getChartType2() {
		return chartType2;
	}

	public void setChartType2(String chartType2) {
		this.chartType2 = chartType2;
	}

	public String getChartType3() {
		return chartType3;
	}

	public void setChartType3(String chartType3) {
		this.chartType3 = chartType3;
	}

	public String getChartType4() {
		return chartType4;
	}

	public void setChartType4(String chartType4) {
		this.chartType4 = chartType4;
	}

	public String getChartType5() {
		return chartType5;
	}

	public void setChartType5(String chartType5) {
		this.chartType5 = chartType5;
	}

	public String getDatasourceType1() {
		return datasourceType1;
	}

	public void setDatasourceType1(String datasourceType1) {
		this.datasourceType1 = datasourceType1;
	}

	public String getDatasourceType2() {
		return datasourceType2;
	}

	public void setDatasourceType2(String datasourceType2) {
		this.datasourceType2 = datasourceType2;
	}

	public String getDatasourceType3() {
		return datasourceType3;
	}

	public void setDatasourceType3(String datasourceType3) {
		this.datasourceType3 = datasourceType3;
	}

	public String getDatasourceType4() {
		return datasourceType4;
	}

	public void setDatasourceType4(String datasourceType4) {
		this.datasourceType4 = datasourceType4;
	}

	public String getDatasourceType5() {
		return datasourceType5;
	}

	public void setDatasourceType5(String datasourceType5) {
		this.datasourceType5 = datasourceType5;
	}

	public String getChartTitle1() {
		return chartTitle1;
	}

	public void setChartTitle1(String chartTitle1) {
		this.chartTitle1 = chartTitle1;
	}

	public String getChartTitle2() {
		return chartTitle2;
	}

	public void setChartTitle2(String chartTitle2) {
		this.chartTitle2 = chartTitle2;
	}

	public String getChartTitle3() {
		return chartTitle3;
	}

	public void setChartTitle3(String chartTitle3) {
		this.chartTitle3 = chartTitle3;
	}

	public String getChartTitle4() {
		return chartTitle4;
	}

	public void setChartTitle4(String chartTitle4) {
		this.chartTitle4 = chartTitle4;
	}

	public String getChartTitle5() {
		return chartTitle5;
	}

	public void setChartTitle5(String chartTitle5) {
		this.chartTitle5 = chartTitle5;
	}

	public String getChartColor1() {
		return chartColor1;
	}

	public void setChartColor1(String chartColor1) {
		this.chartColor1 = chartColor1;
	}

	public String getChartColor2() {
		return chartColor2;
	}

	public void setChartColor2(String chartColor2) {
		this.chartColor2 = chartColor2;
	}

	public String getChartColor3() {
		return chartColor3;
	}

	public void setChartColor3(String chartColor3) {
		this.chartColor3 = chartColor3;
	}

	public String getChartColor4() {
		return chartColor4;
	}

	public void setChartColor4(String chartColor4) {
		this.chartColor4 = chartColor4;
	}

	public String getChartColor5() {
		return chartColor5;
	}

	public void setChartColor5(String chartColor5) {
		this.chartColor5 = chartColor5;
	}
	
}
