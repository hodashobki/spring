package com.Hoda.overflow.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Hoda.overflow.models.Questions;

public interface QuestionsRepository extends CrudRepository<Questions, Long> {
	List<Questions> findAll();
}
