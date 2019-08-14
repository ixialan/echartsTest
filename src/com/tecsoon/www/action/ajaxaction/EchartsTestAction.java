package com.tecsoon.www.action.ajaxaction;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class EchartsTestAction extends ActionSupport {

	/**
	 * 
	 * 
	 */
	private String result;
	private HttpServletRequest request;
	
	private static final long serialVersionUID = -5526984737031406704L;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String execute() {
		
		return SUCCESS;
	}

}
