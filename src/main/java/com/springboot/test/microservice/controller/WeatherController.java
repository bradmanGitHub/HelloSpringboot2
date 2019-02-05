package com.springboot.test.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.microservice.domain.Weather;
import com.springboot.test.microservice.service.WeatherService;

@RestController
public class WeatherController {
	
	
	@Autowired
	WeatherService weatherService;	
	
	@RequestMapping(value = "/getpm25", method = RequestMethod.GET)
	public ResponseEntity<Weather> getUserDataFromAnotherRest(){
		Weather weather = weatherService.getAir3ThaiPM25RestCall();
		
		return new ResponseEntity<Weather>(weather, HttpStatus.OK);
	}
}

