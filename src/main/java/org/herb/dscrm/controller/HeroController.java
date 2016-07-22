/**
 * ...but NOBODY controls the Heroes...do they..?
 */
package org.herb.dscrm.controller;

import org.herb.dscrm.system.service.api.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author herb
 *
 */
@Controller
public class HeroController {
	
	@Autowired
	HeroService heroService;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/showheroes")
	public String list(Model model) {
		model.addAttribute("heroesList", heroService.findAllHeroes());
		return "heroes";
	}

}
