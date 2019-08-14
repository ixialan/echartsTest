package com.tecsoon.www.dao.daoimpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.MyDao;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class MyDaoImpl implements MyDao {
	
	@Autowired
	private SQLFactoryService sqlFactory;
	
	/**
	 * 查询数据库中所有用户信息。
	 * @return 用户信息集合
	 */
	//@Override
	//public List<SysUserEntity> getUserEntityList(String ) {
		//List<SysUserEntity> userEntityList = null;
		//userEntityList = sqlFactory.getSqlSessionTemplate().selectList("TECSOON_LOGIN_ALL2", str);
		//return userEntityList;


	@Override
	public List<SysUserEntity> getUserList(Map<String, String> map) {
		List<SysUserEntity> userEntityList = null;
		// TODO Auto-generated method stub
		userEntityList = sqlFactory.getSqlSessionTemplate().selectList("TECSOON_LOGIN_ALL2", map);
		//return null;
		return userEntityList;
	}
}

