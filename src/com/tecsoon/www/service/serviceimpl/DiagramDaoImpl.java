/**
 * 
 */
package com.tecsoon.www.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsoon.www.common.constant.TecsoonConstants;
import com.tecsoon.www.dao.entity.DiagramEntity;
import com.tecsoon.www.factory.SQLFactoryService;
import com.tecsoon.www.service.DiagramDao;

/**
 * @author ZEROONE
 *
 */
@Service
public class DiagramDaoImpl implements DiagramDao {
	
	@Autowired
	private SQLFactoryService sqlFactory;
	
	/**
	 * 查询数据库中所有用户信息。
	 * @return 用户信息集合
	 */
	@Override
	public List<DiagramEntity> getDiagramCount() {
		List<DiagramEntity> diagramList = null;
		diagramList = sqlFactory.getSqlSessionTemplate().selectList(TecsoonConstants.TECSOON_DIAGRAM_COUNT);
		return diagramList;
	}

}
