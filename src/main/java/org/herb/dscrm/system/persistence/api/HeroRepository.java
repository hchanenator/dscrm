/**
 * 
 */
package org.herb.dscrm.system.persistence.api;

import java.util.List;

import org.herb.dscrm.domain.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author herb
 *
 */
public interface HeroRepository extends JpaRepository<Hero, Long> {
	
	Hero findByLastName(String lastName);
	Hero findByAlias(String alias);
	
	
}
