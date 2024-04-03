package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Options;

public interface OptionRepo extends CrudRepository<Options, Long> {

	@Query(value = "select * FROM tbl_option where question_id=?", nativeQuery = true)

	public List<Options> findByQuestionId(long questionId);

	@Query(value = "select question_id FROM tbl_option where option_id=?", nativeQuery = true)

	public long findByOptionId(long optionId);
}
