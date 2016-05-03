package com.goodx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodx.models.GoodXTopic;
import com.goodx.repository.GoodXForumRepository;

@Service("forumService")
public class GoodXForumServiceImpl implements GoodXForumService {

	private GoodXForumRepository repository;
	
	@Autowired
	public GoodXForumServiceImpl(GoodXForumRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Override
	public List<GoodXTopic> getList() {
		return this.repository.getList();
	}
}
