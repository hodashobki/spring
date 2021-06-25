package com.Hoda.overflow.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.Hoda.overflow.models.Answers;

public interface AnswersRepository extends CrudRepository<Answers, Long>{
	List<Answers> findAll();
}
