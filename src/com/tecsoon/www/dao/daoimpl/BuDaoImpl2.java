package com.tecsoon.www.dao.daoimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.Bu;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class BuDaoImpl2 implements Bu {
	
	@Autowired
	private SQLFactoryService sqlFactory;
	
	
	
	
	/**
	 * 查询数据库中所有用户信息。
	 * @return 用户信息集合
	 */
	public List<SysUserEntity> getUserEntityList(String str) {
		List<SysUserEntity> userEntityList = null;
		userEntityList = sqlFactory.getSqlSessionTemplate().selectList("TECSOON_LOGIN_ALL2", str);
		return userEntityList;
		
		
		
		
		
	}
}

