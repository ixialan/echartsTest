/**
 * 
 */
package com.tecsoon.www.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.service.LoginService;
import com.tecsoon.www.vo.Sys_user;

/**
 * @author ZEROONE
 *
 */
@Scope("request")
@Controller("tecsoon-testajax") // 注释类别名，-struts.xml文件中action的class的名称,添加注释后由spring托管创建
public class TestAjaxAction extends ActionSupport implements SessionAware {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 7317301641564699016L;

	private Logger logger = LoggerFactory.getLogger(TestAjaxAction.class);

    /**
     * 存储用户登录信息用Session。
     */
    private Map<String, Object> session;
    
    
    /**
     * 登录信息取得Service。
     */
    @Autowired
    private LoginService service = null;

    /**
     * 用户信息类。
     */
    private Sys_user sys_user = null;

	/**
	 * 处理AJAX请求
	 * @return SUCCESS
	 */
	public String execute() {

		logger.info(this.getClass() + ":execute() method start!");
		
		SysUserEntity sysUserEntity = service.isLoginSuccess2(sys_user.getUser_nm(), sys_user.getPassword());
		if(sysUserEntity==null) {
		return INPUT;
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

	public SysUserEntity isLoginSuccess(String userName, String userPass) {
		return service.isLoginSuccess(userName, userPass);
	}

	public SysUserEntity isLoginSuccess2(String userName, String userPass) {
		return service.isLoginSuccess2(userName, userPass);
	}

	public void setUser_id(String user_id) {
		sys_user.setUser_id(user_id);
	}

	public String getUser_id() {
		return sys_user.getUser_id();
	}

	public void setUser_cd(String user_cd) {
		sys_user.setUser_cd(user_cd);
	}

	public String getUser_cd() {
		return sys_user.getUser_cd();
	}

	public void setUser_nm(String user_nm) {
		sys_user.setUser_nm(user_nm);
	}

	public String getUser_nm() {
		return sys_user.getUser_nm();
	}

	public int hashCode() {
		return sys_user.hashCode();
	}

	public void setUser_role(String user_role) {
		sys_user.setUser_role(user_role);
	}

	public String getUser_role() {
		return sys_user.getUser_role();
	}

	public void setPassword(String password) {
		sys_user.setPassword(password);
	}

	public String getPassword() {
		return sys_user.getPassword();
	}

	public void setReal_nm(String real_nm) {
		sys_user.setReal_nm(real_nm);
	}

	public String getReal_nm() {
		return sys_user.getReal_nm();
	}

	public void setSex(String sex) {
		sys_user.setSex(sex);
	}

	public String getSex() {
		return sys_user.getSex();
	}

	public void setTel(String tel) {
		sys_user.setTel(tel);
	}

	public String getTel() {
		return sys_user.getTel();
	}

	public void setIs_frozen(String is_frozen) {
		sys_user.setIs_frozen(is_frozen);
	}

	public String getIs_frozen() {
		return sys_user.getIs_frozen();
	}

	public void setCreator(String creator) {
		sys_user.setCreator(creator);
	}

	public String getCreator() {
		return sys_user.getCreator();
	}

	public void setCrt_dt(Date crt_dt) {
		sys_user.setCrt_dt(crt_dt);
	}

	public boolean equals(Object obj) {
		return sys_user.equals(obj);
	}

	public Date getCrt_dt() {
		return sys_user.getCrt_dt();
	}

	public void setUpdater(String updater) {
		sys_user.setUpdater(updater);
	}

	public String getUpdater() {
		return sys_user.getUpdater();
	}

	public void setUpdate_dt(Date update_dt) {
		sys_user.setUpdate_dt(update_dt);
	}

	public Date getUpdate_dt() {
		return sys_user.getUpdate_dt();
	}

	public void setRemark(String remark) {
		sys_user.setRemark(remark);
	}

	public String getRemark() {
		return sys_user.getRemark();
	}

	public void setIdentity_flag(String identity_flag) {
		sys_user.setIdentity_flag(identity_flag);
	}

	public String getIdentity_flag() {
		return sys_user.getIdentity_flag();
	}

	public void setEmail(String email) {
		sys_user.setEmail(email);
	}

	public String getEmail() {
		return sys_user.getEmail();
	}

	public void setHttp(String http) {
		sys_user.setHttp(http);
	}

	public String getHttp() {
		return sys_user.getHttp();
	}

	public void setBirth_date(Date birth_date) {
		sys_user.setBirth_date(birth_date);
	}

	public Date getBirth_date() {
		return sys_user.getBirth_date();
	}

	public void setPost(String post) {
		sys_user.setPost(post);
	}

	public String getPost() {
		return sys_user.getPost();
	}

	public void setOrg(String org) {
		sys_user.setOrg(org);
	}

	public String getOrg() {
		return sys_user.getOrg();
	}

	public String toString() {
		return sys_user.toString();
	}
	
}
