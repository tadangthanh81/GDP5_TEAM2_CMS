package gdp5.team2.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gdp5.team2.cms.entity.Menu;
import gdp5.team2.cms.service.MenuService;


@Controller
public class MenuController {
	
	@Autowired
	MenuService menuService;

	@RequestMapping("/menu")
	public String listMenu(Model model) {
		model.addAttribute("menus", menuService.findAll());
		return "menu";
	}

	@GetMapping("/menu/create")
	public String create(Model model) {
		model.addAttribute("menu", new Menu());
		return "formMenu";
	}

	@GetMapping("menu/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("menu", menuService.findById(id));
		return "formMenu";
	}
	
	


	@RequestMapping("/menu/save")
	public String createSlider(@Valid Menu menu, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "/menu";
		}
		menuService.save(menu);
		redirect.addFlashAttribute("message", "Saved menu successfully!");
		return "redirect:/menu";
	}
	@GetMapping("/menu/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		menuService.delete(id);
		redirect.addFlashAttribute("success", "Deleted menu successfully!");
		return "redirect:/menu";
	}
}
