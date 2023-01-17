package com.juego.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DBConfig {

	@Bean
	public DataSource dataSource() throws Exception {				
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/juego");
		dataSource.setUser("juegouser");
		dataSource.setPassword("juego12345*");
		dataSource.setMaxPoolSize(50);
		dataSource.setMinPoolSize(10);
		dataSource.setMaxStatements(100);
		dataSource.setTestConnectionOnCheckin(true);
		return dataSource;
	}
	
}
