package gdp5.team2.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import gdp5.team2.cms.service.RolesService;
import gdp5.team2.cms.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RolesService rolesService;
	
	@RequestMapping("/user")
	public String indexUser(Model model) {
		model.addAttribute("listUser", userService.findAll());
		return "listUser";
	}
	
	@GetMapping("/listUser/view/{id}")
	public String viewNews(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.findOne(id));
		model.addAttribute("listRoles", rolesService.findAll());
		return "infoUser";
	}
}
