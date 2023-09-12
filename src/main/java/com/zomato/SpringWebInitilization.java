package com.zomato;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInitilization extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {MVCConfiguration.class} ;
	}

	@Override
	protected String[] getServletMappings() {
		String[] allowedURLMapping = {"/"};
		return allowedURLMapping;
	}

}
