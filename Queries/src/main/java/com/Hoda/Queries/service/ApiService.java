package com.Hoda.Queries.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hoda.Queries.models.City;
import com.Hoda.Queries.models.Country;
import com.Hoda.Queries.models.Language;
import com.Hoda.Queries.repository.CityRepository;
import com.Hoda.Queries.repository.Countryrepository;
import com.Hoda.Queries.repository.LanguageRepository;

@Service
public class ApiService {
private final Countryrepository cRepo;
private final LanguageRepository lRepo;
private final CityRepository ciRepo;
public ApiService(Countryrepository cRepo, LanguageRepository lRepo, CityRepository ciRepo) {
	super();
	this.cRepo = cRepo;
	this.lRepo = lRepo;
	this.ciRepo = ciRepo;
}
public List<Country> getCountries() {
	return this.cRepo.findConMonCountries();
}
public List<City> getCities() {
	return this.ciRepo.findAll();
}
public List<Language> getLanguages() {
	return this.lRepo.findAll();
}
public List<Country> getCountryByName(String name) {
	return this.cRepo.findCountryByName(name);
}
public List<Object[]> getCountryByLanguage(String lang) {
	return this.cRepo.findCountryByLang(lang);
}
public List<Object[]> getCountryByRegion() {
	return this.cRepo.findCountryByRegion();
}
public List<Object[]> getCountriesByCityCount() {
	return this.cRepo.findCountryCityCount();
}
public List<Object[]> getCountryLanguagues() {
	return this.lRepo.findCountryLangs();
}
public List<City> getMexicanCities() {
	return this.ciRepo.mexicanCities();
}
public List<Object[]> getBuenosAiresCities() {
	return this.ciRepo.argentinaBuenosAires();
}


}
