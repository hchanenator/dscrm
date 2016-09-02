package org.herb.dscrm;
import static org.junit.Assert.*;

import java.util.List;

import org.herb.dscrm.DSCRM;
import org.herb.dscrm.domain.entity.Universe;
import org.herb.dscrm.system.service.api.UniverseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 */

/**
 * @author hchan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSCRM.class})
@ActiveProfiles("test")
public class UniverseServiceTest {
	
	@Autowired
	UniverseService universeService;

	
	@Test
	public void testSaveUniverse() {
		Universe universe = new Universe();
		universe.setLocationName("Other");
				
		universeService.addUniverse(universe);
		
		assertNotNull(universeService.findUniverse("Other"));
	}
	
	@Test
	public void testFindAllUniverses() {
		Universe marvel = new Universe("Marvel");
		universeService.addUniverse(marvel);
		
		Universe dc = new Universe("DC");
		universeService.addUniverse(dc);

		List<Universe> universes = universeService.findAllUniverses();
		
		assertTrue(universes.size() > 1);
	}
	
}
