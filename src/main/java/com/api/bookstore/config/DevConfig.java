package com.api.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.bookstore.service.DBService;

@Configuration
public class DevConfig {

	@Autowired
	private DBService dbService;
	
    @Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
    @Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
