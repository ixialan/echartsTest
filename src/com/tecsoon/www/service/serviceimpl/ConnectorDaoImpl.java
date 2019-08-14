/**
 * 
 */
package com.tecsoon.www.service.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsoon.www.common.constant.TecsoonConstants;
import com.tecsoon.www.dao.entity.ConnectorEntity;
import com.tecsoon.www.factory.SQLFactoryService;
import com.tecsoon.www.service.ConnectorDao;

/**
 * @author ZEROONE
 *
 */
@Service
public class ConnectorDaoImpl implements ConnectorDao {
	
	@Autowired
	private SQLFactoryService sqlFactory;

	@Override
	public List<ConnectorEntity> getConnectorInfo() {
		List<ConnectorEntity> connectorList = null;
		connectorList = sqlFactory.getSqlSessionTemplate().selectList(TecsoonConstants.TECSOON_CONNECTOR_COUNT);
		return connectorList;
	}

}
