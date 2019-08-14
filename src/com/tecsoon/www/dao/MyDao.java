package com.tecsoon.www.dao;

import java.util.List;
import java.util.Map;

import com.tecsoon.www.dao.entity.SysUserEntity;

public interface MyDao {
	
	/**
	 * 查询数据库中所有用户信息。
	 * @return 用户信息集合
	 */
	public List<SysUserEntity> getUserList(Map<String,String>map);
}