package com.goodx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodx.models.GoodXNewTopic;
import com.goodx.models.GoodXStep;
import com.goodx.models.GoodXTopic;
import com.goodx.models.GoodXUser;
import com.goodx.repository.GoodXTopicRepository;

@Service("topicService")
public class GoodXTopicServiceImpl implements GoodXTopicService {

	private GoodXTopicRepository repository;
	
	@Autowired
	public GoodXTopicServiceImpl(GoodXTopicRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Override
	public GoodXTopic getTopicById(int id) {
		// TODO Auto-generated method stub
		return this.repository.getTopicById(id);
	}
	
	@Override
	public GoodXNewTopic getTopicDetail(int id) {
		return this.repository.getTopicDetail(id);
	}

	@Override
	public List<GoodXTopic> getByUserByLimit(int userId, int startFrom, int count) {
		return this.repository.getByUserByLimit(userId, startFrom, count);
	}
	
	@Override
	public List<GoodXTopic> getRecentByLimit(int count) {
		return this.repository.getRecentByLimit(count);
	}

	@Override
	public int countUserTopics(int userId) {
		return this.repository.countUserTopics(userId);
	}
	
	@Override
	public void update(GoodXTopic topic) {
		this.repository.update(topic);
	}
	
	@Override 
	public int addNew(GoodXTopic topic) {
		
		this.repository.addNew(topic);
		
		return topic.getId();
	}
	
	@Override 
	@Transactional
	public void addNew(GoodXUser user, GoodXNewTopic newTopic) {
		GoodXTopic topic = new GoodXTopic();
		topic.setUserId(user.getId());
		topic.setTopicTitle(newTopic.getSubject());
		java.util.Date currentDate = new java.util.Date();
		topic.setTopicTime(new java.sql.Date(currentDate.getTime()));
		
		this.repository.addNew(topic);
		
		int topicId = topic.getId();
		
		for (GoodXStep step : newTopic.getSteps()) {
			step.setTopicId(topicId);
		}
		
		this.repository.addSteps(newTopic.getSteps());
	}
	
	@Override
	public void incrementTopicViews(int id) {
		this.repository.incrementTopicViews(id);
	}
	
	@Override
	public void incrementTopicCollections(int id) {
		this.repository.incrementTopicCollections(id);
	}
	
	@Override
	public void incrementTopicLikes(int id) {
		this.repository.incrementTopicLikes(id);
	}
	
	@Override
	public void incrementTopicReplies(int id) {
		this.repository.incrementTopicReplies(id);
	}
	
	@Override
	public void decrementTopicReplies(int id) {
		this.repository.decrementTopicReplies(id);
	}
	
	@Override
	public int getTotalSteps(int id) {
		return this.repository.getTotalSteps(id);
	}
	
	@Override
	public int getTotalReplies(int id) {
		return this.repository.getTotalReplies(id);
	}
}
