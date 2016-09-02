/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.service.api.HeroService;
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
public class ExternalDBTest {
	
	@Autowired
	HeroService heroService;
	
	@Test
	public void getHeroesTest() {
		List<Hero> heroes = new ArrayList<>();
		
		heroes = heroService.findAllHeroes();
		
		System.out.println("# of Heroes: " + heroes.size());
//		assertTrue(heroes.size() > 0);
	}

}
