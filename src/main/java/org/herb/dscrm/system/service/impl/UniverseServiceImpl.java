/**
 * 
 */
package org.herb.dscrm.system.service.impl;

import java.util.List;

import org.herb.dscrm.domain.entity.Universe;
import org.herb.dscrm.system.persistence.api.UniverseRepository;
import org.herb.dscrm.system.service.api.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hchan
 *
 */
@Service
public class UniverseServiceImpl implements UniverseService {

	@Autowired
	UniverseRepository universeRepository;
	
	@Override
	public Universe findUniverse(String name) {
		
		return universeRepository.findByLocationName(name);
	}

	@Override
	public void addUniverse(Universe universe) {
		universeRepository.save(universe);
		
	}

	@Override
	public List<Universe> findAllUniverses() {
		
		return universeRepository.findAll();
	}

	
}
