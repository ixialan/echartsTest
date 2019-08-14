package com.tecsoon.www.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import net.sf.json.JSONObject;

public class RandomAction1 extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(RandomAction1.class);
	private String keyName;
	private String result;
	private HttpServletRequest request;
	
	
	private Map<String, Object> session = null;

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}

	private static Map<String, Integer> selMap = new HashMap<String, Integer>();
	static {
		selMap.put("1", 10);
		selMap.put("2", 50);
		selMap.put("3", 100);
	}

	@Override
	public String execute() throws Exception {
		/*
		 * logger.info(this.getClass() + ":execute() method start!");
		 * Map<String,Integer>map=new HashMap<String,Integer>();
		 * map.put("ranNum",ranNum); service.getRandom(map);
		 */
		logger.info(this.getClass() + ":execute() method start!");
		// ranNum=Math.random()*100 ;
		JSONObject js = JSONObject.fromObject(keyName);
		String tName = "";
		if (js != null) {
			tName = (String) js.get("cname");
		}
		int num = selMap.get(tName);
		Random r = new Random();
		int mul = r.nextInt(num);
		session.put("random number", mul);
		logger.info(this.getClass() + ":execute() method end!");
		return SUCCESS;

	}

	

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

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.setRequest(req);
		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
