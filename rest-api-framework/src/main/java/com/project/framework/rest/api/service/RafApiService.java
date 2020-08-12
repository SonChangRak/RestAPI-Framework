package com.project.framework.rest.api.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

public interface RafApiService {
	
	@Transactional
	public Map<String, Object> selectDualTable(Map<String, String> paramMap) throws SQLException;
}
