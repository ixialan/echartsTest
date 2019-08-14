package com.tecsoon.www.action.ajaxaction;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import net.sf.json.JSONObject;

public class GuessAjaxAction extends ActionSupport implements ServletRequestAware, SessionAware {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 4681503001658032418L;

	private Logger logger = LoggerFactory.getLogger(GuessAjaxAction.class);
	
	private HttpServletRequest request;
	
	 /**
     * 存储随机数用Session。
     */
    private Map<String, Object> session;
	
	private String typeName;
	
	private String keyName;
	
	private String result;

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
		
		// 从session中读取保存的随机数
		int randomNum = (int) session.get("my_random_num");
		
		if (guessNum < randomNum) {
			result = "您猜的数字太小了！";
		} else if (randomNum < guessNum) {
			result = "您猜的数字太大了！";
		} else {
			result = "恭喜您才对了！";
		}
		if(guessNum==0) {
			
				result=" ";
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
