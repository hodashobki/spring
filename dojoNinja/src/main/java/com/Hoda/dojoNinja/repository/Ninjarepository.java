package com.Hoda.dojoNinja.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.dojoNinja.models.Ninja;

@Repository
public interface Ninjarepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
	List<Ninja> findByDojoIdIsNull();

}
