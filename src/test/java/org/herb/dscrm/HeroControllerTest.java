/**
 * 
 */
package org.herb.dscrm;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.herb.dscrm.controller.HeroController;
import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.persistence.api.HeroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
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
public class HeroControllerTest {

	@Autowired
	HeroController heroController;

	@Test
	public void testHeroPage() throws Exception {
		MockMvc mockMVC = standaloneSetup(heroController).build();

		mockMVC.perform(get("/showheroes")).andExpect(view().name("heroes"));
	}

	@Test
	public void testShowHeroesPage() throws Exception {
		List<Hero> heroes = createHeroesList();

		HeroRepository mockRepository = mock(HeroRepository.class);

		when(mockRepository.findAll()).thenReturn(heroes);

		MockMvc mockMvc = standaloneSetup(heroController)
				.setSingleView(new InternalResourceView("/WEB-INF/view/Hero.jsp")).build();

		mockMvc.perform(get("/showheroes")).andExpect(view().name("heroes"))
				.andExpect(model().attributeExists("heroeList"))
				.andExpect(model().attribute("heroeList", Matchers.hasItems(heroes.toArray())));
		
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
}
