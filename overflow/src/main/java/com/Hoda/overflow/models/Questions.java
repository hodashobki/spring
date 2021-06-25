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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "questions")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String question;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "questions_id"), inverseJoinColumns = @JoinColumn(name = "tags_id"))
	private List<Tags> tags;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answers> answers;
    
	public Questions() {
		
	}
	
	
	public Questions(String question2, List<Tags> questionsTags) {
		// TODO Auto-generated constructor stub
		this.question = question2;
		this.tags = questionsTags;
	}


	public List<Answers> getAnswers() {
		return answers;
	}


	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public Long getId() {
		return id;
	}


	public void addanswer(Answers answer) {
		// TODO Auto-generated method stub
		this.answers.add(answer);
	}


	public String[] splitTags() {
		// TODO Auto-generated method stub
		String[] s = tags.toString().split("\\s*,\\s*");
		return s;
	}

}
