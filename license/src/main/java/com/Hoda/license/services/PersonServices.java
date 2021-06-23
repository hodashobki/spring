package com.Hoda.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Hoda.license.models.Person;
import com.Hoda.license.repository.PersonRepository;

@Service
public class PersonServices {
private final PersonRepository personRepository;

public PersonServices(PersonRepository personRepository) {
	this.personRepository=personRepository;
}
public List<Person> allpersons() {
    return personRepository.findAll();
}
public Person creatperson(Person p) {
    return personRepository.save(p);
}
public Person findperson(Long id) {
	Optional<Person> opperson = personRepository.findById(id);
	if(opperson.isPresent())
		return opperson.get();
	else return null;
}


}
