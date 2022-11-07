package com.pegasus.test.veterinarybff.config;


import com.pegasus.test.veterinarybff.interceptor.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

	@Autowired
	SecurityInterceptor securityInterceptor;


	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		//registry.addInterceptor(securityInterceptor);
	}

}
