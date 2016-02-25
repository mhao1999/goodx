package com.goodx.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@PropertySource(value="classpath:application.properties")
public class GoodXToolConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public JavaMailSenderImpl sender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost(environment.getProperty("mail.host"));
		sender.setPort(environment.getProperty("mail.port", Integer.class));
		sender.setUsername(environment.getProperty("mail.username"));
		sender.setPassword(environment.getProperty("mail.password"));
		sender.setProtocol(environment.getProperty("mail.protocol"));
		
		return sender;
	}
}
