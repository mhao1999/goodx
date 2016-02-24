package com.goodx.services;

import com.goodx.models.GoodXStep;

public interface GoodXStepService {

	GoodXStep getById(int id);
	
	void addNew(GoodXStep step);
	
	void delete(int id);
	
	void update(GoodXStep step);
	
	void updateOrder(int id, int order);
}
