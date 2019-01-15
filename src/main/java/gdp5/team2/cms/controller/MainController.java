/**
 * 
 */
package gdp5.team2.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author User
 *
 */
@Controller
public class MainController {
	@RequestMapping("/login")
	public String login() {
		
		return "login.html";
	}
	@RequestMapping("/index")
	public String index() {
		return "index.html";
	}
	@GetMapping("/404")
	public String ds() {
		return "404.html";
	}
}
