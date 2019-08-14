package com.tecsoon.www.service;

import java.util.List;
import java.util.Map;

import com.tecsoon.www.dao.entity.UviewEntity;

public interface ArchService {

	public List<UviewEntity> archMap(Map<String,String>map);
}
