/**
 * 
 */
package com.tecsoon.www.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.entity.NavigateEntity;

/**
 * @author ZEROONE
 *
 */
@Service 
public interface NavigateDao {
    public List<NavigateEntity> getNavigateAllInfo();
    
    public List<NavigateEntity> getNavigateSubInfo();
}
