package com.Hoda.belt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.belt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	 User findByEmail(String email);
	 User findByFname(String fname);
}
