package com.hh.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/secret")
	public String form(@RequestParam(value="secretBox") String s1, RedirectAttributes redirectAttributes ){
		if (s1.equals("bushido")) {
			return "redirect:/bushido";
		} else {
			 redirectAttributes.addFlashAttribute("error", "Train Harder!");
			return "redirect:/";
		}
	}
	@RequestMapping("/bushido")
	public String code(){
		return "bushido.jsp";
		
	}
	}

