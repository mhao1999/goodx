package com.goodx.services;

import com.goodx.models.GoodXUser;

public interface GoodXUserService {
	
	GoodXUser getByEmail(String email);
	
	GoodXUser getById(int id);
	
	void add(GoodXUser user);
	
	void delete(int id);
	
	void update(GoodXUser user);
	
	void setActive(int id);
	
	void setRole(String roleName, String email);
	
	void incrementTopics(int id);
	
	void incrementReplies(int id);
	
	void decrementReplies(int id);
	
	int getTotalUsers();
	
	void updateUserName(int id, String userName);
	
	String getUserNameByEmail(String email);
}
