package gdp5.team2.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class NewsController {
	
	@RequestMapping("/news")
	public String showNews() {
		return "pages/listNews.html";
	}
}
