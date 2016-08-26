/**
 * ...but NOBODY controls the Heroes...do they..?
 */
package org.herb.dscrm.controller;

import javax.servlet.http.HttpServletRequest;

import org.herb.dscrm.domain.entity.Hero;
import org.herb.dscrm.system.service.api.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author herb
 *
 */
@Controller
public class HeroController {
	
	@Autowired
	HeroService heroService;
	
	@RequestMapping("/showheroes")
	public String list(Model model) {
		model.addAttribute("heroesList", heroService.findAllHeroes());
		return "heroes";
	}
	
	@RequestMapping(value="/addnewhero", method=RequestMethod.GET)
	public String getAddAHeroForm(Model model) {
		Hero hero = new Hero();
		model.addAttribute("newHero", hero);
		return "addhero";
	}
	
	@RequestMapping(value="/addnewhero", method=RequestMethod.POST)
	public String processAddAHero(@ModelAttribute("newHero") Hero hero, BindingResult result, HttpServletRequest request) {
		
		if (result.hasErrors()) {
			return "addhero";
		}
		
		heroService.addHero(hero);
		
		return "redirect:showheroes";
	}
	
	@RequestMapping(value="/deletehero", method=RequestMethod.POST)
	public String processDeleteHero(Model model, @RequestParam("heroID") String heroId) {
		heroService.deleteHeroById(Long.parseLong(heroId));
		return "redirect:showheroes";
	}
	

}
