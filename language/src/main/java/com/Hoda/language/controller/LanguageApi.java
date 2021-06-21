//package com.Hoda.language.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Hoda.language.models.Language;
//import com.Hoda.language.service.LanguageService;
//
//@RestController
//public class LanguageApi {
//	private final LanguageService languageService;
//
//	public LanguageApi(LanguageService languageService) {
//		this.languageService = languageService;
//	}
//
//	@RequestMapping("api/language")
//	public List<Language> index() {
//		return languageService.allLanguages();
//	}
//
//	@RequestMapping(value = "api/language", method = RequestMethod.POST)
//	public Language create(@RequestParam(value = "name") String name, @RequestParam(value = "creator") String creator,
//			@RequestParam(value = "version") Double version) {
//		Language language = new Language(name, creator, version);
//		return languageService.creatlanguage(language);
//	}
//
//	@RequestMapping("/api/language/{id}")
//	public Language show(@PathVariable("id") Long id) {
//		Language language = languageService.findLanguage(id);
//		return language;
//	}
//
//	@RequestMapping(value = "/api/language/{id}", method = RequestMethod.PUT)
//	public Language edit(@PathVariable("id") Long id, @RequestParam(value = "name") String name,
//			@RequestParam(value = "creator") String creator, @RequestParam(value = "version") double version) {
//		Language language = languageService.editLanguage(id, name, creator, version);
//		return language;
//	}
//
//	@RequestMapping(value = "/api/language/{id}", method = RequestMethod.DELETE)
//	public void delete(@PathVariable("id") Long id) {
//		languageService.deletelanguage(id);
//	}
//
//}
