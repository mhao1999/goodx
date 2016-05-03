package com.goodx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodx.models.GoodXTopic;
import com.goodx.services.GoodXForumService;

@Controller
public class GoodXForumController {
	
	@Autowired
	GoodXForumService forumService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<GoodXTopic> getTopicList() {
		return this.forumService.getList();
	}
}
