package com.Hoda.belt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank
private String fname;
@NotBlank
private String lname;
@Email(message="Email must be valid")
private String email;
@NotBlank
private String location;
@NotBlank 
private String state;
@Size(min=5, message="Password must be greater than 5 characters")
private String password;
@Transient
private String passwordConfirmation;
@Column(updatable=false)
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date createdAt;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date updatedAt;
//relations

//n:m

@ManyToMany(fetch = FetchType.LAZY)
@JoinTable(
    name = "userevents", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "event_id")
)
private List<Event> events;

@OneToMany(mappedBy="host",fetch=FetchType.LAZY)
private List<Event> hosted_events;

@OneToMany(mappedBy="user_text", fetch = FetchType.LAZY)
private List<Comment> user;
//****
public User() {
}




















public User(@NotBlank String fname, @NotBlank String lname, @Email(message = "Email must be valid") String email,
		@NotBlank String location, @NotBlank String state,
		@Size(min = 5, message = "Password must be greater than 5 characters") String password,
		String passwordConfirmation, List<Event> events, List<Event> hosted_events, List<Comment> user) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.email = email;
	this.location = location;
	this.state = state;
	this.password = password;
	this.passwordConfirmation = passwordConfirmation;
	this.events = events;
	this.hosted_events = hosted_events;
	this.user = user;
}







public List<Comment> getUser() {
	return user;
}





public void setUser(List<Comment> user) {
	this.user = user;
}



public List<Event> getHosted_events() {
	return hosted_events;
}



public void setHosted_events(List<Event> hosted_events) {
	this.hosted_events = hosted_events;
}





public String getState() {
	return state;
}




public void setState(String state) {
	this.state = state;
}




public Long getId() {
	return id;
}




public void setId(Long id) {
	this.id = id;
}




public String getFname() {
	return fname;
}




public void setFname(String fname) {
	this.fname = fname;
}




public String getLname() {
	return lname;
}




public void setLname(String lname) {
	this.lname = lname;
}




public String getEmail() {
	return email;
}




public void setEmail(String email) {
	this.email = email;
}




public String getLocation() {
	return location;
}




public void setLocation(String location) {
	this.location = location;
}




public String getPassword() {
	return password;
}




public void setPassword(String password) {
	this.password = password;
}




public String getPasswordConfirmation() {
	return passwordConfirmation;
}




public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}




public List<Event> getEvents() {
	return events;
}




public void setEvents(List<Event> events) {
	this.events = events;
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
