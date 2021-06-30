package com.Hoda.belt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String name; 
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private Date date;
	@NotBlank 
	private String location;
	@NotBlank 
	private String state;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
//	relations
	

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="host_id")
     private User host;
//	1:m
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "userevents", 
	        joinColumns = @JoinColumn(name = "event_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )     
	    private List<User> users;
	
//	************
	 
	 public Event() {
		}

	 
	
	



	public Event( String name,  Date date, String location, String state, User host,
		List<Comment> comments, List<User> users) {
	super();
	this.name = name;
	this.date = date;
	this.location = location;
	this.state = state;
	this.host = host;
	this.comments = comments;
	this.users = users;
}







	public User getHost() {
		return host;
	}







	public void setHost(User host) {
		this.host = host;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}
	
	



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
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
