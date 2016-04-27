package com.goodx.services;

import java.util.List;

import com.goodx.models.GoodXNewTopic;
import com.goodx.models.GoodXTopic;
import com.goodx.models.GoodXUser;

public interface GoodXTopicService {
	
	GoodXTopic getTopicById(int id);
	
	List<GoodXTopic>getByUserByLimit(int userId, int startFrom, int count);
	
	List<GoodXTopic> getRecentByLimit(int count); 
	
	int countUserTopics(int userId);
	
	void update(GoodXTopic topic);
	
	int addNew(GoodXTopic topic);
	
	void addNew(GoodXUser user, GoodXNewTopic newTopic);
	
	void incrementTopicViews(int id);
	
	void incrementTopicCollections(int id);
	
	void incrementTopicLikes(int id);
	
	void incrementTopicReplies(int id);
	
	void decrementTopicReplies(int id);
	
	int getTotalSteps(int id);
	
	int getTotalReplies(int id);
}
