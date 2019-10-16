package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DemoApplication;
import com.example.demo.service.RemoteApiServiceIvokation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LocalApi {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LocalApi.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RemoteApiServiceIvokation service;
	
	@RequestMapping(value="/restapi/{pagenum}/{pagesize}",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> callRemoteApi(@PathVariable("pagenum") String pagenum
			,@PathVariable("pagesize") String pagesize){
		
		LOGGER.info("invoking walmart remote api to get list of products");
		
		ResponseEntity responseEntity = service.invokeRemoteApi(pagenum,pagesize);
		
		return responseEntity;
		
	}
	
	
	

}
