/**
 * 
 */
package com.tecsoon.www.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.service.MyService;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoon-zyt") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class IndexAction extends ActionSupport implements SessionAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4125887846818610327L;

	private Logger logger = LoggerFactory.getLogger(IndexAction.class);

    /**
     * 存储用户登录信息用Session。
     */
    private Map<String, Object> session;
    
    /**
     * 用户信息类。
     */
    private SysUserEntity userInfo;
    
    private String user_nm;
    private String password;
    
    
    @Autowired
    private MyService myService;
    
    
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser_nm() {
		return user_nm;
	}

	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}

	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String execute() {

		logger.info(this.getClass() + ":execute() method start!");
		
		Map<String,String>map=new HashMap<String,String>();
	    map.put("user_nm",user_nm);
	    map.put("password",password);
	    
	    boolean flg=myService.isLoginSuccessMap(map);
	    
	    if(!flg) {
	    	return INPUT;
	    	
	    }
		
		return SUCCESS;

		
	}

		
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}

	public SysUserEntity getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(SysUserEntity userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
