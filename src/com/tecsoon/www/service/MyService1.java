package com.tecsoon.www.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service 
public interface MyService1 {
	public boolean isLoginSuccessMap(Map<String, String> map);
	
	public int saveRandomNum(Map<String, String> map);
	
	public String readRandomNum();
	
	public int updateRandomNum(Map<String, String> map);
}
