package com.goodx.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GoodXWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override 
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {GoodXMyBatisConfig.class, GoodXWebSecurityConfig.class};
	}
	
	@Override 
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {GoodXWebConfig.class};
	}
}
