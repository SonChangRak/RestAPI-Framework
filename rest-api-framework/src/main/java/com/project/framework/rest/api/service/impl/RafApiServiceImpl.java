package com.project.framework.rest.api.service.impl;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.framework.rest.api.dao.RafApiDAO;
import com.project.framework.rest.api.service.RafApiService;

@Service("RafApiService")
public class RafApiServiceImpl implements RafApiService {

	@Autowired
	private RafApiDAO dao;

	@Override
	public Map<String, Object> selectDualTable(Map<String, String> paramMap) throws SQLException {
		return dao.selectDualTable(paramMap);
	}
}
