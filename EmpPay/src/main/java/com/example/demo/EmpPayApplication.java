package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class EmpPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpPayApplication.class, args);
		log.info("Logger is Activated..!");
		
	}

}
