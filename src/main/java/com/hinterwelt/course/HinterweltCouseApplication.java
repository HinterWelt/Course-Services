package com.hinterwelt.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * This is the main application.  
 * @author bilbo
 * 
 */
@SpringBootApplication
@EnableEurekaClient
public class HinterweltCouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(HinterweltCouseApplication.class, args);
	}
}
