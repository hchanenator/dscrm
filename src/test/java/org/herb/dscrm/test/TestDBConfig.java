/**
 * 
 */
package org.herb.dscrm.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author herb
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
@Profile("dev")
public class TestDBConfig {

	@Resource
	Environment env;

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		
		builder.setType(EmbeddedDatabaseType.HSQL);
		builder.setName("testdb");

		return builder.build();
	}

}
