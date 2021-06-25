package com.Hoda.overflow.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Tags {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String subject;
		@Column(updatable = false)
		private Date createdAt;
		private Date updatedAt;
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "tags_id"), inverseJoinColumns = @JoinColumn(name = "questions_id"))
		private List<Questions> questions;
		public Tags() {
		}
		public Tags(String t) {
			// TODO Auto-generated constructor stub
			this.subject=t;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public List<Questions> getQuestions() {
			return questions;
		}
		public void setQuestions(List<Questions> questions) {
			this.questions = questions;
		}
		public Long getId() {
			return id;
		}
		public Tags orElse(Object object) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
}
