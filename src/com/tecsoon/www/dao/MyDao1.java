package com.tecsoon.www.dao;

import java.util.List;
import java.util.Map;

import com.tecsoon.www.dao.entity.SysUserEntity;

public interface MyDao1 {
	
	public List<SysUserEntity> getUserList(Map<String, String> map);
	
	public int saveNum2db(Map<String, String> map);
	
	public String readNumFromdb();
	
	public int updateNum2db(Map<String, String> map);
}