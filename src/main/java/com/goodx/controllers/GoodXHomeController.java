package com.goodx.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodx.services.GoodXUserService;

@Controller
public class GoodXHomeController {
	
	@Autowired
	GoodXUserService service;
	
	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
}
