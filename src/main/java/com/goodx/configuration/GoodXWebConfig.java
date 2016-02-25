package com.goodx.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import(GoodXToolConfig.class)
@ComponentScan({"com.goodx.controllers"})
public class GoodXWebConfig extends WebMvcConfigurationSupport {
	
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
	
	@Bean
	MappingJackson2HttpMessageConverter converter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		return converter;
	}
	
	// https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
				ignoreAcceptHeader(false).
				defaultContentType(MediaType.TEXT_HTML).
				mediaType("html", MediaType.TEXT_HTML).
				mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(converter());
		addDefaultHttpMessageConverters(converters);
	};
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
