package com.survey.repo;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
