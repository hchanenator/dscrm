/**
 * 
 */
package org.herb.dscrm.controller;

import javax.servlet.http.HttpServletRequest;

import org.herb.dscrm.domain.entity.Universe;
import org.herb.dscrm.system.service.api.UniverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value="/addUniverse", method=RequestMethod.GET)
	public String addUniverse(Model model) {
		Universe universe = new Universe();
		model.addAttribute("newUniverse", universe);
		return "adduniverse";
	}
	
	@RequestMapping(value="/addUniverse", method=RequestMethod.POST)
	public String saveNewUniverse(@ModelAttribute("newUniverse") Universe universe, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "adduniverse";
		}
		
		universeService.addUniverse(universe);
		
		return "redirect:universes";
	}

}
