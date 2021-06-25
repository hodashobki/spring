package com.Hoda.overflow.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.Hoda.overflow.models.Tags;



public interface TagsRepository extends CrudRepository<Tags, Long>{
	List<Tags> findAll();

	Optional<Tags> findBySubject(String ss);
}
