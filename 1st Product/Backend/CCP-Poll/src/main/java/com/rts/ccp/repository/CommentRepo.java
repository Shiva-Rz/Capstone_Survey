package com.rts.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rts.ccp.bean.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long>{

	@Modifying
	@Query("update Comment c set c.body = ?1 where c.id = ?2")
	void updateById(long id);

	@Query(value="select * from tbl_poll_comment where poll_id=?", nativeQuery = true)
	public List<Comment> findByPollId(long pollId);
}