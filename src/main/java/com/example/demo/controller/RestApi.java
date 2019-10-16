package com.example.demo.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
	
	
	@RequestMapping(value="/jsonobj",produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Map<String,String> jsonObject(){
		
		HashMap<String,String> map = new HashMap();
		map.put("name", "omsairam");
		return map;
		
	}

}
