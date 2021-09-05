package com.abc.tour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan({"com.abc.controller","com.abc.tour","com.abc.jwt.configs","com.abc.service"})
@EntityScan("com.abc.entity")
@EnableJpaRepositories("com.abc.repository")
@EnableScheduling
public class TourApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TourApplication.class, args);
	}

}
