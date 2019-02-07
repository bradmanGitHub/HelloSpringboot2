package com.springboot.test.microservice.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.test.microservice.domain.Weather;

@Service
public class WeatherService {
	private final RestTemplate restTemplate;

	public WeatherService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public Weather getAir3ThaiPM25RestCall(){
		
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.restTemplate.getForObject("http://air4thai.pcd.go.th/services/getNewAQI_JSON.php?stationID=59t", Weather.class);
	}
}
