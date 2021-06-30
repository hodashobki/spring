package com.Hoda.belt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.belt.models.Event;
import com.Hoda.belt.models.User;
import com.Hoda.belt.models.UserEvent;

@Repository
public interface UserEventRepository extends CrudRepository<UserEvent, Long>{
	List<UserEvent> findByEventContains(Event event);
	UserEvent findByEventAndUser(Event event, User user);

}
