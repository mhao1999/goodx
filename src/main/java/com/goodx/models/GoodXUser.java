package com.goodx.models;

import java.io.Serializable;

public class GoodXUser implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	private String gender;
	
	private byte userActive;
	
	private int userTopics;
	
	private int userReplies;
	
	private byte deleted;

	private String salt;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public byte getUserActive() {
		return this.userActive;
	}
	
	public void setUserActive(byte userActive) {
		this.userActive = userActive;
	}
	
	public int getUserTopics() {
		return this.userTopics;
	}
	
	public void setUserTopics(int userTopics) {
		this.userTopics = userTopics;
	}
	
	public int getUserReplies() {
		return this.userReplies;
	}
	
	public void setUserReplies(int userReplies) {
		this.userReplies = userReplies;
	}
	
	public byte getDeleted() {
		return this.deleted;
	}
	
	public void setDeleted(byte deleted) {
		this.deleted = deleted;
	}
	
	public String getSalt() {
		return this.salt;
	}
	
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
