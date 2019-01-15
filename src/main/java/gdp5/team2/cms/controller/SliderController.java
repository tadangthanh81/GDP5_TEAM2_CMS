package gdp5.team2.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gdp5.team2.cms.entity.Slider;
import gdp5.team2.cms.service.SliderService;

@Controller
public class SliderController {

	@Autowired
	SliderService sliderService;

	@RequestMapping("/slider")
	public String listSlider(Model model) {
		model.addAttribute("sliders", sliderService.findAll());
		return "listSlider";
	}

	@GetMapping("/slider/create")
	public String create(Model model) {
		model.addAttribute("slider", new Slider());
		return "fromSlider";
	}

	@GetMapping("/slider/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("slider", sliderService.findById(id));
		return "fromSlider";
	}

	@RequestMapping("/slider/save")
	public String createSlider(@Valid Slider slider, BindingResult result, RedirectAttributes redirect) {

		if (result.hasErrors()) {
			return "/index";
		}
		sliderService.save(slider);
		redirect.addFlashAttribute("message", "Saved employee successfully!");
		return "redirect:/index";
	}
	@GetMapping("/slider/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		sliderService.delete(id);
		redirect.addFlashAttribute("success", "Deleted employee successfully!");
		return "redirect:/index";
	}

}
