/**
 * 
 */
package com.tecsoon.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.ConnectorEntity;

/**
 * @author ZEROONE
 *
 */
@Service 
public interface ConnectorDao {
    public List<ConnectorEntity> getConnectorInfo();
}
