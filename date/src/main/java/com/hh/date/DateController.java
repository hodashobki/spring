package com.hh.date;
import java.util.Date;
import java.text.SimpleDateFormat; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DateController {
	@RequestMapping("")
    public String hello() {
            return "index.jsp";
    }

	@RequestMapping("/time")
    public String hello1(Model viewModel) {
		 Date time = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm a");  
		   
		    viewModel.addAttribute("thetime",  formatter.format(time));
		
            return "index1.jsp";
    }
	@RequestMapping("/date")
    public String hello2(Model viewModel) {
		 Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("E,'the' dd 'of' MMM yyyy");  
		   
		    
		   
		    viewModel.addAttribute("thedate",formatter.format(date));
            return "index2.jsp";
    }
}
