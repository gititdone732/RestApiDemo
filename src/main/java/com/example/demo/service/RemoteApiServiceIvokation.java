package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.example.demo.error.CustomException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RemoteApiServiceIvokation {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "remoteEndPointNotWorking", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
	})
	public ResponseEntity<?> invokeRemoteApi(String pagenum,String pagesize) {
		
		String url7="https://mobile-tha-server-8ba57.firebaseapp.com/walmartproducts/"
				+pagenum+"/"+pagesize;
		
		ResponseEntity<String> responseEntity =
				restTemplate.getForEntity(url7, String.class);
		
		return responseEntity;
		
	}
	
	@SuppressWarnings("unused")
	public ResponseEntity<?> remoteEndPointNotWorking(String pagenum,String pagesize) {
		
		throw new CustomException("Fallback method invoked");
	}
}
