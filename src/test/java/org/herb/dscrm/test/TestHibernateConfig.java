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
@Profile("dev")
@PropertySource("classpath:application.properties")
public class TestHibernateConfig {

//	private final String dialect = "org.hibernate.dialect.HSQLDialect";
	@Resource
	Environment env;


	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		System.out.println("Setting up LocalSessionFactoryBean for DEV");
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(ds);
		sessionFactoryBean.setPackagesToScan(new String[] { "org.herb.dscrm.domain" });

		Properties props = hibernateProperties();
		props.setProperty("hbm2ddl.auto", "create");

		sessionFactoryBean.setHibernateProperties(props);

		return sessionFactoryBean;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        
        properties.setProperty("dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.setProperty("show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.setProperty("pool_size", env.getProperty("hibernate.pool_size"));
        
        return properties;
    }


}
