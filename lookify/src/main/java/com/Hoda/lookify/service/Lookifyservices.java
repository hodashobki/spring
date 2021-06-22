package com.Hoda.lookify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.lookify.models.Lookify;
import com.Hoda.lookify.repository.LookifyRepository;

@Service
public class Lookifyservices {
private final LookifyRepository lookifyRepository;
public Lookifyservices(LookifyRepository lookifyRepository) {
	this.lookifyRepository =lookifyRepository;
}
public List<Lookify> allLooki() {
    return lookifyRepository.findAll();
}

public Lookify creatllooki(Lookify b) {
    return lookifyRepository.save(b);
}

public Lookify findLooki(Long id) {
    Optional<Lookify> optionallooki = lookifyRepository.findById(id);
    if(optionallooki.isPresent()) {
        return optionallooki.get();
    } else {
        return null;
    }
}
//*****delete
public void deletelanguage(Long id) {
	Optional<Lookify>optionallooki = lookifyRepository.findById(id);
	if(optionallooki.isPresent()) {
		lookifyRepository.deleteById(id);
	}
	}
//*******search

public List<Lookify> lookiContainingArtist(String artist) {
	return lookifyRepository.findByArtistContaining(artist);
}
public List<Lookify> lookiContainingTitle(String title) {
	return lookifyRepository.findByTitleContaining(title);
}
//******************top
public List<Lookify> rating() {
	return lookifyRepository.findTop10ByOrderByRatingDesc();
}


}
