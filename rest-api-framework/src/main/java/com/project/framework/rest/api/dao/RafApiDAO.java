package com.project.framework.rest.api.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RafApiDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, Object> selectDualTable(Map<String, String> paramMap) throws SQLException {
		return (Map<String, Object>) sqlSession.selectOne("ApiDAO.selectDualTable", paramMap);
	}
}
