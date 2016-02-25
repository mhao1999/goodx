package com.goodx.configuration;

import java.util.Properties;

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

		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", environment.getProperty("mail.protocol"));
		javaMailProperties.setProperty("mail.smtp.auth", environment.getProperty("mail.auth"));
		javaMailProperties.setProperty("mail.smtp.starttls.enable", environment.getProperty("mail.starttls"));
		javaMailProperties.setProperty("mail.debug", environment.getProperty("mail.debug"));
		
		sender.setJavaMailProperties(javaMailProperties);
		
		return sender;
	}
}
