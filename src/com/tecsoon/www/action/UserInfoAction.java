/**
 * 
 */
package com.tecsoon.www.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.SysUserEntity;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoon-userinfo") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class UserInfoAction extends ActionSupport implements SessionAware {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4125887846818610327L;

	private Logger logger = LoggerFactory.getLogger(UserInfoAction.class);

    /**
     * 存储用户登录信息用Session。
     */
    private Map<String, Object> session;
    
    /**
     * 用户信息类。
     */
    private SysUserEntity userInfo;
    
	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String execute() {

		logger.info(this.getClass() + ":execute() method start!");
		
		try {
			
			if (session.get("user") != null) {
				userInfo = (SysUserEntity) session.get("user");
			}

			if (userInfo == null) {
				return INPUT;
			}

		} catch (Exception e) {
			
			e.printStackTrace();
			
			// 发生异常提示信息
			logger.debug(e.getMessage());
			throw e;
		}

		logger.info(this.getClass() + ":execute() method end!");

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
