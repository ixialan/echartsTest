/**
 * 
 */
package com.tecsoon.www.service;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.ChartSettingEntity;

/**
 * @author ZEROONE
 *
 */
@Service 
public interface ChartSettingDao {
    public ChartSettingEntity getChartSettingInfoById(String userId);
    
    public int saveChartSettingInfo(ChartSettingEntity chartSetEntity);
}
