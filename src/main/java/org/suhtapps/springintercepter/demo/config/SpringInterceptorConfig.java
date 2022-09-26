package org.suhtapps.springintercepter.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.suhtapps.springintercepter.demo.interceptor.SpringInterceptorDemo;

@Configuration
public class SpringInterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private SpringInterceptorDemo springInterceptorDemo;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(springInterceptorDemo);
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}
