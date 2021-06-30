package com.Hoda.belt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Hoda.belt.models.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
List<Comment>findAll();




}
