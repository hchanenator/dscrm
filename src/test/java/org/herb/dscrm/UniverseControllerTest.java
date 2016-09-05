/**
 * 
 */
package org.herb.dscrm;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.herb.dscrm.controller.UniverseController;
import org.herb.dscrm.domain.entity.Universe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * @author hchan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DSCRM.class })
@ActiveProfiles("test")
public class UniverseControllerTest {

	@Autowired
	UniverseController universeController;

	@Test
	public void testUniverseController() throws Exception {
		MockMvc mockMvc = standaloneSetup(universeController).build();

		mockMvc.perform(get("/universe")).andExpect(view().name("universes"));
	}

	@Test
	public void testGetAddUniversePage() throws Exception {
		MockMvc mockMvc = standaloneSetup(universeController)
				.setSingleView(new InternalResourceView("/WEB-INF/view/adduniverse.jsp")).build();

		mockMvc.perform(get("/universe/addUniverse")).andExpect(view().name("adduniverse"));

	}
	
	@Test
	public void testSaveAddUniversePage() throws Exception {
		MockMvc mockMvc = standaloneSetup(universeController)
				.setSingleView(new InternalResourceView("/WEB-INF/view/adduniverse.jsp")).build();
		
		mockMvc.perform(post("/universe/addUniverse")).andExpect(view().name("universes"));
		

	}

}
