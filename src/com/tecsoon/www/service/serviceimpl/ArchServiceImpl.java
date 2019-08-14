package com.tecsoon.www.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tecsoon.www.dao.ArchDao;
import com.tecsoon.www.dao.entity.UviewEntity;
import com.tecsoon.www.service.ArchService;

@Service
public class ArchServiceImpl implements ArchService {
	@Resource
	private ArchDao archDao;
	@Override
	public List<UviewEntity> archMap(Map<String, String> map) {

		return archDao.getArchList(map);
	}
	

}
