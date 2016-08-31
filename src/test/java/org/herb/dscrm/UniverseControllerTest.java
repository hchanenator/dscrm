/**
 * 
 */
package org.herb.dscrm;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.herb.dscrm.controller.UniverseController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

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

}
