package com.goodx.configuration;

import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

public class GoodXShiroFilterInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		Dynamic filter = servletContext.addFilter("shiroFilter", DelegatingFilterProxy.class);
		filter.setInitParameter("targetFilterLifeCycle", "true");
		
		filter.addMappingForUrlPatterns(null, false, "/*");
	}

}
