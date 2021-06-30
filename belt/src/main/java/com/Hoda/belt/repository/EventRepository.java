package com.Hoda.belt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.belt.models.Event;
import com.Hoda.belt.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event,Long>{
	List<Event>findAll();
	
	List<Event>findByStateIsNot(String state);
	List<Event>findByState(String state);
//	List<Event> findByState(String state);
//	List<Event> findNotByState(String state);
//	List<Event> findByStateContains(String state);
//	List<Event> findByStateNotContains(String state);
//	List<Event>findByEventNotContains(User user);
}
