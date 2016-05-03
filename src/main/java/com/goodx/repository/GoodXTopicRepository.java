package com.goodx.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.goodx.models.GoodXNewTopic;
import com.goodx.models.GoodXStep;
import com.goodx.models.GoodXTopic;


public interface GoodXTopicRepository {
	
	GoodXTopic getTopicById(int id);
	
	GoodXNewTopic getTopicDetail(int id);
	
	List<GoodXTopic> getByUserByLimit(@Param("userId")int userId, @Param("startFrom")int startFrom, @Param("count")int count);
	
	List<GoodXTopic> getRecentByLimit(int count); 

	int countUserTopics(int userId);
	
	void update(GoodXTopic topic);
	
	int addNew(GoodXTopic topic);
	
	int addSteps(List<GoodXStep> steps);
	
	void incrementTopicViews(int id);
	
	void incrementTopicCollections(int id);
	
	void incrementTopicLikes(int id);
	
	void incrementTopicReplies(int id);
	
	void decrementTopicReplies(int id);
	
	int getTotalSteps(int id);
	
	int getTotalReplies(int id);
}
