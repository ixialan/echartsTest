package com.tecsoon.www.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service 
public interface MyService {
	
	/**
	 * 根据用户名和密码判定用户是否合法。
	 * @param entity 用户信息
	 * @return 用户判定状态信息
	 */
	public boolean isLoginSuccessMap(Map<String,String>map);
}
