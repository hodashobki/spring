package com.Hoda.Queries.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Hoda.Queries.models.City;
import com.Hoda.Queries.models.Country;
import com.Hoda.Queries.models.Language;
import com.Hoda.Queries.service.ApiService;

@Controller
public class controller {
	private final ApiService wService;

	public controller(ApiService wService) {
		super();
		this.wService = wService;
	}
	@RequestMapping("/")
	public List<Country> Index() {
		return this.wService.getCountries();
	}
	@RequestMapping("/n/{name}")
	public List<Object[]> CountryByName(@PathVariable("name") String name) {
		return this.wService.getCountryByLanguage(name);
	}
	@RequestMapping("/n/cityCount")
	public List<Object[]> CountryByCityCount() {
		return this.wService.getCountriesByCityCount();
	}
	@RequestMapping("/n/region")
	public List<Object[]> CountryByRegion() {
		return this.wService.getCountryByRegion();
	}
	@RequestMapping("/c")
	public List<City> Cities() {
		return this.wService.getCities();
	}
	@RequestMapping("/c/mexico")
	public List<City> MexicanCities() {
		return this.wService.getMexicanCities();
	}
	@RequestMapping("/c/arg")
	public List<Object[]> BACities() {
		return this.wService.getBuenosAiresCities();
	}
	@RequestMapping("/l")
	public List<Language> Languages() {
		return this.wService.getLanguages();
	}
	@RequestMapping("/l/c")
	public List<Object[]> CountryLangs() {
		return this.wService.getCountryLanguagues();
	}
//@RequestMapping("")
//public String index() {
//	return "index.jsp";
//}
}
