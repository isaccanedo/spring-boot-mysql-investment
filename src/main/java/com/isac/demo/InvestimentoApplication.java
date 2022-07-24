package com.isac.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.isac")
@ComponentScan("com.isac")
@EnableJpaRepositories("com.isac")
public class InvestimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestimentoApplication.class, args);
	}

}
