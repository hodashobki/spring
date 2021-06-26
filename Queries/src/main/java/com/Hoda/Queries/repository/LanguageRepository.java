package com.Hoda.Queries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.Queries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer>{
	List<Language> findAll();
	@Query("SELECT c.name AS country, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> findCountryLangs();
}
