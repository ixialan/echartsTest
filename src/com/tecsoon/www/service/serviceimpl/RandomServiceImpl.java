package com.tecsoon.www.service.serviceimpl;

import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import com.tecsoon.www.dao.RandomDao;
import com.tecsoon.www.service.RandomService;

public class RandomServiceImpl implements RandomService {
	@Resource
	private RandomDao randomDao;
	@Override
	public Random getRandom(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return randomDao.getRandom(map);
	}

}
