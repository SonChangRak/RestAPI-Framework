package com.project.framework.rest.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.framework.rest.api.service.RafApiService;

@RestController
@RequestMapping(path = "/api")
public class RafApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(RafApiController.class);
	
	@Resource(name = "RafApiService")
	private RafApiService rafApiService;
	
	@GetMapping(path = "/")
	public Object getApi(HttpServletRequest request) throws Exception 
	{
		logger.info("GET /api/");
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> resultMap = rafApiService.selectDualTable(paramMap);
		
		logger.info("결과 : " + resultMap);
		
		return resultMap;
	}
}
