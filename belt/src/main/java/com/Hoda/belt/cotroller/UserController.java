package com.Hoda.belt.cotroller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.belt.models.Comment;
import com.Hoda.belt.models.Event;
import com.Hoda.belt.models.UserEvent;
import com.Hoda.belt.models.User;
import com.Hoda.belt.services.CommentService;
import com.Hoda.belt.services.EventService;
import com.Hoda.belt.services.UserService;
import com.Hoda.belt.validator.UserValidator;

@Controller
public class UserController {
@Autowired
private UserService userService;

@Autowired 
private CommentService comSer;
@Autowired
private EventService eveSer;
@Autowired
private UserValidator userValidator;

@GetMapping("/")
public String index(@ModelAttribute("user") User user) {
	return "index.jsp";
}
@PostMapping("/")

	 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,Model model) {
	    	 userValidator.validate(user, result);
	    	if(result.hasErrors()) {
	    	return "index.jsp";
	    	}
	    	if(userService.findByEmail(user.getEmail())!=null) {
	    		model.addAttribute("error","This Email already exist");
	    		return "index.jsp";
	    	}
	    	userService.registerUser(user);
	    	session.setAttribute("userId", user.getId());
	    		return "redirect:/events"; 
	    }
@RequestMapping(value="/login", method=RequestMethod.POST)
public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	if(userService.authenticateUser(email, password)) {
		Long id=userService.findByEmail(email).getId();
		session.setAttribute("userId",id);
		return "redirect:/events";
	}
	else {
		model.addAttribute("error","Invalide User name or Password");
		return "loginPage.jsp";
	}
}
//*************************************************************************create,delete,edit************************ 

@RequestMapping("/events")
public String home(@Valid@ModelAttribute("event")Event event,BindingResult result,
		HttpSession session,Model model) {
	if(session.getAttribute("userId")==null)
		return "redirect/registration";

	Long id=(Long)session.getAttribute("userId");
	User u=userService.findUserById(id);
	model.addAttribute("user", u);
	List<Event>evnot=eveSer.findStateNotIn(u.getState());
	List<Event>envin=eveSer.findByStatein(u.getState());
	model.addAttribute("evn", evnot);
	model.addAttribute("evIn", envin);
	model.addAttribute("eve",eveSer.findAllEvents() );
	return "home.jsp";
}
@PostMapping("/events/new")
public String creatEvent(@Valid@ModelAttribute("event")Event event,BindingResult result,Model model,HttpSession session) {
	if(result.hasErrors()) {
		return "home.jsp";
	}
	eveSer.creatEvent(event);
	return "redirect:/events";
}
//****event show and create comments



@RequestMapping("/events/{id}")
public String showEvent(@PathVariable("id")Long id, @ModelAttribute("comment")Comment comment,HttpSession session,Model model) {
	model.addAttribute("event",eveSer.FindEvntById(id) );
	return"show.jsp";
}
@PostMapping("/events/{id}/createComment/new")
public String creatComment(@Valid@ModelAttribute("comment")Comment comment,BindingResult result,Model mode,@PathVariable("id")Long id) {
	if(result.hasErrors()) {
		return "show.jsp";
	}
	Event ev=eveSer.FindEvntById(id);
	comment.setEvent(ev);
	comSer.createComment(comment);
	return "redirect:/events/"+id;
	
}
//****delete****
@RequestMapping("/delete/{id}")
public String delete(@PathVariable("id") Long id) {
	eveSer.deleteEvent(id);
	return "redirect:/events";
}

//******update****

@RequestMapping("/events/{id}/edit")
public String edit(@PathVariable("id") Long id, Model model) {
    Event eve = eveSer.FindEvntById(id);
    model.addAttribute("event", eve);
    return "edit.jsp";
}

@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
public String update(@Valid @ModelAttribute("event") Event event, BindingResult result,@PathVariable("id") Long id) {
    if (result.hasErrors()) {
        return "edit.jsp";
    } else {
        eveSer.editEvent(event);
        return "redirect:/events";
    }
}
//*************join ***unjoin*******
@RequestMapping("/join/{id}")
public String joinEvent(@ModelAttribute("userevent")UserEvent userevent,@PathVariable("id") Long id,HttpSession session) {
	eveSer.addEventToUser(userevent);
	return "redirect:/events";
}

@RequestMapping("/unjoin/{id}")
public String unjoin(@PathVariable("id") Long id) {
	eveSer.unjoin(id);
	return "redirect:/events";
}


//****
@RequestMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
   
}



}





