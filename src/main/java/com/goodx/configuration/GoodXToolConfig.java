package com.goodx.configuration;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;


@Configuration
@ComponentScan("com.goodx.message")
public class GoodXToolConfig {

	@Autowired
	Environment environment;
	
	@Bean
	public JavaMailSender sender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		
		sender.setHost(environment.getProperty("mail.host"));
		sender.setPort(environment.getProperty("mail.port", Integer.class));
		sender.setUsername(environment.getProperty("mail.username"));
		sender.setPassword(environment.getProperty("mail.password"));
		sender.setProtocol(environment.getProperty("mail.transport.protocol"));		// smtps
		sender.setDefaultEncoding("UTF-8");

		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.transport.protocol", environment.getProperty("mail.transport.protocol"));
		//javaMailProperties.setProperty("mail.smtp.auth", environment.getProperty("mail.auth"));
		javaMailProperties.setProperty("mail.smtps.auth", environment.getProperty("mail.smtps.auth"));
		javaMailProperties.setProperty("mail.mime.charset", "UTF-8");
		//javaMailProperties.setProperty("mail.smtp.starttls.enable", environment.getProperty("mail.starttls"));
		javaMailProperties.setProperty("mail.smtp.ssl.enable", environment.getProperty("mail.smtp.ssl.enable"));
		javaMailProperties.setProperty("mail.debug", environment.getProperty("mail.debug"));
		
		sender.setJavaMailProperties(javaMailProperties);
		
		return sender;
	}
	
	@Bean
	public VelocityEngine velocityEngine() throws VelocityException, IOException {
		VelocityEngineFactoryBean factory = new VelocityEngineFactoryBean();
		Properties properties = new Properties();
		properties.put("resource.loader", "file");
		properties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");

		factory.setVelocityProperties(properties);
		
		factory.setOverrideLogging(false);
		factory.setResourceLoaderPath("classpath:mail");
		
		return factory.createVelocityEngine();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer placeholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] resources = new Resource[] {
				new ClassPathResource("application.properties"),
				new ClassPathResource("languages/message.properties")
		};
		
		placeholderConfigurer.setLocations(resources);
		return placeholderConfigurer;
	}
}
