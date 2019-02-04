package com.springboot.test.microservice.domain;

public class Address {
	
	private String homeNo;
	private String village;
	private String road;
	private String tambon;
	private String amphur;
	private String provice;
	private int postCode;
	
	//------ below code can be skip when using lombok na ^^ --
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getRoad() {
		return road;
	}
	public void setRoad(String road) {
		this.road = road;
	}
	public String getTambon() {
		return tambon;
	}
	public void setTambon(String tambon) {
		this.tambon = tambon;
	}
	public String getAmphur() {
		return amphur;
	}
	public void setAmphur(String amphur) {
		this.amphur = amphur;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	
	@Override
	public String toString() {
		return "Address [homeNo=" + homeNo + ", village=" + village + ", road=" + road + ", tambon=" + tambon
				+ ", amphur=" + amphur + ", provice=" + provice + ", postCode=" + postCode + "]";
	}
	
		

}
