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
import org.herb.dscrm.controller.TeamController;
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
public class TeamControllerTest {

	@Autowired
	TeamController teamController;
	
	

	@Test
	public void testHeroPage() throws Exception {
		MockMvc mockMVC = standaloneSetup(teamController).build();

		mockMVC.perform(get("/team")).andExpect(view().name("teams"));
	}
	
	
}
