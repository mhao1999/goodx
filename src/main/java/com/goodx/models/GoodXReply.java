package com.goodx.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class GoodXReply implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String content;
	
	private Timestamp replyTime;
	
	private byte replyType;
	
	private int stepId;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getReplyTime() {
		return this.replyTime;
	}
	
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}
	
	public byte getReplyType() {
		return this.replyType;
	}
	
	public void setReplyType(byte replyType) {
		this.replyType = replyType;
	}
	
	public int getStepId() {
		return this.stepId;
	}
	
	public void setStepId(int stepId) {
		this.stepId = stepId;
	}
}
