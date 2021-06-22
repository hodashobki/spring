package com.Hoda.lookify.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.lookify.models.Lookify;
import com.Hoda.lookify.service.Lookifyservices;

@Controller
public class BookifyController {
	private final Lookifyservices lookifyservices;

	public BookifyController(Lookifyservices lookifyservices) {
		this.lookifyservices= lookifyservices;
	}
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
public String dashboared(Model model) {
		List<Lookify> lookify = lookifyservices.allLooki();
		model.addAttribute("lookify", lookify);
	return "dash.jsp";
}
	@RequestMapping("/song/new")
	public String addnew() {
		return "adds.jsp";
	}
//	*****
	@RequestMapping(value = "/creatsong", method = RequestMethod.POST)
	public String show2(@RequestParam(value = "title") String title, @RequestParam(value = "artist") String artist,
			@RequestParam(value = "rating") Integer rating) {
		Lookify lookify = new Lookify(title, artist, rating);
		lookifyservices.creatllooki(lookify);
		return "redirect:/dashboard";
	}
//	********************view songs
	@RequestMapping("/song/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Lookify lookify = lookifyservices.findLooki(id);
		model.addAttribute("lookify", lookify);
		return "view.jsp";
	}	
	
//******************delete
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		lookifyservices.deletelanguage(id);
		return "redirect:/dashboard";
	}
//	*****************search
	@RequestMapping("/search/{search}" )
	public String cearch(@PathVariable("search") String search, Model model) {
		List<Lookify> result=lookifyservices.lookiContainingArtist(search);
		List<Lookify> result2=lookifyservices.lookiContainingTitle(search);
		model.addAttribute("lookify",result);
		model.addAttribute("lookify",result2);
		return "search.jsp";
	}
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("search") String search) {
		return "redirect:/search/"+search;
	}
//	*********************top
	@RequestMapping("/search/topten")
	public String TopTen(Model model) {
		List<Lookify> lookify=lookifyservices.rating();
		model.addAttribute("lookify",lookify);
		
//		model.addAttribute("songs",lookifyservices.rating());
		return "top.jsp";
	}
	
}
