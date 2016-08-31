/**
 * 
 */
package org.herb.dscrm;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.herb.dscrm.controller.HeroController;
import org.herb.dscrm.controller.HomeController;
import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.persistence.api.HeroRepository;
import org.herb.dscrm.system.service.api.HeroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceView;


/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSCRM.class})
@EnableWebMvc
@ActiveProfiles("test")
public class HomeControllerTest {
	
	private static Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);
	
	@Test
	public void testHomeController() throws Exception {
		HomeController homeController = new HomeController();
		MockMvc mockMvc = standaloneSetup(homeController).build();
		
		mockMvc.perform(get("/")).andExpect(view().name("welcome"));
		
//		logger.info(view().toString());
		
	}

}
