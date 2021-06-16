package com.hh.counter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class CounterController {
	public int cou=0;
	@RequestMapping("/your_server/counter")
    public String counter(HttpSession session, Model model) {
	
		session.setAttribute("visit",this.cou);
		int visit1= (int) session.getAttribute("visit");
		model.addAttribute("key1", visit1);

            return "counter.jsp";
    }
	@RequestMapping("/your_server")
    public String server() {
		int coun=(int) this.cou++;
//		int coun=(int) this.cou++;
//		session.setAttribute("visit",coun);
//		int visit1= (int) session.getAttribute("visit");
//		model.addAttribute("key", visit1);
            return "server.jsp";
    }
	@RequestMapping("/plustwo")
public String plusTwo() {
		this.cou+=2;
	return "plus2.jsp";
}
	@RequestMapping("/destroy")
	public String destroy(HttpServletRequest se) {
		this.cou=0;
		se.getSession().invalidate();
		return "redirect:/your_server/counter";
	}
}
