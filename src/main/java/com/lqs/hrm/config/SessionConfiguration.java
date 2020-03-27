package com.lqs.hrm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lqs.hrm.interceptor.ApiInterceptor;

/**
 * 拦截器配置
 * @author Administrator
 *
 */
@Configuration
public class SessionConfiguration implements WebMvcConfigurer{
	
	/**
	 * 注册拦截器
	 */
	@Override 
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ApiInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/login/**","/static/**");
	}
	
}
