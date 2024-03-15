package com.relevantz.ccp.repository;

import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
