/**
 * 
 */
package org.herb.dscrm.system.service.api;

import java.util.List;

import org.herb.dscrm.domain.entity.Universe;

/**
 * @author hchan
 *
 */
public interface UniverseService {
	
	Universe findUniverse(String name);
	void addUniverse(Universe universe);
	List<Universe> findAllUniverses();

}
