package com.Hoda.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DojoController {
	@RequestMapping("/")
	public String dojo() {
		return "dojo.jsp";
	}
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(HttpSession session,@RequestParam(value="name") String name,@RequestParam(value="location") String location,@RequestParam(value="lang") String lang,@RequestParam(value="comment") String comment) {
		session.getAttribute("name");
		session.setAttribute("name", name);
//		****
		session.getAttribute("location");
		session.setAttribute("location", location);
//		*****
		session.getAttribute("lang");
		session.setAttribute("lang", lang);
//		*************
		session.getAttribute("comment");
		session.setAttribute("comment", comment);
		return "redirect:/passed";
	}
@RequestMapping("/passed")
public String passed() {
	return "display.jsp";
}
}
