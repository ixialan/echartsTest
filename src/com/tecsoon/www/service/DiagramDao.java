/**
 * 
 */
package com.tecsoon.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.DiagramEntity;

/**
 * @author ZEROONE
 *
 */
@Service
public interface DiagramDao {
    public List<DiagramEntity> getDiagramCount();
}
