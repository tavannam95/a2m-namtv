package com.a2m.configuration;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;


public class AppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
		root.register(WebSecurityConfig.class);
		servletContext.addListener(new ContextLoaderListener(root));
		servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
			.addMappingForUrlPatterns(null, false, "/*");
		
	}

}
