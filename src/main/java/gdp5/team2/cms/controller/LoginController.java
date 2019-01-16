/**
 * 
 */
package gdp5.team2.cms.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gdp5.team2.cms.service.UserService;

/**
 * @author User
 *
 */
@Controller
public class LoginController {

	@Autowired
	UserService userService;

	/**
	 * @param email
	 * @param pass
	 * @param httpServletResponse
	 * @return
	 */
//	@PreAuthorize("!isAuthenticated()")
	@RequestMapping("/login")
	public String login(Principal principal) {
		if (principal != null) {
			return "index.html";
		} else
			return "login.html";
	}
}
