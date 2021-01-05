package com.online.estore.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.online.estore")
@EnableJpaRepositories("com.online.estore.core.model")
@EntityScan("com.online.estore.core.repository")
public class EstoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstoreApplication.class, args);
	}
}

