package com.goodx.services;

import com.goodx.models.GoodXReply;

public interface GoodXReplyService {

	GoodXReply getById(int id);
	
	void addNew(GoodXReply reply);
	
	void delete(int id);
	
	void update(GoodXReply reply);
}
