/**
 * 
 */
package org.herb.dscrm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author herb
 *
 */
@Configuration
public class HibernateConfig {

	private final String dialect = "org.hibernate.dialect.HSQLDialect";


	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) {
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		sfb.setDataSource(ds);
		sfb.setPackagesToScan(new String[] { "org.herb.dscrm.domain" });

		Properties props = new Properties();
		props.setProperty("dialect", dialect);
		props.setProperty("show_sql", "true");
		props.setProperty("hbm2ddl.auto", "create");

		sfb.setHibernateProperties(props);

		return sfb;
	}
	
	

}
