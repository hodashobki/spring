package com.Hoda.dojoNinja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.dojoNinja.models.Dojo;
import com.Hoda.dojoNinja.models.Ninja;
import com.Hoda.dojoNinja.repository.DojoRepository;

@Service
public class DojoServices {
private final DojoRepository  dojoRepository;

public DojoServices(DojoRepository dojoRepository) {
	this.dojoRepository = dojoRepository;
}
public List<Dojo> allLanguages() {
    return dojoRepository.findAll();
}
public Dojo creatdojo(Dojo b) {
    return dojoRepository.save(b);
}
public Dojo finddojo(Long id) {
    Optional<Dojo> optionaldojo = dojoRepository.findById(id);
    if(optionaldojo.isPresent()) {
        return optionaldojo.get();
    } else {
        return null;
    }
}


}
