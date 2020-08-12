package com.project.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class RestApiFrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiFrameworkApplication.class, args);
	}

}
