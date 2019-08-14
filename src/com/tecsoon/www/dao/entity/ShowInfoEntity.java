package com.tecsoon.www.dao.entity;

import java.io.Serializable;

/**
 * @author XXX
 * @version 0.1
 */
public class ShowInfoEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1078984466218300467L;

	private Integer infoId;
	
	private String shareInfo;
	
	private String selfBuildInfo;
	
	private String infoFlg;
	
	public String getInfoFlg() {
		return infoFlg;
	}

	public void setInfoFlg(String infoFlg) {
		this.infoFlg = infoFlg;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getShareInfo() {
		return shareInfo;
	}

	public void setShareInfo(String shareInfo) {
		this.shareInfo = shareInfo;
	}

	public String getSelfBuildInfo() {
		return selfBuildInfo;
	}

	public void setSelfBuildInfo(String selfBuildInfo) {
		this.selfBuildInfo = selfBuildInfo;
	}
	
	

}
