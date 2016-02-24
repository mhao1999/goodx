package com.goodx.repository;

import com.goodx.models.GoodXReply;

public interface GoodXReplyRepository {

	GoodXReply getById(int id);
	
	void addNew(GoodXReply reply);
	
	void delete(int id);
	
	void update(GoodXReply reply);
}
