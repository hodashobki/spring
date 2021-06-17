package com.Hoda.counter2;

//import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterControl {
	@RequestMapping("/")
	public String welcome(HttpSession session) {
		if (session.getAttribute("counter")==null){
			session.setAttribute("counter", 0);	
		}
		else {
			int count=(int)session.getAttribute("counter");
			count++;
			session.setAttribute("counter",count );
		}
		return "index.jsp";
	}
	@RequestMapping("/addtwo")
	public String addtwo(HttpSession session) {
		if(session.getAttribute("counter")==null) {
			 session.setAttribute("counter",0);
		}
		else { 
			int add2=(int)session.getAttribute("counter");
		    add2+=2;
		    session.setAttribute("counter",add2);
		}
		return "addtwo.jsp";
	}
	@RequestMapping("/count")
	public String count(HttpSession session,Model model){
		Integer newcount=(Integer)session.getAttribute("counter");
		if (newcount==null) {
			model.addAttribute("key", 0);
		}
		else {
			model.addAttribute("key", newcount);
			
		}
		return "index2.jsp";
	}
	@RequestMapping("/destroy")
	public String destroy(HttpSession session) {
	session.setAttribute("counter", 0);
		return "redirect:/count";
		
	}

}
