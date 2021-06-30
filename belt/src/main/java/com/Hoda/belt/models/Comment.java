package com.Hoda.belt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String message;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
//	relations
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User user;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
//	************
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_message")
	private User user_text;
	
	public Comment() {
	}

	



	




	public Comment( String message, Event event, User user_text) {
		
		this.message = message;
		this.event = event;
		this.user_text = user_text;
	}










	public User getUser_text() {
		return user_text;
	}










	public void setUser_text(User user_text) {
		this.user_text = user_text;
	}










	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public Event getEvent() {
		return event;
	}





	public void setEvent(Event event) {
		this.event = event;
	}





	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	}
	
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}
	
	
}
