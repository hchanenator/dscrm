/**
 * 
 */
package org.herb.dscrm.controller;

import org.herb.dscrm.domain.entity.Team;
import org.herb.dscrm.domain.entity.Universe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author hchan
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String teamMain(Model model) {
		Team team = new Team("Avengers");
		Universe universe = new Universe("Marvel");
		model.addAttribute("team", team);
		model.addAttribute("universe", universe);
		return "teams";
	}

}
