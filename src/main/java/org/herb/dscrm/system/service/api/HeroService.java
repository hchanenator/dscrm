/**
 * 
 */
package org.herb.dscrm.system.service.api;

import java.util.List;

import org.herb.dscrm.domain.entity.Hero;

/**
 * @author herb
 *
 */
public interface HeroService {
	List<Hero> findAllHeroes();
	Hero findHeroByLastName(String lastName);
	Hero findHeroByAlias(String alias);
	void addHero(Hero hero);
	void deleteHeroById(Long id);
}
