package com.tecsoon.www.service;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.SysUserEntity;

@Service 
public interface LoginService3 {
	
	/**
	 * 根据用户名和密码判定用户是否合法。
	 * @param entity 用户信息
	 * @return 用户判定状态信息
	 */
	public SysUserEntity isLoginSuccess(String userName, String userPass);
	
	public SysUserEntity isLoginSuccess2(String userName, String userPass);
	
}
