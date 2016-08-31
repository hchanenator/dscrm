/**
 * 
 */
package org.herb.dscrm.system.persistence.api;

import org.herb.dscrm.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hchan
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findByTeamName(String name);
}
