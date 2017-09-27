package com.fuyi.springboot001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class Springboot001Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot001Application.class, args);
	}
}
