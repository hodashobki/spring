package com.Hoda.dojoNinja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Hoda.dojoNinja.models.Dojo;
import com.Hoda.dojoNinja.models.Ninja;
import com.Hoda.dojoNinja.services.DojoServices;
import com.Hoda.dojoNinja.services.NinjaServices;
@Controller
public class NinjaController {
private final DojoServices dojoServices;
private final NinjaServices ninjaServices;
public NinjaController(DojoServices dojoServices, NinjaServices ninjaServices) {
	this.dojoServices = dojoServices;
	this.ninjaServices = ninjaServices;
}
@RequestMapping("")
public String index() {
	return "index.jsp";
}


@RequestMapping("/dojos/new")
public String newStudent (@ModelAttribute("dojo") Dojo dojo) {
	return "dojo.jsp";
}
@RequestMapping(value="/dojos/new", method =RequestMethod.POST)
public String createStudent (@Valid@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
	
	if(result.hasErrors() ) {
		return "dojo.jsp";
	}
	dojoServices. creatdojo(dojo);
	return "redirect:/";
}
//******************Ninja

@RequestMapping("/ninja/new")
public String newContact (@ModelAttribute("ninja") Ninja ninja, Model model) {
	model.addAttribute("stu",dojoServices.allLanguages());
	return "newNinja.jsp";
}
@RequestMapping(value="/ninja/new", method =RequestMethod.POST)
public String createContact (@Valid@ModelAttribute("ninja") Ninja ninja,Model model, BindingResult result) {
	
	if(result.hasErrors() ) {
		return "newNinja.jsp";
	}
	model.addAttribute("stu",ninjaServices.allLanguages());
	ninjaServices.creatninja(ninja);
	return "redirect:/";
}
//******************
@RequestMapping("/dojo/{id}")
public String person(@PathVariable("id") Long id, Model model) {
	Dojo dojo = dojoServices.finddojo(id);
//	List<Ninja> ninjas=ninjaServices.allLanguages();
	model.addAttribute("dojo", dojo);
//	model.addAttribute("ninjas",ninjas);
	return "view.jsp";
}
//****

//****
}
