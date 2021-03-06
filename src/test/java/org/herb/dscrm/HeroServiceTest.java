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
@ContextConfiguration(classes = { DSCRM.class })
public class HeroServiceTest {

	@Autowired
	HeroService heroService;
	
	private final List<Hero> heroes = new ArrayList<>();

	@Test
	public void testFindHero() {
		Hero hero = new Hero("Wade", "Wilson", "Deadpool");
		heroService.addHero(hero);

		Hero oldHero = heroService.findHeroByAlias("Deadpool");
		assertNotNull(oldHero);
	}

	@Test
	public void testAddHeroes() {
		makeHeroes();
		saveHeroes();
		assertTrue(7 <= heroService.findAllHeroes().size());  // 7 because Deadpool + 6 from makeHeroes()

	}

	private void makeHeroes() {

		heroes.add(new Hero("Steve", "Rogers", "Captain America"));
		heroes.add(new Hero("Tony", "Stark", "Iron Man"));
		heroes.add(new Hero("Bruce", "Banner", "Hulk"));
		heroes.add(new Hero("Natasha", "Romanoff", "Black Widow"));
		heroes.add(new Hero("Clark", "Kent", "Superman"));
		heroes.add(new Hero("Bruce", "Wayne", "Batman"));

	}

	private void saveHeroes() {
		for (Hero hero : heroes) {
			heroService.addHero(hero);
		}
	}

	@Test
	public void testDeleteHero() {
		// First add the Hero
		Hero lameHero = new Hero("Howard", "Duck", "Howie");
		heroService.addHero(lameHero);
		
		// Now get the Hero
		lameHero = heroService.findHeroByAlias("Howie");
		
		// First test that the Hero is there
		assertNotNull(lameHero);
		
		// Now delete the poor shmuck!
		heroService.deleteHeroById(lameHero.getHeroId());
		
		// And test that the Hero is NOT there
		assertNull(heroService.findHeroByAlias("Howie"));
	}
}
