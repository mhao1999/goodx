package com.goodx.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.goodx.models.GoodXNewTopic;
import com.goodx.models.GoodXUser;
import com.goodx.services.GoodXStepService;
import com.goodx.services.GoodXTopicService;
import com.goodx.services.GoodXUserService;
import com.qiniu.util.Auth;

@Controller
public class GoodXNewSubjectController {

	@Value("${qiniu.AK}")
	private String AK;
	
	@Value("${qiniu.SK}")
	private String SK;
	
	@Value("${qiniu.bucketName}")
	private String bucketName;
	
	@Autowired
	GoodXUserService userService;
	
	@Autowired
	GoodXTopicService topicService;
	
	@Autowired
	GoodXStepService stepService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/upload")
	public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		
		if (!file.isEmpty()) {
			String filePath = request.getServletContext().getRealPath("/" + file.getOriginalFilename());
			file.transferTo(new File(filePath));
		}
	}
	
	@RequestMapping(value="/token", method=RequestMethod.GET)
	public @ResponseBody Map<String, String> getToken() {
		Auth auth = Auth.create(AK, SK);
		return Collections.singletonMap("uptoken", auth.uploadToken(bucketName));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value="/publish", method=RequestMethod.POST)
	public void createNewSubject(@RequestBody GoodXNewTopic newTopic) {
		Subject currentUser = SecurityUtils.getSubject();
		String strPrincipal = (String)currentUser.getPrincipal();
		if (currentUser.isAuthenticated() && currentUser.isPermitted("user:create"))
		{
			GoodXUser user = this.userService.getByEmail((String)currentUser.getPrincipal());

			this.topicService.addNew(user, newTopic);
		}
	}
}
