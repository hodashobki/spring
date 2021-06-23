package com.Hoda.roster.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
	
	private Long id;
	private String address;
	private String city;
	private String state;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
	
	public Contact() {
		super();
	}
	
	public Contact(String address, String city, String state, Student student) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.student = student;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
