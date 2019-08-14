package com.tecsoon.www.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.MyDao1;
import com.tecsoon.www.dao.entity.SysUserEntity;
import com.tecsoon.www.service.MyService1;

@Service
public class MyServiceImpl1 implements MyService1 {
	
	@Resource
	private MyDao1 myDao;

	@Override
	public boolean isLoginSuccessMap(Map<String, String> map) {
		
		List<SysUserEntity> sysUserList = myDao.getUserList(map);
		
		if (sysUserList != null && sysUserList.size() != 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public int saveRandomNum(Map<String, String> map) {
		int num = myDao.saveNum2db(map);
		return num;
	}

	@Override
	public String readRandomNum() {
		String numStr = myDao.readNumFromdb();
		return numStr;
	}

	@Override
	public int updateRandomNum(Map<String, String> map) {
		int num = myDao.updateNum2db(map);
		return num;
	}
}

