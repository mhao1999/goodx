package com.goodx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodx.models.GoodXReply;
import com.goodx.repository.GoodXReplyRepository;

@Service("replyService")
public class GoodXReplyServiceImpl implements GoodXReplyService {
	
	private GoodXReplyRepository repository;
	
	@Autowired
	public GoodXReplyServiceImpl(GoodXReplyRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}

	@Override
	public GoodXReply getById(int id) {
		// TODO Auto-generated method stub
		return this.repository.getById(id);
	}

	@Override
	public void addNew(GoodXReply reply) {
		// TODO Auto-generated method stub
		this.repository.addNew(reply);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.repository.delete(id);
	}

	@Override
	public void update(GoodXReply reply) {
		// TODO Auto-generated method stub
		this.repository.update(reply);
	}

}
