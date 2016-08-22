/**
 * 
 */
package org.herb.dscrm.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * @author herb
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

//	@Bean
//	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		builder.setType(EmbeddedDatabaseType.HSQL);
//		builder.setName("testdb");
//		return builder.build();
//	}
	@Resource
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getRequiredProperty("db.driver"));
		dataSource.setUrl(env.getRequiredProperty("db.url"));
		dataSource.setUsername(env.getRequiredProperty("db.username"));
		dataSource.setPassword(env.getRequiredProperty("db.password"));
		
		return dataSource;
	}
	
}
