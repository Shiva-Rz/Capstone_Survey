package com.ccp.repo;

import org.springframework.data.repository.CrudRepository;

import com.ccp.bean.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
