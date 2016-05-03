package com.goodx.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodx.models.GoodXNewTopic;
import com.goodx.services.GoodXTopicService;

@Controller
public class GoodXTopicController {

	@Autowired
	GoodXTopicService topicService;
	
	@RequestMapping(value="postDetail", method=RequestMethod.GET)
	public @ResponseBody GoodXNewTopic getDetail(@RequestParam int id) {
		return this.topicService.getTopicDetail(id);
	}
}
