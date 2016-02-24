package com.goodx.repository;

import org.apache.ibatis.annotations.Param;

import com.goodx.models.GoodXStep;

public interface GoodXStepRepository {

	GoodXStep getById(int id);
	
	void addNew(GoodXStep step);
	
	void delete(int id);
	
	void update(GoodXStep step);
	
	void updateOrder(@Param("id")int id, @Param("order")int order);
}
