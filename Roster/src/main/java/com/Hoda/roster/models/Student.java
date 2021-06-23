package com.Hoda.roster.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity
	@Table(name="students")
	public class Student {
	public Student(String firstname, String lastname, int age, Contact contact) {
			super();
			this.firstname = firstname;
			this.lastname = lastname;
			this.age = age;
			this.contact = contact;
		}
	public Student() {
			super();
		}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	@Column(name="age")
	private int age;
	@OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
private Contact contact;
}
