package com.springboot.test.microservice.domain;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -2479908704354318402L;
	
	private int userId;
	private int id;
	private String title;
	private boolean completed;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
	}
	
}
