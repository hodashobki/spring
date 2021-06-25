package com.Hoda.overflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.overflow.models.Tags;
import com.Hoda.overflow.repository.TagsRepository;

@Service
public class TagService {
	private final TagsRepository tagrepo;
	public TagService(TagsRepository tagrepo) {
		this.tagrepo=tagrepo;
	}
	
	public List<Tags> alltags(){
		return tagrepo.findAll();
	}
	
	public Tags createtag(Tags tag) {
		return tagrepo.save(tag);
		
	}
	public Tags findtag(Long id) {
		Optional<Tags> optionaltag= tagrepo.findById(id);
		if(optionaltag.isPresent()) return optionaltag.get();
		else return null;
	}
	public Tags findtagbysub(String ss) {
		Optional<Tags> optionaltag= tagrepo.findBySubject(ss);
		if(optionaltag.isPresent()) return optionaltag.get();
		else return null;
	}
}
