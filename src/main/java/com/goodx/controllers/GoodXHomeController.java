package com.goodx.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodx.models.GoodXUser;
import com.goodx.services.GoodXUserService;

@Controller
public class GoodXHomeController {
	
	@Autowired
	GoodXUserService service;
	
	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login() {
		return "home";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String register(HttpServletRequest request) {
		
		GoodXUser user = new GoodXUser();
		user.setUserName(request.getParameter("email"));
		user.setEmail(request.getParameter("email"));
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		Object salt = rng.nextBytes();
		
		String hashedPasswordBase64 = new Sha256Hash(request.getParameter("p"), salt, 1024).toBase64();
		user.setPassword(hashedPasswordBase64);
		user.setSalt(salt.toString());
		
		service.add(user);
		return "home";
	}
}
