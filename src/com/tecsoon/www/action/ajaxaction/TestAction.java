package com.tecsoon.www.action.ajaxaction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;



public class TestAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4210998744701957354L;
	
	private String result;
	private String keyName;

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}


	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public String execute() {
//		JSONObject jo = JSONObject.fromObject(keyName);
//		String cName="";
//		if(jo !=null) {
//			cName=(String) jo.get("cname");
//		}
//		result=cName;
		result="明天会更好";
		
		return SUCCESS;
		
	}

}
