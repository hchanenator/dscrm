/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.herb.dscrm.controller.HeroController;
import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.persistence.api.HeroRepository;
import org.herb.dscrm.system.service.api.HeroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DSCRM.class })
@ActiveProfiles("test")
public class HeroControllerTest {

	@Autowired
	HeroController heroController;

	@Autowired
	HeroRepository heroRepository;

	@Test
	public void testHeroPage() throws Exception {
		MockMvc mockMVC = standaloneSetup(heroController).build();

		mockMVC.perform(get("/showheroes")).andExpect(view().name("heroes"));
	}

	@Test
	public void testShowHeroesPage() throws Exception {
		List<Hero> heroes = createHeroesList();
		saveHeroesList(heroes);

		HeroService mockService = mock(HeroService.class);

		when(mockService.findAllHeroes()).thenReturn(heroes);

		MockMvc mockMvc = standaloneSetup(heroController)
				.setSingleView(new InternalResourceView("/WEB-INF/view/hero.jsp")).build();

		mockMvc.perform(get("/showheroes")).andExpect(view().name("heroes"))
				.andExpect(model().attributeExists("heroesList"))
				.andExpect(model().attribute("heroesList", Matchers.hasItems(heroes.toArray())));

	}

	@Test
	public void testAddHeroPage() throws Exception {
		MockMvc mockMvc = standaloneSetup(heroController).build();

		mockMvc.perform(get("/addnewhero")).andExpect(view().name("addhero"));
	}

	@Test
	public void testAddingAHero() throws Exception {
//		Hero someHero = new Hero("Natasha", "Romanoff", "Black Widow");

		MockMvc mockMvc = standaloneSetup(heroController)
				.setSingleView(new InternalResourceView("/WEB-INF/view/addhero.jsp")).build();

		mockMvc.perform(post("/addnewhero").sessionAttr("newHero", new Hero())
				.param("firstName", "Natasha")
				.param("lastName", "Romanoff")
				.param("alterEgo", "Black Widow"))
		.andExpect(view().name("redirect:showheroes"));
	}

	private List<Hero> createHeroesList() {
		List<Hero> heroes = new ArrayList<Hero>();

		heroes.add(new Hero("Steve", "Rogers", "Captain America"));
		heroes.add(new Hero("Tony", "Stark", "Iron Man"));
		heroes.add(new Hero("Bruce", "Banner", "Hulk"));
		heroes.add(new Hero("Natasha", "Romanov", "Black Widow"));
		heroes.add(new Hero("Clark", "Kent", "Superman"));
		heroes.add(new Hero("Bruce", "Wayne", "Batman"));

		return heroes;
	}

	private void saveHeroesList(List<Hero> heroes) {
		for (Hero hero : heroes) {
			heroRepository.save(hero);
		}
	}
}
