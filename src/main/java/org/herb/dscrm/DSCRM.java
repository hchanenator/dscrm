/**
 * 
 */
package org.herb.dscrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author hchan
 *
 */
@SpringBootApplication
@ActiveProfiles("prod")
public class DSCRM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DSCRM.class);

	}

}
