package com.goodx.models;

import java.io.Serializable;

public class GoodXStep implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String imgUrl;
	
	private String content;
	
	private byte order;
	
	private int topicId;
	
	public GoodXStep() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImgUrl() {
		return this.imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public byte getOrder() {
		return this.order;
	}
	
	public void setOrder(byte order) {
		this.order = order;
	}
	
	public int getTopicId() {
		return this.topicId;
	}
	
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
}
