package com.project.framework.rest.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.project.framework.rest.api.service.RafApiService;

@RestController
@RequestMapping(path = "/api")
public class RafApiController {
	
	private static final Logger logger = LoggerFactory.getLogger(RafApiController.class);
	
	@Resource(name = "RafApiService")
	private RafApiService rafApiService;
	/**
	 * 목록 조회 API
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public Object getApi(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		logger.info("GET /api");
		
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> resultMap = rafApiService.selectDualTable(paramMap);
		
		logger.info("결과 : " + resultMap);
		
		res.setStatus(HttpStatus.OK.value());
		
		return resultMap;
	}
	
	/**
	 * 상세 조회 API
	 * @param req
	 * @param res
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = "/{param}")
	public Object getApiParam(HttpServletRequest req, HttpServletResponse res,
							  @PathVariable(name = "param") String param) throws Exception 
	{
		logger.info("GET /api/:param");
		logger.info("Parameter : {}", param);
		
		Map<String, String> paramMap = new HashMap<String, String>();
		Map<String, Object> respMap = new HashMap<String, Object>();
		Map<String, Object> resultMap = rafApiService.selectDualTable(paramMap);

		logger.info("결과 : " + resultMap);
		
		respMap.put("result_map", resultMap);
		respMap.put("param", param);
		
		res.setStatus(HttpStatus.OK.value());
		
		return respMap;
	}
	
	/**
	 * 등록 API
	 * @param req
	 * @param res
	 * @param param1
	 * @param param2
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public Object postApi(HttpServletRequest req, HttpServletResponse res,
						  @RequestPart(name = "param1", required = true) String param1,
						  @RequestPart(name = "param2", required = true) String param2) throws Exception
	{
		logger.info("POST /api");
		logger.info("Form 데이터 : {}, {}", param1, param2);
		
		Map<String, Object> respMap = new HashMap<String, Object>();
		
		respMap.put("param1", param1);
		respMap.put("param2", param2);
		
		res.setStatus(HttpStatus.CREATED.value());
		
		return respMap;
	}
	
	/**
	 * 수정 API
	 * @param req
	 * @param res
	 * @param param
	 * @param param1
	 * @param param2
	 * @return
	 * @throws Exception
	 */
	@PutMapping(path = "/{param}")
	public Object putApi(HttpServletRequest req, HttpServletResponse res,
						 @PathVariable(name = "param") String param,
						 @RequestPart(name = "param1", required = true) String param1,
						 @RequestPart(name = "param2", required = true) String param2) throws Exception
	{
		logger.info("PUT /api");
		logger.info("Parameter : {}", param);
		logger.info("Form 데이터 : {}, {}", param1, param2);
		
		Map<String, Object> respMap = new HashMap<String, Object>();
		
		respMap.put("param", param);
		respMap.put("param1", param1);
		respMap.put("param2", param2);
		
		res.setStatus(HttpStatus.OK.value());
		
		return respMap;
	}
	
	/**
	 * 삭제 API
	 * @param req
	 * @param res
	 * @param param
	 * @param param1
	 * @param param2
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(path = "/{param}")
	public Object deleteApi(HttpServletRequest req, HttpServletResponse res,
			 				@PathVariable(name = "param") String param) throws Exception
	{
		logger.info("DELETE /api");
		logger.info("Parameter : {}", param);
		
		Map<String, Object> respMap = new HashMap<String, Object>();
		
		respMap.put("param", param);
		
		res.setStatus(HttpStatus.OK.value());
		
		return respMap;
	}
}
