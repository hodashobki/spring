package com.Hoda.language.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.language.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	
	List<Language> findAll();
    
}
