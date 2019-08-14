package com.tecsoon.www.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.GetInfoDao;
import com.tecsoon.www.dao.entity.ShowInfoEntity;
import com.tecsoon.www.service.ShowInfoService;

@Service
public class ShowInfoServiceImpl implements ShowInfoService {

	@Resource
	private GetInfoDao getInfoDao;
	
	/**
	 * 取得所有主页面显示信息。
	 * @return 主页面显示信息集合
	 */
	@Override
	public List<ShowInfoEntity> getNavigatPartData(String flg) {
		
		List<ShowInfoEntity> selfShowInfoList = new ArrayList<ShowInfoEntity>();
		List<ShowInfoEntity> biudShowInfoListb = new ArrayList<ShowInfoEntity>();
		
		List<ShowInfoEntity> infoEntityList = getInfoDao.getAllShowInfoEntity();
				
		for (ShowInfoEntity showInfoEntity : infoEntityList) {
			
			// 自建区域显示数据
			if ("B".equals(showInfoEntity.getInfoFlg())) {
				biudShowInfoListb.add(showInfoEntity);
				
				// 共享区域显示数据
			} else if ("S".equals(showInfoEntity.getInfoFlg())) {
				selfShowInfoList.add(showInfoEntity);
			}
		}
		
		if ("B".equals(flg)) {
			return biudShowInfoListb;
		} else if ("S".equals(flg)) {
			return selfShowInfoList;
		}
		
		return null;
	}

}

