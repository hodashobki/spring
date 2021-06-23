package com.Hoda.license.controllers;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Hoda.license.models.Person;
import com.Hoda.license.models.License;
import com.Hoda.license.services.LicenseServices;
import com.Hoda.license.services.PersonServices;

@Controller
public class PersonController {
private final PersonServices personServices;
private final LicenseServices licenseServices;


public PersonController(PersonServices personServices,LicenseServices licenseServices) {
	this.personServices=personServices;
	this.licenseServices =licenseServices;
}
@RequestMapping("")
public String firstpage() {
	return "index.jsp";
}
@RequestMapping("/person/new")
public String person() {
	return "person.jsp";
}
@RequestMapping(value = "/createperson", method = RequestMethod.POST)
public String show2(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
	Person person= new Person(firstName,lastName);
	personServices.creatperson(person);
	return "redirect:/person/new";
}
//*****************create license
@RequestMapping("/license/new")
public String newlicen(Model model) {
	List<Person> persons = personServices.allpersons();
	model.addAttribute("persons", persons);
	return "license.jsp";
}
@RequestMapping(value="/licenses/ne", method = RequestMethod.POST)
public String show3(@RequestParam(value="person") Long person,@RequestParam(value="state") String state,
	@RequestParam(value="expirationDate")String expirationDate)throws ParseException{
	Person fperson=personServices.findperson(person);
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	Date date = formatter.parse(expirationDate);
	License newlicence = new License(date,state,fperson);
	licenseServices.createlicnse(newlicence);
	return "redirect:/license/new";
}
@RequestMapping("/profile/{id}")
public String person(@PathVariable("id") Long id, Model model) {
	Person person = personServices.findperson(id);
	model.addAttribute("person", person);
	return "profil.jsp";
}

}
