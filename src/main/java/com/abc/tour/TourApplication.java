package com.abc.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.abc.controller"})
@EntityScan("com.abc.entity")
public class TourApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TourApplication.class, args);
	}

}
