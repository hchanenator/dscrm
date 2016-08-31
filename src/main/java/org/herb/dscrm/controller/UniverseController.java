/**
 * 
 */
package org.herb.dscrm.controller;

import org.herb.dscrm.system.service.api.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hchan
 *
 */
@Controller
@RequestMapping("/universe")
public class UniverseController {
	
	@Autowired
	UniverseService universeService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String universeMain(Model model) {
		model.addAttribute("allUniverses", universeService.findAllUniverses());
		return "universes";
	}

}
