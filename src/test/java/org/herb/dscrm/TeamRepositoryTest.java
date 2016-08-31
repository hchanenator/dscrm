/**
 * 
 */
package org.herb.dscrm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.herb.dscrm.domain.entity.Team;
import org.herb.dscrm.domain.entity.Universe;
import org.herb.dscrm.system.persistence.api.TeamRepository;
import org.herb.dscrm.system.persistence.api.UniverseRepository;
import org.herb.dscrm.test.config.TestHibernateConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author herb
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DSCRM.class})
@ActiveProfiles("test")
public class TeamRepositoryTest {
	
	private final List<Team> teams = new ArrayList<>();
	
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	TestHibernateConfig hibernateConfig;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Test
	public void testGetHibernateSession() {
		assertNotNull(hibernateConfig.sessionFactory(dataSource));
	}
	
	@Test
	public void testSaveUniverse() {
		Team team = new Team();
		team.setTeamName("Avengers");
				
		teamRepository.save(team);
		
		assertNotNull(teamRepository.findByTeamName("Avengers"));
	}

}
