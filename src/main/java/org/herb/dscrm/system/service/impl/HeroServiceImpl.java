/**
 * 
 */
package org.herb.dscrm.system.service.impl;

import java.util.List;

import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.persistence.api.HeroRepository;
import org.herb.dscrm.system.service.api.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author herb
 *
 */
@Service
public class HeroServiceImpl implements HeroService {
	
	@Autowired
	HeroRepository heroRepository;

	/* (non-Javadoc)
	 * @see org.herb.dscrm.system.service.api.HeroService#getAllHeroes()
	 */
	@Override
	public List<Hero> findAllHeroes() {
		
		return heroRepository.findAll();
	}

	@Override
	public Hero findHeroByLastName(String lastName) {
		
		return heroRepository.findByLastName(lastName);
	}

	@Override
	public Hero findHeroByAlias(String alias) {
		
		return heroRepository.findByAlias(alias);
	}

	/* (non-Javadoc)
	 * @see org.herb.dscrm.system.service.api.HeroService#addHero(org.herb.dscrm.domain.entity.Hero)
	 */
	@Override
	public void addHero(Hero hero) {
		heroRepository.save(hero);
		
	}
	
	

}