package com.Hoda.roster.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.roster.models.Student;


@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student>findAll();
}
