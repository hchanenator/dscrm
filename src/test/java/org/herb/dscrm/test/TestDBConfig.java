/**
 * 
 */
package org.herb.dscrm.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * @author herb
 *
 */
@Configuration
@Profile("dev")
public class TestDBConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("Setting up DataSource for DEV");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.HSQL);
		builder.setName("dscrmtest");
		return builder.build();
	}

}
