package com.api.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api.bookstore.service.DBService;

@Configuration
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
