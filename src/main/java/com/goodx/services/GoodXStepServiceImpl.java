package com.goodx.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.goodx.models.GoodXStep;
import com.goodx.repository.GoodXStepRepository;

public class GoodXStepServiceImpl implements GoodXStepService {

	private GoodXStepRepository repository;
	
	@Autowired
	public GoodXStepServiceImpl(GoodXStepRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	@Override
	public GoodXStep getById(int id) {
		// TODO Auto-generated method stub
		return this.repository.getById(id);
	}

	@Override
	public void addNew(GoodXStep step) {
		// TODO Auto-generated method stub
		this.repository.addNew(step);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.repository.delete(id);
	}

	@Override
	public void update(GoodXStep step) {
		// TODO Auto-generated method stub
		this.repository.update(step);
	}

	@Override
	public void updateOrder(int id, int order) {
		// TODO Auto-generated method stub
		this.repository.updateOrder(id, order);
	}

}
