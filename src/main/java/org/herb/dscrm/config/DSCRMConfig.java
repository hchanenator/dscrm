/**
 * 
 */
package org.herb.dscrm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * @author herb
 *
 */
@Configuration
@ComponentScan(basePackages={"org.herb.dscrm"})
public class DSCRMConfig {
	

}
