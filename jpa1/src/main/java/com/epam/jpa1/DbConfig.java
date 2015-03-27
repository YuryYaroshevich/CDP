package com.epam.jpa1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
	@Bean
	public EntityManagerFactory entityManagerFactory() {		
		return Persistence.createEntityManagerFactory("jpa1");
	}
}
