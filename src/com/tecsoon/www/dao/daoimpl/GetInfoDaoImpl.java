package com.tecsoon.www.dao.daoimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tecsoon.www.common.constant.TecsoonConstants;
import com.tecsoon.www.dao.GetInfoDao;
import com.tecsoon.www.dao.entity.ShowInfoEntity;
import com.tecsoon.www.factory.SQLFactoryService;

@Repository
public class GetInfoDaoImpl implements GetInfoDao {
	
	@Autowired
	private SQLFactoryService sqlFactoryService;
	
	/**
	 * 取得所有主页面显示信息。
	 * @return 主页面显示信息集合
	 */
	@Override
	public List<ShowInfoEntity> getAllShowInfoEntity() {
		List<ShowInfoEntity> showInfoEntityList = null;
		showInfoEntityList = sqlFactoryService.getSqlSessionTemplate().selectList(TecsoonConstants.TECSOON_ALL_SHOWINFO);
		return showInfoEntityList;
	}

}

