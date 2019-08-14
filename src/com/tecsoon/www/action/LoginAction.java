package com.tecsoon.www.action;

// 没有用到的引用要消除，类中不能出现空引用警告及其他警告提示。
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.ShowInfoEntity;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.service.LoginService;
import com.tecsoon.www.service.ShowInfoService;
import com.tecsoon.www.vo.Sys_user;


@Scope("request")
@Controller("bigdata-loginAction") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class LoginAction extends ActionSupport implements SessionAware {

	//创建日志对象  
	private Logger logger = LoggerFactory.getLogger(LoginAction.class);
    
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 7433171462281769202L;
    
    /**
     * 用户登录提示信息。
     */
    private String message = StringUtils.EMPTY;
    
    /**
     * 主页面信息取得Service。
     */
    @Autowired
    private ShowInfoService showInfoService = null;
    
    /**
     * 登录信息取得Service。
     */
    @Autowired
    private LoginService service = null;
    
    /**
     * 主页面显示信息。
     */
    private List<ShowInfoEntity> infoEntityList = null;
    
    /**
     * 存储用户登录信息用Session。
     */
    private Map<String, Object> session = null;
    
    /**
     * 用户信息类。
     */
    private Sys_user sys_user = null;

	/**
     * 登录状态。
     */
    private boolean isCrr = false;
    
    /**
     * 继承SessionAware接口重写的方法。
     */
	@Override
	public void setSession(Map<String, Object> sessionAttibutes) {
		this.session = sessionAttibutes;
	}
	
	/**
	 * Action执行的主方法。
	 */
    public String execute() throws Exception{
    	
    	logger.info(this.getClass() + ":execute() method start!");
    	
    	 if (StringUtils.isBlank(sys_user.getUser_nm())) {
         	this.message = this.getText("error.username.null");
         	return INPUT;
         } else {
         	
         	// 用户名以大写或小写字母开头，允许有数字和_，不能小于3位并且大于20位
         	if (!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_]{2,20}$", sys_user.getUser_nm())) {
         		this.message = this.getText("error.login.username.match");
         		return INPUT;
         	}
         }
    	 
    	 if (StringUtils.isBlank(sys_user.getPassword())) {
          	this.message = this.getText("error.userpass.null");
          	return INPUT;
          } else {
          	
          	// 用户密码以大写或小写字母开头，允许有数字和_以及【!，@，#，$，%，^，&，*，(，)】特殊字符，不能小于3位并且大于20位
          	if (!Pattern.matches("^[a-zA-Z][a-zA-Z0-9_!@#$%^&*()]{2,20}$", sys_user.getPassword())) {
          		this.message = this.getText("error.login.password.match");
          		return INPUT;
          	}
          }
      	 
    	 // 声明DAO层用实体Bean
//         UserEntity entity = new UserEntity();
         String userName = "";
    	 String userPass = "";
         try {
        	 
        	 logger.info(this.getClass() + ":Bean拷贝开始!");

        	 // 实现两个Bean的拷贝
//        	 BeanUtilsExtends.copyProperties(entity, userInfo);
        	 
        	 userName = sys_user.getUser_nm();
        	 userPass = sys_user.getPassword();
        	 
        	 logger.info(this.getClass() + ":Bean拷贝结束!");
         } catch (Exception ex) {
        	 // TODO
         	logger.error(this.getText("tecsoon.project.IllegalAccess"), ex);
         	return INPUT;
         }
         
         // 用户登录状态
         SysUserEntity userEntity = service.isLoginSuccess(userName, userPass);
         
         // 用户名不正确
         if (userEntity != null) {
         	isCrr = true;
         }
    	
        if (isCrr) {
        	session.put("user", userEntity);
        	logger.info(this.getClass() + ":execute() method end!");
            return SUCCESS;
        }
        
        return INPUT;
    }

	/**  
	 * 获取logger  
	 * @return logger logger  
	 */
	public Logger getLogger() {
		return logger;
	}

	/**  
	 * 设置logger  
	 * @param logger logger  
	 */
	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	/**  
	 * 获取message  
	 * @return message message  
	 */
	public String getMessage() {
		return message;
	}

	/**  
	 * 设置message  
	 * @param message message  
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**  
	 * 获取showInfoService  
	 * @return showInfoService showInfoService  
	 */
	public ShowInfoService getShowInfoService() {
		return showInfoService;
	}

	/**  
	 * 设置showInfoService  
	 * @param showInfoService showInfoService  
	 */
	public void setShowInfoService(ShowInfoService showInfoService) {
		this.showInfoService = showInfoService;
	}

	/**  
	 * 获取service  
	 * @return service service  
	 */
	public LoginService getService() {
		return service;
	}

	/**  
	 * 设置service  
	 * @param service service  
	 */
	public void setService(LoginService service) {
		this.service = service;
	}

	/**  
	 * 获取infoEntityList  
	 * @return infoEntityList infoEntityList  
	 */
	public List<ShowInfoEntity> getInfoEntityList() {
		return infoEntityList;
	}

	/**  
	 * 设置infoEntityList  
	 * @param infoEntityList infoEntityList  
	 */
	public void setInfoEntityList(List<ShowInfoEntity> infoEntityList) {
		this.infoEntityList = infoEntityList;
	}
	
	public Sys_user getSys_user() {
		return sys_user;
	}

	public void setSys_user(Sys_user sys_user) {
		this.sys_user = sys_user;
	}

	/**  
	 * 获取session  
	 * @return session session  
	 */
	public Map<String, Object> getSession() {
		return session;
	}
}

