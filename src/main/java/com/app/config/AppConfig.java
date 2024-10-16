package com.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.interceptor.ActionHandlerInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.app"})
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	private ActionHandlerInterceptor actionHandlerInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		InterceptorRegistration interceptorRegistration = interceptorRegistry.addInterceptor(actionHandlerInterceptor);
		
		List<String> urlPatternsList = new ArrayList<>();
		urlPatternsList.add("/action/actionHandler1");
		urlPatternsList.add("/action/actionHandler2");
		
		interceptorRegistration.addPathPatterns(urlPatternsList);
	}

}
