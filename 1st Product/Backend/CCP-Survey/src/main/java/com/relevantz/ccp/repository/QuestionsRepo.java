package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Questions;

public interface QuestionsRepo extends CrudRepository<Questions, Long> {

	@Query(value = "select count(*) from tbl_question where page_id=?", nativeQuery = true)
	public long getCount(long pageId);

	@Query(value = "select * from tbl_question where page_id=?", nativeQuery = true)
	public List<Questions> findByPageId(long pageId);

}
