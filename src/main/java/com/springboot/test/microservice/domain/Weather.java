package com.springboot.test.microservice.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable{

	private static final long serialVersionUID = -3725492092295234664L;
	private String stationID;
	private String nameTH;
	private String nameEN;
	private String areaTH;
	private String areaEN;
	private String stationType;
	private double lat;
	
	private LastUpdateData LastUpdate;

	@JsonProperty(value = "LastUpdate")
	public LastUpdateData getLastUpdate() {
		return LastUpdate;
	}

	public void setLastUpdate(LastUpdateData lastUpdate) {
		LastUpdate = lastUpdate;
	}

	public String getStationID() {
		return stationID;
	}

	public void setStationID(String stationID) {
		this.stationID = stationID;
	}

	public String getNameTH() {
		return nameTH;
	}

	public void setNameTH(String nameTH) {
		this.nameTH = nameTH;
	}

	public String getNameEN() {
		return nameEN;
	}

	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}

	public String getAreaTH() {
		return areaTH;
	}

	public void setAreaTH(String areaTH) {
		this.areaTH = areaTH;
	}

	public String getAreaEN() {
		return areaEN;
	}

	public void setAreaEN(String areaEN) {
		this.areaEN = areaEN;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}


	@Override
	public String toString() {
		return "Weather [stationID=" + stationID + ", nameTH=" + nameTH + ", nameEN=" + nameEN + ", areaTH=" + areaTH
				+ ", areaEN=" + areaEN + ", stationType=" + stationType + ", lat=" + lat + ", LastUpdate=" + LastUpdate
				+ "]";
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
