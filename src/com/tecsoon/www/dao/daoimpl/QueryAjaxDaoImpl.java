package com.tecsoon.www.dao.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.dao.QueryAjaxDao;
import com.tecsoon.www.dao.entity.UviewEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class QueryAjaxDaoImpl implements QueryAjaxDao{
	@Autowired
	private SQLFactoryService sqlFactory;
	@Override
	public List<UviewEntity> getQueryList() {
		List<UviewEntity> QueryList = null;
		QueryList = sqlFactory.getSqlSessionTemplate().selectList("TECSOON_ARCH_CON");
		return QueryList;
	}

}
