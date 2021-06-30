package com.Hoda.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hoda.belt.repository.EventRepository;
import com.Hoda.belt.repository.UserEventRepository;
import com.Hoda.belt.models.Event;
import com.Hoda.belt.models.UserEvent;

@Service
public class EventService {
	@Autowired
	private EventRepository evRepo;
	@Autowired
	private UserEventRepository uevRepo;
	
	public List<Event> findAllEvents(){
		return evRepo.findAll();
		}

	public Event FindEvntById(Long id) {
		Event event=evRepo.findById(id).orElse(null);
		return event;
	}

	public Event creatEvent(Event e) {
		return evRepo.save(e);
	}
	
	public UserEvent addEventToUser( UserEvent ue) {
		return uevRepo.save(ue);
	}
	
	public void unjoin(Long id) {
		uevRepo.deleteById(id);
	}
	
	
	
	public void deleteEvent(Long id) {
		evRepo.deleteById(id); 
	}
	
	public Event editEvent(Event ev) {
		return evRepo.save(ev);
	}
	
	public List<Event>findByStatein(String state){
		return evRepo.findByState(state);
		}
	
	public List<Event> findStateNotIn(String state){
		return evRepo.findByStateIsNot(state);
	}
	
//	***the end
}






