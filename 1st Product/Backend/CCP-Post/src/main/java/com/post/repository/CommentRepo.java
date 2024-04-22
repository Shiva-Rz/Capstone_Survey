package com.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.post.entity.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	
	@Modifying
	@Query("update Comment c set c.body = ?1 where c.id = ?2")
	void updateById(long id);

}