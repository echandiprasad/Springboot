package com.chandi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.chandi.springboot.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication(scanBasePackages = { "com.chandi.springboot" })
public class SpringBootCRUDApplWithAngularJS {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCRUDApplWithAngularJS.class, args);
	}
}
