package com.tecsoon.www.dao.daoimpl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.MyDao1;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class MyDaoImpl1 implements MyDao1 {
	
	@Autowired
	private SQLFactoryService sqlFactory;

	@Override
	public List<SysUserEntity> getUserList(Map<String, String> map) {
		
		List<SysUserEntity> sysUserList = null;
		
		sysUserList = sqlFactory.getSqlSessionTemplate().selectList("MY_SQL_ID", map);
		
		return sysUserList;
	}

	@Override
	public int saveNum2db(Map<String, String> map) {
		int num = sqlFactory.getSqlSessionTemplate().insert("SAVE_RANDOM_SQL_ID", map);
		return num;
	}

	@Override
	public String readNumFromdb() {
		 String readNum = sqlFactory.getSqlSessionTemplate().selectOne("READ_RANDOM_SQL_ID");
		return readNum;
	}

	@Override
	public int updateNum2db(Map<String, String> map) {
		int num = sqlFactory.getSqlSessionTemplate().update("UPDATE_RANDOM_SQL_ID", map);
		return num;
	}
	
}

