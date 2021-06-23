package com.Hoda.roster.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.roster.models.Contact;
@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact>findAll();

}
