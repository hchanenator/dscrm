/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.herb.dscrm.domain.entity.Universe;
import org.herb.dscrm.domain.entity.Team;
import org.herb.dscrm.test.config.TestHibernateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hchan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DSCRM.class })
@ActiveProfiles("test")
public class TeamUniverseTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	TestHibernateConfig hibernateConfig;

	private Universe[] universes = new Universe[2];
	private List<Team> teams = new ArrayList<>();

	@Test
	public void testGetHibernateSession() {
		assertNotNull(hibernateConfig.sessionFactory(dataSource));
	}

	@Test
	public void makeNewTeams() {
		makeLocations();
		makeTeams();
		for (Team team : teams) {
			if (team.getTeamName().equalsIgnoreCase("justice league")) {
				team.setLocation(universes[1]);
			} else {
				team.setLocation(universes[0]);
			}
		}
		
//		for (Team team : teams) {
//			System.out.println(team.toString());
//		}
		
		assertEquals("Marvel", teams.get(0).getLocation().getLocationName());
		assertEquals("DC", teams.get(1).getLocation().getLocationName());
	}

	private void makeLocations() {
		universes[0] = new Universe("Marvel");
		universes[1] = new Universe("DC");
	}

	private void makeTeams() {
		teams.add(new Team("Avengers"));
		teams.add(new Team("Justice League"));
		teams.add(new Team("X-Men"));
	}
}
