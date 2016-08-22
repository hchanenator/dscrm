/**
 * 
 */
package org.herb.dscrm.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author herb
 *
 */
@Configuration
@Profile("prod")
@PropertySource("classpath:application.properties")
public class DBConfig {

	@Resource
	Environment env;

	@Bean
	public DataSource dataSource() {
		System.out.println("Setting up DataSource for PROD");
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		
		System.out.println(dataSource.getUrl());

		return dataSource;
	}

}
