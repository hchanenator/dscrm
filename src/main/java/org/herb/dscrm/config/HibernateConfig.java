/**
 * 
 */
package org.herb.dscrm.config;

import java.util.Properties;

import javax.annotation.Resource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author herb
 *
 */
@Configuration
@Profile("prod")
@PropertySource("classpath:application.properties")
public class HibernateConfig {

	@Resource
	Environment env;
	
	@Autowired
	DBConfig dbConfig;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		entityManagerFactoryBean.setDataSource(dbConfig.dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty("hibernate.packages_to_scan"));
		
		entityManagerFactoryBean.setJpaProperties(hibernateProperties());
		
		return entityManagerFactoryBean;
	}
	
	private Properties hibernateProperties() {
        Properties properties = new Properties();
        
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.setProperty("connection.pool_size", env.getProperty("hibernate.pool_size"));
        
        return properties;
    }
 
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
	

}
