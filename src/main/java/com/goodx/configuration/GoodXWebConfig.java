package com.goodx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"com.goodx.controllers"})
public class GoodXWebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager cnManager) {
		ContentNegotiatingViewResolver cnvResolver = new ContentNegotiatingViewResolver();
		cnvResolver.setContentNegotiationManager(cnManager);
		return cnvResolver;
	}
	
	// support .jsp
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver irvResolver = new InternalResourceViewResolver();
		irvResolver.setPrefix("/WEB-INF/views/");
		irvResolver.setSuffix(".jsp");
		irvResolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return irvResolver;
	}
	
	// https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
				ignoreAcceptHeader(true).
				defaultContentType(MediaType.TEXT_HTML).
				mediaType("html", MediaType.TEXT_HTML).
				mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
