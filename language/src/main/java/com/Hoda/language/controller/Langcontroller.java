package com.Hoda.language.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.language.models.Language;
import com.Hoda.language.service.LanguageService;

@Controller
public class Langcontroller {
	private final LanguageService languageService;

	public Langcontroller(LanguageService langService) {
		this.languageService = langService;
	}

	@RequestMapping("/languages")
	public String show(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}

	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public String show2(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
			@RequestParam(value = "version") double version) {
		Language language = new Language(name, creator, version);
		languageService.creatlanguage(language);
		return "redirect:/languages";
	}

	@RequestMapping(value = "/language/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		languageService.deletelanguage(id);
		return "redirect:/languages";
	}

	@RequestMapping(value="/language/edit/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language lang,@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") Double version) {
		Language languag = languageService.updateBook(id, name, creator, version);
	    return "redirect:/languages";
	}

	@RequestMapping("/language/edit/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}

	@RequestMapping("/language/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "views.jsp";
	}
}
