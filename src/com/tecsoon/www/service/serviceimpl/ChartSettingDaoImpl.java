/**
 * 
 */
package com.tecsoon.www.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsoon.www.common.constant.TecsoonConstants;
import com.tecsoon.www.dao.entity.ChartSettingEntity;
import com.tecsoon.www.factory.SQLFactoryService;
import com.tecsoon.www.service.ChartSettingDao;

/**
 * @author ZEROONE
 *
 */
@Service
public class ChartSettingDaoImpl implements ChartSettingDao {
	
	@Autowired
	private SQLFactoryService sqlFactory;

	@Override
	public ChartSettingEntity getChartSettingInfoById(String userId) {
		ChartSettingEntity chartSetting = null;
		chartSetting = sqlFactory.getSqlSessionTemplate().selectOne(TecsoonConstants.SELECT_CHART_SETTING_INFO, userId);
		return chartSetting;
	}

	@Override
	public int saveChartSettingInfo(ChartSettingEntity chartSetEntity) {
		int res = 0;
		if (chartSetEntity != null) {
			res = sqlFactory.getSqlSessionTemplate().insert(TecsoonConstants.SAVE_CHART_SETTING_INFO, chartSetEntity);
		}
		return res;
	}
}
