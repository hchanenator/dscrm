/**
 * 
 */
package org.herb.dscrm;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author herb
 *
 */
@Configuration
@ComponentScan(basePackages={"org.herb.dscrm"})
@EnableAutoConfiguration(exclude={JpaRepositoriesAutoConfiguration.class})
@EnableJpaRepositories
public class DSCRMConfig {
	

}
