package com.Hoda.overflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.overflow.models.Answers;
import com.Hoda.overflow.services.TagService ;
import com.Hoda.overflow.models.Newq;
import com.Hoda.overflow.models.Questions;
import com.Hoda.overflow.models.Tags;
import com.Hoda.overflow.repository.QuestionsRepository;
import com.Hoda.overflow.repository.TagsRepository;


@Service
public class QuestionsService {
	private final QuestionsRepository questionrepo;
	private final TagsRepository tagpero;
	private final TagService tagser;
	public QuestionsService(QuestionsRepository questionrepo, TagsRepository tagpero, TagService tagser) {
		this.questionrepo=questionrepo;
		this.tagpero=tagpero;
		this.tagser=tagser;
	}
	
	public List<Questions> allquestions(){
		return questionrepo.findAll();
	}
	
	public Questions createquestion(Newq question) {
		List<Tags> questionsTags = new ArrayList<Tags>();
		for(String t: question.splitTags()) {
			Tags tag = this.tagser.findtagbysub(t);
			if(tag == null) {
				tag = new Tags(t);
				this.tagpero.save(tag);
			}
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Questions newQuestion = new Questions(question.getQuestion(), questionsTags);
		return questionrepo.save(newQuestion);
		
	}
	public Questions findquestion(Long id) {
		Optional<Questions> optionalquestion= questionrepo.findById(id);
		if(optionalquestion.isPresent()) return optionalquestion.get();
		else return null;
	}

	public void change(Questions question, Answers answer) {
		List<Answers> catlist = question.getAnswers();
		catlist.add(answer);
		question.setAnswers(catlist);
		questionrepo.save(question);
		
	}

}
