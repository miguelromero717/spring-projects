package com.juego.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.juego.repositories")
public class JPAConfig {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			DataSource dataSource, HibernateJpaVendorAdapter jpaAdapter) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(jpaAdapter);
		entityManagerFactoryBean.setPackagesToScan("com.juego.domain");
		entityManagerFactoryBean.setJpaProperties(setHibernateProperties());

		return entityManagerFactoryBean;
	}

	@Bean
	public HibernateJpaVendorAdapter getJpaAdapter() {
		HibernateJpaVendorAdapter jpaAdapater = new HibernateJpaVendorAdapter();
		jpaAdapater.setShowSql(true);
		jpaAdapater.setDatabase(Database.ORACLE);
		return jpaAdapater;
	}

	private Properties setHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", "true");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return prop;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emFactory) {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emFactory.getObject());
		return tm;
	}

}
