package com.goodx.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodx.models.GoodXTopic;
import com.goodx.services.GoodXForumService;

@Controller
public class GoodXForumController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoodXForumController.class);
	
	@Autowired
	GoodXForumService forumService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<GoodXTopic> getTopicList() {

		List<GoodXTopic> list = this.forumService.getList();
		

		logger.debug("forumService.getList");
		
		
		return list;
	}
}
