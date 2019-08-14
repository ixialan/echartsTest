package com.tecsoon.www.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.QueryAjaxDao;
import com.tecsoon.www.dao.entity.UviewEntity;
import com.tecsoon.www.service.QueryAjaxService;

@Service
public class QueryAjaxServiceImpl implements QueryAjaxService {
	@Resource
	private QueryAjaxDao queryAjaxDao;
	@Override
	public List<UviewEntity> getQueryList() {
		
		List<UviewEntity> list = new ArrayList<UviewEntity>();
		
		List<UviewEntity> queryList = queryAjaxDao.getQueryList();
		if(queryList!=null) {
			list.add(queryList.get(0));
			return list;
		}	
	
		return null;
	}
	
}
