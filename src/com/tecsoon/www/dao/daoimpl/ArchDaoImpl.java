package com.tecsoon.www.dao.daoimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.ArchDao;
import com.tecsoon.www.dao.entity.UviewEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class ArchDaoImpl implements ArchDao {
	@Autowired
	private SQLFactoryService sqlFactory;
	@Override
	public List<UviewEntity> getArchList(Map<String, String> map) {
		List<UviewEntity> ArchList = null;
		// TODO Auto-generated method stub
		ArchList = sqlFactory.getSqlSessionTemplate().selectList("TECSOON_ARCH_ALL", map);
		//return null;
		return ArchList;
	}
}
