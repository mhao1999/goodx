package com.goodx.models;

import java.io.Serializable;
import java.util.ArrayList;

public class GoodXNewTopic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String subject;
	
	private ArrayList<GoodXStep> steps = new ArrayList<>();
	
	public GoodXNewTopic() {
		
	}
	
	public String getSubject() {
		return this.subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public ArrayList<GoodXStep> getSteps() {
		return this.steps;
	}
	
	public void setSteps(ArrayList<GoodXStep> steps) {
		this.steps = steps;
	}
}
