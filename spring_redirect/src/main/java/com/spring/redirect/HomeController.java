package com.spring.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping(value="/redirect")
	public String redirect(HttpServletRequest request, RedirectAttributes rttr) {
		String url = "redirect:/target";
		
		rttr.addAttribute("data", 1234);
		
		rttr.addFlashAttribute("data", 1234);
		
		return url;
	}
	
	@RequestMapping(value="/target")
	public String target(HttpServletRequest request, RedirectAttributes rttr) {
		String url = "final";

		return url;
	}
	
}
