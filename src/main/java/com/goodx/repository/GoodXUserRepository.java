package com.goodx.repository;

import org.apache.ibatis.annotations.Param;

import com.goodx.models.GoodXUser;

public interface GoodXUserRepository {
	
	GoodXUser getByEmail(String email);
	
	GoodXUser getById(int id);
	
	void add(GoodXUser user);
	
	void delete(int id);
	
	void update(GoodXUser user);
	
	void setActive(int id);
	
	void incrementTopics(int id);
	
	void incrementReplies(int id);
	
	void decrementReplies(int id);
	
	int getTotalUsers();
	
	void updateUserName(@Param("id")int id, @Param("userName")String userName);
	
	String getUserNameByEmail(String email);
}
