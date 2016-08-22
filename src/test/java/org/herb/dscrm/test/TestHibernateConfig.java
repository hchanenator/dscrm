/**
 * 
 */
package org.herb.dscrm.test;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author herb
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
@Profile("dev")
public class TestHibernateConfig {

	private final String dialect = "org.hibernate.dialect.HSQLDialect";

	@Resource
	Environment env;
	
	@Autowired
	TestDBConfig dbConfig;

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(ds);
		
		sfb.setPackagesToScan(new String[] { "org.herb.dscrm.domain" });

		Properties props = hibernateProperties();
//		props.setProperty("dialect", dialect);
//		props.setProperty("show_sql", "true");
		props.setProperty("hbm2ddl.auto", "create");

		sfb.setHibernateProperties(props);

		return sfb;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        
        properties.setProperty("dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.setProperty("show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.setProperty("pool_size", env.getProperty("hibernate.pool_size"));
        
        return properties;
    }


}
