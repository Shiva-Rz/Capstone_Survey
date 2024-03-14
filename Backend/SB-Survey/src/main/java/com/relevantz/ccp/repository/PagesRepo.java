package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Pages;

public interface PagesRepo extends CrudRepository<Pages, Long> {
	
	@Query(value="select * FROM tbl_page where survey_id=?",nativeQuery = true) 
	public List<Pages> findBySurveyId(long surveyId);

}
