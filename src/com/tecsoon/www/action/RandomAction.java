package com.tecsoon.www.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;

public class RandomAction extends ActionSupport implements ServletRequestAware,SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String keyName;
	private String result;
	private HttpServletRequest request;
	
	private Map<String, Object> session = new HashMap<String, Object>();

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public String execute() throws Exception {
		JSONObject js = JSONObject.fromObject(keyName);
		String tName = "";
		if (js != null) {
			tName = (String) js.get("cname");
		} else {
			return INPUT;
		}
		int keyNum = Integer.parseInt(tName);
		int ranNum = (int) session.get("random number");
		if (keyNum > ranNum) {
			result = "您猜的数字大了！";
		} else if (keyNum < ranNum) {
			result = "您猜的数字小了！";
		} else {
			result = "您猜对了!";
		}
		if (keyNum == 0) {
			result = "";
		}

		return SUCCESS;

	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getGuessName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request=req;
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
