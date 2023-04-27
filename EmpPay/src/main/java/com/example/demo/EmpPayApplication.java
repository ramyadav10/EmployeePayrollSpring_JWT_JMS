package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
//@EnableEurekaClient
@EnableAspectJAutoProxy(proxyTargetClass=true) 
//@EnableOAuth2Sso

public class EmpPayApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmpPayApplication.class, args);
		log.info("Logger is Activated..!");
		
		
	}

}
