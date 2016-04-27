package com.goodx.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodx.repository.GoodXUserRepository;

import com.goodx.models.GoodXUser;

@Service("userService")
public class GoodXUserServiceImpl implements GoodXUserService {

	private GoodXUserRepository repository;
	
	@Autowired
	public GoodXUserServiceImpl(GoodXUserRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Override
	public GoodXUser getByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.getByEmail(email);
	}
	
	@Override
	public GoodXUser getById(int id) {
		return repository.getById(id);
	}
	
	@Override
	@Transactional
	public void add(GoodXUser user) {
		this.repository.add(user);
		this.repository.setRole("user", user.getEmail());
	}

	@Override
	public void delete(int id) {
		this.repository.delete(id);
	}
	
	@Override
	public void update(GoodXUser user) {
		this.repository.update(user);
	}
	
	@Override
	public void setActive(int id) {
		this.repository.setActive(id);
	}
	
	@Override
	public void setRole(String roleName, String email) {
		this.repository.setRole(roleName, email);
	}
	
	@Override
	public void incrementTopics(int id) {
		this.repository.incrementTopics(id);
	}
	
	@Override
	public void incrementReplies(int id) {
		this.repository.incrementReplies(id);
	}
	
	@Override
	public void decrementReplies(int id) {
		this.repository.decrementReplies(id);
	}
	
	@Override
	public int getTotalUsers() {
		return this.repository.getTotalUsers();
	}
	
	@Override
	public void updateUserName(int id, String userName) {
		this.repository.updateUserName(id, userName);
	}
	
	@Override
	public String getUserNameByEmail(String email) {
		return this.repository.getUserNameByEmail(email);
	}
}
