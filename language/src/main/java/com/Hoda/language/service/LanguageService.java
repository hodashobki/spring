package com.Hoda.language.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.language.models.Language;
import com.Hoda.language.repository.LanguageRepository;

@Service
public class LanguageService {
private final LanguageRepository languageRepository;

public LanguageService (LanguageRepository languageRepository) {
this.languageRepository=languageRepository;	
}
public List<Language> allLanguages() {
    return languageRepository.findAll();
}
public Language creatlanguage(Language b) {
    return languageRepository.save(b);
}
public Language findLanguage(Long id) {
    Optional<Language> optionalBook = languageRepository.findById(id);
    if(optionalBook.isPresent()) {
        return optionalBook.get();
    } else {
        return null;
    }
}
//public Language editLanguage(Language language) {
//	return languageRepository.save(language);
//}

public Language updateBook(Long id, String name, String creator, Double version) {
	Optional<Language> thisBook = languageRepository.findById(id);
	thisBook.get().setName(name);
	thisBook.get().setCreator(creator);
	thisBook.get().setVersion(version);
	
	
    return languageRepository.save(thisBook.get());
}

public void deletelanguage(Long id) {
	Optional<Language> optionalLang = languageRepository.findById(id);
	if(optionalLang.isPresent()) {
		languageRepository.deleteById(id);
	}

}
}
