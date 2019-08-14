package com.tecsoon.www.action.ajaxaction;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.service.MyService1;

import net.sf.json.JSONObject;

public class GuessAjaxDBAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 4681503001658032418L;

	private Logger logger = LoggerFactory.getLogger(GuessAjaxDBAction.class);
	
	private HttpServletRequest request;
	
	 /**
     * 存储随机数用Session。
     */
    private Map<String, Object> session;
	
	private String typeName;
	
	private String keyName;
	
	private String result;
	
	@Autowired
    private MyService1 myService;

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
		} else {
			return INPUT;
		}
		
		// 获得页面输入值
		int guessNum = Integer.parseInt(tName);
		
		// 读取保存到数据库中的随机数
		String randomNumStr = myService.readRandomNum();
		
		int randomNum = 0;
		
		if (randomNumStr != null && 0 < randomNumStr.length()) {
			randomNum = Integer.parseInt(randomNumStr);
		} else {
			result = "产生随机数出错！";
		}
		
		if (guessNum < randomNum) {
			result = "您猜的数字太小了！";
		} else if (randomNum < guessNum) {
			result = "您猜的数字太大了！";
		} else {
			result = "恭喜您才对了！";
		}
		
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
