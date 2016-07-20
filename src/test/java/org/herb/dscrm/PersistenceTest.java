/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
@ContextConfiguration(classes={DSCRM.class})
public class PersistenceTest {
	
	private final List<Employee> employees = new ArrayList<>();
	
	
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
		employee.setFirstName("Wade");
		employee.setLastName("Wilson");
		employee.setAlias("Deadpool");
		
		employeeRepository.save(employee);
		
//		assertNotNull(employeeRepository.findAll());
		assertNotNull(employeeRepository.findByLastName("Wilson"));
	}
	
	@Test
	public void testManyEmployees() {
		
		long count = employeeRepository.count();
		System.out.printf("# of Employees: %d\n", count);
		assertTrue(count > 0);
	}
	
	@Test
	public void testWhoIsIt() {
		Employee hero = employeeRepository.findOne(1l);
		assertEquals("Deadpool", hero.getAlias());
	}
	
	@Test
	public void testFindAllEmployees() {
		makeEmployees();
		saveEmployees();
		List<Employee> heroes = employeeRepository.findAll();
		assertNotNull(heroes);
		for (Employee employee : heroes) {
			System.out.println(employee.toString());
		}
	}
	
	private void makeEmployees() {
		
		employees.add(new Employee("Steve", "Rogers", "Captain America"));
		employees.add(new Employee("Tony", "Stark", "Iron Man"));
		employees.add(new Employee("Bruce", "Banner", "Hulk"));
		employees.add(new Employee("Natasha", "Romanov", "Black Widow"));
		employees.add(new Employee("Clark", "Kent", "Superman"));
		employees.add(new Employee("Bruce", "Wayne", "Batman"));
		
	}
	
	private void saveEmployees() {
		for (Employee employee : employees) {
			employeeRepository.save(employee);
		}
	}

}
