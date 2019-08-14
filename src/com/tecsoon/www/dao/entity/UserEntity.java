package com.tecsoon.www.dao.entity;

import java.io.Serializable;

/**
 * @author XXX
 * @version 0.1
 */
public class UserEntity implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6580113799841546482L;

	private String userId;
	
	private String userName;
	
	private String userPass;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
