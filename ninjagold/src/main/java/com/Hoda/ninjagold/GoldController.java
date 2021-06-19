package com.Hoda.ninjagold;

import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
@RequestMapping("")
public String gold(HttpSession session,Model model) {
	ArrayList<String> activity=new ArrayList<String>();
	if (session.getAttribute("counter")==null){
		session.setAttribute("counter", 0);	
	}
	if (session.getAttribute("activity")==null){
		session.setAttribute("activity",activity );	
	}
//	it worked without this:
	model.addAttribute("counter",session.getAttribute("counter"));
	model.addAttribute("activity",session.getAttribute("activity"));
//	else 
	return "gold.jsp";
}
@RequestMapping(value="process_money", method=RequestMethod.POST)
public String proceesMony(@RequestParam(value="gold") String gold,HttpSession session,Model model) {
	Random rand = new Random();
	int rangold = 0;
	int goold=(int)session.getAttribute("counter");
//	if(RequestMethod.equals"POST")
	//	ArrayList<String> activity=new ArrayList<String>;
	LocalDateTime currenttime=LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy HH:mm:ss");  
	ArrayList<String> activity=(ArrayList<String>)session.getAttribute("activity");
	if(gold.equals("farm")) {
		rangold=rand.nextInt((20-10)+1)+10;
		activity.add(String.format("You entered a farm and earned %d gold "+currenttime.format(formatter) ,rangold));
	}
	else if(gold.equals("cave")) {
		rangold=rand.nextInt((10-5)+1)+5;
		activity.add(String.format("You entered a cave and earned %d gold "+currenttime.format(formatter),rangold));
	}
	else if(gold.equals("house")) {
		rangold=rand.nextInt((5-2)+1)+2;
		activity.add(String.format("You entered a house and earned %d gold "+currenttime.format(formatter),rangold));
	}
	else if(gold.equals("casino")) {
		rangold=rand.nextInt(50+50)+1-50;
		if(rangold>0) {
			activity.add(String.format("You entered a casino and earned %d gold"+currenttime.format(formatter),rangold));
		}
		else {
			activity.add(String.format("<span style='color:red;'>You entered a casino and lost %d gold..Outch</span>",rangold));
		}
	}
	int totalgold=rangold+=goold;
	session.setAttribute("counter", totalgold);
	session.setAttribute("activity",activity );
	
	
	return "redirect:/";
	
}
@RequestMapping("/reset")
public String logout(HttpSession session) {
	
		session.invalidate();
	return "redirect:/";
}
}
