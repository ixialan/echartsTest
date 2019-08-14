package com.tecsoon.www.factory;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SQLFactoryService {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionTemplate sqlSessionTemplate;

	/**  
	 * 获取sqlSessionTemplate  
	 * @return sqlSessionTemplate sqlSessionTemplate  
	 */
	public SqlSessionTemplate getSqlSessionTemplate() {
		if (sqlSessionTemplate == null) {
			sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
		}
		return sqlSessionTemplate;
	}
}
