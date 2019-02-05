package com.springboot.test.microservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastUpdateData implements Serializable {
	private static final long serialVersionUID = -1515249491089419826L;
	private String date;
	private String time;
	private PM25 pm25;
	
	
	@JsonProperty(value = "PM25")
	public PM25 getPm25() {
		return pm25;
	}

	public void setPm25(PM25 pm25) {
		this.pm25 = pm25;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
