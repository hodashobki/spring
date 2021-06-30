package com.Hoda.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hoda.belt.repository.CommentRepository;
import com.Hoda.belt.models.Comment;

@Service
public class CommentService {
@Autowired
private CommentRepository comRepo;

public List<Comment> findAllComments(){
return comRepo.findAll()	;
}
public Comment findCommById(Long id) {
	Comment comment=comRepo.findById(id).orElse(null);
	return comment;
}

public Comment createComment(Comment co) {
return comRepo.save(co);	
}

public void deleteComment(Long id) {
//	Comment comment=comRepo.findById(id).orElse(null);
//	comment.deleteById(id);
	comRepo.deleteById(id);
}

//*****
}
