package com.goodx.controllers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goodx.helper.GoodXLoginResult;
import com.goodx.message.GoodXMailService;
import com.goodx.models.GoodXUser;
import com.goodx.services.GoodXUserService;

@Controller
public class GoodXUserController {
	
	@Autowired
	GoodXUserService userService;
	
	@Autowired
	GoodXMailService mailService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}
	
	@RequestMapping(
			value="/login", 
			method=RequestMethod.POST,
			produces="application/json")
	public @ResponseBody GoodXLoginResult login(@RequestBody GoodXUser user) {
		try {
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
			// WebUtils.redirectToSavedRequest(request, response, null);
			return new GoodXLoginResult(true, "success");
		} catch (AuthenticationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new GoodXLoginResult(false, "failure");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "register";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody GoodXLoginResult register(@RequestBody GoodXUser user) {
		
		GoodXUser existUser = this.userService.getByEmail(user.getEmail());
		if (existUser != null)
		{
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(new UsernamePasswordToken(user.getUserName(), user.getPassword()));
			// WebUtils.redirectToSavedRequest(request, response, null);
			return new GoodXLoginResult(true, "success");
		}
		
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		Object salt = rng.nextBytes();
		String passWord = user.getPassword();		
		
		String hashedPasswordBase64 = new Sha256Hash(passWord, salt, 1024).toBase64();
		user.setPassword(hashedPasswordBase64);
		user.setSalt(salt.toString());
				
		this.userService.add(user);
		
		this.mailService.sendActivationMail(user);
		
		return new GoodXLoginResult(true, "success");
	}
}
