package com.tecsoon.www.dao.daoimpl;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.RandomDao;
import com.tecsoon.www.factory.SQLFactoryService;
@Repository
public class RandomDaoImpl implements RandomDao {
	@Autowired
	private SQLFactoryService sqlFactory;
	@Override
	public Random getRandom(Map<String, Integer> map) {
		Random num = null;
		// TODO Auto-generated method stub
		num = (Random) sqlFactory.getSqlSessionTemplate().selectList("TECSOON_ARCH_ALL", map);
		//return null;
		return num;
		
	}

}
