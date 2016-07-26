/**
 * 
 */
package org.herb.dscrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author herb
 *
 */
@Controller
public class HomeController {
	

	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Hi there Kaeley!");
		model.addAttribute("awesomeness", "You're dad is AWESOME!!!");
		return "welcome";
	}
	

}
