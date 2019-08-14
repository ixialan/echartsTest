package com.tecsoon.www.dao;

import java.util.List;

import com.tecsoon.www.dao.entity.ShowInfoEntity;

public interface GetInfoDao {
	
	/**
	 * 取得所有主页面显示信息。
	 * @return 主页面显示信息集合
	 */
	public List<ShowInfoEntity> getAllShowInfoEntity();
}
