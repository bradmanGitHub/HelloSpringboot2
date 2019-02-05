package com.springboot.test.microservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PM25 implements Serializable{
	private static final long serialVersionUID = 5514774125598250494L;
	private String value;
	private String unit;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "PM25 [value=" + value + ", unit=" + unit + "]";
	}

}
