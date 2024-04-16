package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.ResponseDetails;

public interface ResponseDetailsRepo extends CrudRepository<ResponseDetails, Long> {

	@Query(value = "select count(*) from tbl_response_detail where survey_id=?", nativeQuery = true)
	public long getResponseDetailCount(long surveyId);
	
	@Query(value = "select * from tbl_response_detail where survey_id=?", nativeQuery = true)
	public List<ResponseDetails> findBySruveyId(long surveyId);
	
	@Query(value = "select * from tbl_response_detail where user_id=?", nativeQuery = true)
	public List<ResponseDetails> findByUserId(long surveyId);
}
