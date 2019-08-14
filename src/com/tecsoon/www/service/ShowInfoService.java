package com.tecsoon.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.ShowInfoEntity;

@Service 
public interface ShowInfoService {
	
	/**
	 * 根据选择状态显示主页面信息。
	 * @param flg 显示信息状态
	 * @return 显示信息集合
	 */
	public List<ShowInfoEntity> getNavigatPartData(String flg);
}
