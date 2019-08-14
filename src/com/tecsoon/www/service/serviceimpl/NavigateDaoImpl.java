/**
 * 
 */
package com.tecsoon.www.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsoon.www.common.constant.TecsoonConstants;
import com.tecsoon.www.dao.entity.NavigateEntity;
import com.tecsoon.www.factory.SQLFactoryService;
import com.tecsoon.www.service.NavigateDao;

/**
 * @author ZEROONE
 *
 */
@Service
public class NavigateDaoImpl implements NavigateDao {
	
	@Autowired
	private SQLFactoryService sqlFactory;

	@Override
	public List<NavigateEntity> getNavigateAllInfo() {
		List<NavigateEntity> navigateList = null;
		navigateList = sqlFactory.getSqlSessionTemplate().selectList(TecsoonConstants.TECSOON_OBJECT_NAVIGATE_ALL);
		return navigateList;
	}

	@Override
	public List<NavigateEntity> getNavigateSubInfo() {
		List<NavigateEntity> navigateList = null;
		navigateList = sqlFactory.getSqlSessionTemplate().selectList(TecsoonConstants.TECSOON_OBJECT_NAVIGATE_SUB);
		return navigateList;
	}
	

}
