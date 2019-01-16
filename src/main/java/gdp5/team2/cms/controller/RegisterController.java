package gdp5.team2.cms.controller;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gdp5.team2.cms.entity.Users;
import gdp5.team2.cms.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	PasswordEncoder passwordEncoder;

	public RegisterController(UserService userService, JavaMailSender emailSender) {
		super();
		this.userService = userService;
		this.emailSender = emailSender;
	}

	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("userRegister", new Users());
		return "register";
	}
	
	@PostMapping("/register/save")
	public String save(@Valid Users userRegister2, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "register";
		}
		
		
		else {
			String emailRegister = userRegister2.getEmail();
			Iterable<Users> listUser = userService.findAll();
			for (Users u : listUser) {
				if(emailRegister.contains(u.getEmail())) {
					redirect.addFlashAttribute("fail", "Email had exists!");
					return "redirect:/register";
				}
			}
			
			String random = (new Random().nextInt(899999) + 10000) + "";
			String pass = userRegister2.getPassword();
			userRegister2.setPassword(passwordEncoder.encode(pass));
			userService.save(userRegister2);
			redirect.addFlashAttribute("success", "Register successtion");
//	        SimpleMailMessage message = new SimpleMailMessage();
//	          
//	        message.setTo(userRegister2.getEmail());
//	        message.setSubject("Send Password");
//	        message.setText("Your password:"
//					+ userRegister2.getPassword());
//	 
//	        // Send Message!
//	        this.emailSender.send(message);
	        return "redirect:/register";
		}
	}
}
