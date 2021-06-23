package com.Hoda.roster.serveses;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hoda.roster.Repository.ContactRepository;
import com.Hoda.roster.Repository.StudentRepository;
import com.Hoda.roster.models.Contact;
import com.Hoda.roster.models.Student;
@Service
public class ApisService {
private final ContactRepository contactRepository;
private final StudentRepository studentRepository;
public ApisService(ContactRepository contactRepository, StudentRepository studentRepository) {
	super();
	this.contactRepository = contactRepository;
	this.studentRepository = studentRepository;
}
public Student createStudent(Student student) {
	return studentRepository.save(student);
}
public Contact createcontact(Contact contact) {
	return contactRepository.save(contact);
}

public List<Student> allstud(){
	return studentRepository.findAll();
	
}
public List<Contact> allcont(){
	return contactRepository.findAll();
	
}



}
