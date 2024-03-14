package com.relevantz.ccp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.ResponseDetails;

public interface ResponseDetailsRepo extends CrudRepository<ResponseDetails, Long> {

	@Query(value = "select count(*) from tbl_reponsedetail where survey_id=?", nativeQuery = true)
	public long getResponseDetailCount(long surveyId);
}
