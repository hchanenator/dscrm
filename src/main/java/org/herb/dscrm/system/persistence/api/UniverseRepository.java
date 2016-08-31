/**
 * 
 */
package org.herb.dscrm.system.persistence.api;

import org.herb.dscrm.domain.entity.Universe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hchan
 *
 */
public interface UniverseRepository extends JpaRepository<Universe, Long> {
	
	Universe findByLocationName(String name);

}
