package com.tecsoon.www.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.MyDao;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.service.MyService;

@Service
public class MyServiceImpl implements  MyService {
	
	@Resource
	private MyDao myDao;

	@Override
	public boolean isLoginSuccessMap(Map<String, String> map) {

		List<SysUserEntity> sysUserList = myDao.getUserList(map);
		
		if(sysUserList != null && sysUserList.size() != 0) {
			return true;
		}

		return false;
	}


}

