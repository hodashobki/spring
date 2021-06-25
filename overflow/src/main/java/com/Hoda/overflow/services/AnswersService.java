package com.Hoda.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.overflow.repository.AnswersRepository;
import com.Hoda.overflow.models.Questions;
import com.Hoda.overflow.models.Answers;


@Service
public class AnswersService {
	private final AnswersRepository answersrepo;
	public AnswersService(AnswersRepository answersrepo) {
		this.answersrepo=answersrepo;
	}
	
	public List<Answers> allanswers(){
		return answersrepo.findAll();
	}
	
	public Answers createanswer(Answers answer) {
		return answersrepo.save(answer);
		
	}
	public Answers findanswer(Long id) {
		Optional<Answers> optionalanswer= answersrepo.findById(id);
		if(optionalanswer.isPresent()) return optionalanswer.get();
		else return null;
	}

	public void createproduct(Answers answer, Questions question) {
	
		question.addanswer(answer);
		
	}
}
