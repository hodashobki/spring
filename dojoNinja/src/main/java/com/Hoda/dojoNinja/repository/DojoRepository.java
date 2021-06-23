package com.Hoda.dojoNinja.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.dojoNinja.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
List<Dojo>findAll();
}
