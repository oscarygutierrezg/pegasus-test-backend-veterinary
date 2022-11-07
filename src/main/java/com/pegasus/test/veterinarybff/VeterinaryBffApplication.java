package com.pegasus.test.veterinarybff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan("com.pegasus.test")
public class VeterinaryBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryBffApplication.class, args);
	}

}
