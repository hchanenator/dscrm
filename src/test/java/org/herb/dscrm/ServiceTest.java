/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

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
public class ServiceTest {
	
	@Autowired
	HeroService heroService;
	
	@Test
	public void testFindHero() {
		Hero hero = new Hero("Wade", "Wilson", "Deadpool");
		heroService.addHero(hero);
		
		Hero oldHero = heroService.findHeroByAlias("Deadpool");
		assertNotNull(oldHero);
	}

}
