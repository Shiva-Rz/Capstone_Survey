package com.relevantz.ccp.repository;

//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//
//import com.relevantz.ccp.model.Comment;
//import com.relevantz.ccp.model.Department;
//
//public interface CommentRepo extends CrudRepository<Comment, Long> {
//
//	
//	@Query(value = "select * FROM tbl_comment where survey_id=?", nativeQuery = true)
//	public List<Comment> getCommentBySurveyId(long surveyId);
//}


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.relevantz.ccp.model.Comment;

 
@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	@Modifying
	@Query("update Comment c set c.body = ?1 where c.id = ?2")
	void updateById(long id);
 
}