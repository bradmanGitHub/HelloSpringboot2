package com.springboot.test.microservice.controller;

import java.util.concurrent.ForkJoinPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.springboot.test.microservice.domain.Weather;
import com.springboot.test.microservice.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class WeatherController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping(value = "/getpm25Sync", method = RequestMethod.GET)
	public ResponseEntity<Weather> getUserDataFromAnotherRest() {
		Weather weather = weatherService.getAir3ThaiPM25RestCall();
		return new ResponseEntity<Weather>(weather, HttpStatus.OK);
	}

	@RequestMapping(value = "/getpm25Async", method = RequestMethod.GET)
	public DeferredResult<ResponseEntity<Weather>> getUserDataFromAnotherRestAsync() {

		DeferredResult<ResponseEntity<Weather>> deferredResult = new DeferredResult<>(60000l);

		// ---handle timeout error
		deferredResult.onTimeout(new Runnable() {
			@Override
			public void run() {
				deferredResult.setErrorResult(
						ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timeout occurred."));
				log.info("TIME OUT OCCUR");
			}
		});

		// ---handle on error
		deferredResult.onError((Throwable t) -> {
			deferredResult
					.setErrorResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred."));
		});

		ForkJoinPool forkJoinPool = new ForkJoinPool(200);
		forkJoinPool.submit(() -> {
			log.info("Processing in separate thread (pool size: " + forkJoinPool.getPoolSize() + ")");

			Weather response = weatherService.getAir3ThaiPM25RestCall();

			deferredResult.setResult(ResponseEntity.ok(response));
			
			log.info("got result => " + response.toString());
		});
		log.info("servlet thread freed");

		return deferredResult;
	}
}
