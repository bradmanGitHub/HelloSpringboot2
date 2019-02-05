package com.springboot.test.microservice.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.test.microservice.domain.User;

@Service
public class CustomerInfoSvr {

	private final RestTemplate restTemplate;

	public CustomerInfoSvr(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

//	public Details someRestCall(String name) {
//		return this.restTemplate.getForObject("/{name}/details", Details.class, name);
//	}
	
	public User getUserRestCall(){
		return this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1", User.class);
	}
}
