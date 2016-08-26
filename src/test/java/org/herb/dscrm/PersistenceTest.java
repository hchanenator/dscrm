/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.persistence.api.HeroRepository;
import org.herb.dscrm.test.config.TestHibernateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSCRM.class})
@ActiveProfiles("test")
public class PersistenceTest {
	
	private final List<Hero> heroes = new ArrayList<>();
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TestHibernateConfig hibernateConfig;
	
	@Autowired
	HeroRepository heroRepository;
	
	@Test
	public void testGetHibernateSession() {
		assertNotNull(hibernateConfig.sessionFactory(dataSource));
	}
	
	@Test
	public void testSaveEmployee() {
		Hero hero = new Hero();
		
		hero.setFirstName("Wade");
		hero.setLastName("Wilson");
		hero.setAlias("Deadpool");
				
		heroRepository.save(hero);
		
		assertNotNull(heroRepository.findByLastName("Wilson"));
	}
	
	@Test
	public void testManyEmployees() {
		
		long count = heroRepository.count();
		System.out.printf("# of Employees: %d\n", count);
		assertTrue(count > 0);
	}
	
//	@Test
	public void testFindHeroByAlias() {
		Hero hero = heroRepository.findByAlias("Spiderman");
		assertEquals("Spiderman", hero.getAlias());
	}
	
//	@Test
	public void testFindAllEmployees() {
		makeHeroes();
		saveHeroes();
		List<Hero> heroes = heroRepository.findAll();
		assertNotNull(heroes);
		for (Hero employee : heroes) {
			System.out.println(employee.toString());
		}
	}
	
	private void makeHeroes() {
		
		heroes.add(new Hero("Steve", "Rogers", "Captain America"));
		heroes.add(new Hero("Tony", "Stark", "Iron Man"));
		heroes.add(new Hero("Bruce", "Banner", "Hulk"));
		heroes.add(new Hero("Natasha", "Romanov", "Black Widow"));
		heroes.add(new Hero("Clark", "Kent", "Superman"));
		heroes.add(new Hero("Bruce", "Wayne", "Batman"));
		
	}
	
	private void saveHeroes() {
		for (Hero hero : heroes) {
			heroRepository.save(hero);
		}
	}

}
