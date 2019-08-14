package com.tecsoon.www.action.ajaxaction;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class TestAction2 extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2400323367656930738L;
	private String keyName;
	private String result;
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute() {
		JSONObject su =JSONObject.fromObject(keyName);
		String cName="";
		if(su!=null) {
			cName=(String)su.get("cname");
			
		}
		result=cName;
		return SUCCESS;
	}

}
