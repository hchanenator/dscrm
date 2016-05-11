/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.herb.dscrm.config.HibernateConfig;
import org.herb.dscrm.domain.entity.Employee;
import org.herb.dscrm.system.persistence.EmployeeRepository;
import org.junit.Test;
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
	DataSource dataSource;
	
	@Autowired
	HibernateConfig hibernatConfig;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	public void testGetHibernateSession() {
		assertNotNull(hibernatConfig.sessionFactory(dataSource));
	}
	
	@Test
	public void testSaveEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Marco");
		employee.setLastName("Polo");
		
		employeeRepository.save(employee);
		
//		assertNotNull(employeeRepository.findAll());
		assertNotNull(employeeRepository.findByLastName("Polo"));
	}

}
