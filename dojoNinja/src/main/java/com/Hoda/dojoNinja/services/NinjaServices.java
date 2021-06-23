package com.Hoda.dojoNinja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hoda.dojoNinja.models.Ninja;
import com.Hoda.dojoNinja.repository.Ninjarepository;

@Service
public class NinjaServices {
	private final Ninjarepository ninjarepository;

	public NinjaServices(Ninjarepository ninjarepository) {
		this.ninjarepository = ninjarepository;
	}
	
	public List<Ninja> allLanguages() {
	    return ninjarepository.findAll();
	}
	
	public Ninja creatninja(Ninja b) {
	    return ninjarepository.save(b);
	}
	

	
//	public List<Ninja> allNullStudents() {
//		return ninjarepository.findByDojoIdIsNull();
//	}
}
