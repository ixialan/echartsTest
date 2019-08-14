package com.tecsoon.www.vo;

import java.io.Serializable;

/**
 * User实体类
 * @author XXX
 */
public class UserInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4675675875453372533L;

	private Integer userId;

	private String userName;

	private String userPass;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}