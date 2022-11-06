package com.pegasus.test.veterinarybff.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import feign.auth.BasicAuthRequestInterceptor;

public class PersonClientConfiguration {


	@Value("${app.ms.person.basic.username}")
	private String userName;

	@Value("${app.ms.person.basic.password}")
	private String password;
	

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(userName, password);
    }
}
