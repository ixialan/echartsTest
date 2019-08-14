package com.tecsoon.www.dao;

import java.util.List;
import java.util.Map;

import com.tecsoon.www.dao.entity.UviewEntity;

public interface ArchDao {

	List<UviewEntity> getArchList(Map<String, String> map);

}
