/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import org.herb.dscrm.config.DSCRMConfig;
import org.herb.dscrm.config.HibernateConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSCRMConfig.class})
public class PersistenceTest {
	
	@Autowired
	HibernateConfig hibernateConfig;
	
	public void testGetHibernateSession() {
		
	}

}
