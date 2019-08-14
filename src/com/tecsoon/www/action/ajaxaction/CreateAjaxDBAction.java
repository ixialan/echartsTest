package com.tecsoon.www.action.ajaxaction;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.service.MyService1;

import net.sf.json.JSONObject;

public class CreateAjaxDBAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 494688328174439597L;

	private Logger logger = LoggerFactory.getLogger(CreateAjaxDBAction.class);
	
	private HttpServletRequest request;
	
	 /**
     * 存储随机数用Session。
     */
    private Map<String, Object> session;
    
    @Autowired
    private MyService1 myService;
	
	private String typeName;
	
	private String keyName;
	
	private String result;
	
	private static Map<String, Integer> setLeveMap = new HashMap<String, Integer>();
	static {
		setLeveMap.put("1", 10);
		setLeveMap.put("2", 50);
		setLeveMap.put("3", 100);
	}

	//----------------Function-----------------------------
	
	/**
     * 处理AJAX请求
     * @return SUCCESS
     */
    public String ajaxQuery() {
    	
    	logger.info(this.getClass() + ":ajaxQuery() method start!");
    	
		JSONObject cName = JSONObject.fromObject(keyName);
		String tName = "";
		if (cName != null) {
			tName = (String) cName.get("cname");
		}
		
		int mul = setLeveMap.get(tName);
		
		Random r = new Random();  
		
		int num = r.nextInt(mul);
		
		String dbNum = myService.readRandomNum();
		 
		Map<String, String> map = new HashMap<String, String>();
		map.put("uview_id", "random_numbers");
		map.put("uview_no", String.valueOf(num));
		
		int updateNum = 0;
		
		if (dbNum != null && 0 < dbNum.length()) {
			updateNum = myService.updateRandomNum(map);
		} else {
			updateNum = myService.saveRandomNum(map);
		}
		
		if (updateNum == 0) {
			return INPUT;
		}
		
		result = tName+"今天天气不错！";
		
        logger.info(this.getClass() + ":ajaxQuery() method end!");
        
        return SUCCESS;
    }
    
    //----------------get & set-----------------------------
    
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.request = req;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	
    
}
