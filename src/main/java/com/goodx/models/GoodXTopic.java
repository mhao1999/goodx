package com.goodx.models;

import java.io.Serializable;
import java.sql.Date;

public class GoodXTopic implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String topicTitle;
	
	private String topicUID;
	
	private Integer topicViews;
	
	private Integer topicReplies;
	
	private Integer topicCollections;
	
	private Integer topicLikes;
	
	private Date topicTime;
	
	private Integer userId;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTopicTitle() {
		return this.topicTitle;
	}
	
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	
	public String getTopicUID() {
		return this.topicUID;
	}
	
	public void setTopicUID(String topicUID) {
		this.topicUID = topicUID;
	}
	
	public int getTopicViews() {
		return this.topicViews;
	}
	
	public void setTopicViews(int topicViews) {
		this.topicViews = topicViews;
	}
	
	public int getTopicReplies() {
		return this.topicReplies;
	}
	
	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}
	
	public int getTopicCollections() {
		return this.topicCollections;
	}
	
	public void setTopicCollections(int topicCollections) {
		this.topicCollections = topicCollections;
	}
	
	public int getTopicLikes() {
		return this.topicLikes;
	}
	
	public void setTopicLikes(int topicLikes) {
		this.topicLikes = topicLikes;
	}
	
	public Date getTopicTime() {
		return this.topicTime;
	}
	
	public void setTopicTime(Date topicTime) {
		this.topicTime = topicTime;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
