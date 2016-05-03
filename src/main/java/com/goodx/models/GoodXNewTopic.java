package com.goodx.models;

import java.io.Serializable;
import java.util.ArrayList;

public class GoodXNewTopic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String subject;
	
	private String userName;
	
	private ArrayList<GoodXStep> steps = new ArrayList<>();
	
	public GoodXNewTopic() {
		
	}
	
	public GoodXNewTopic(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public ArrayList<GoodXStep> getSteps() {
		return this.steps;
	}
	
	public void setSteps(ArrayList<GoodXStep> steps) {
		this.steps = steps;
	}
}
