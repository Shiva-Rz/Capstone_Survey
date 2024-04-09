package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.model.Survey;

public interface SurveyRepo extends CrudRepository<Survey, Long> {

	public List<Survey> findBySurveyName(String surveyName);

	public List<Questions> findBySurveyId(long surveyId);
	
	@Query(value = "select * FROM tbl_survey where region_id=?", nativeQuery = true)
	public List<Survey> findByRegionId(long regionId);
	
	@Query(value = "select * FROM tbl_survey where user_id=?", nativeQuery = true)
	public List<Survey> findByUserId(long userId);
	
	@Query(value = "select * FROM tbl_survey where region_id=? and user_id!=?", nativeQuery = true)
	public List<Survey> findByRegionUser(long userId,long regionId);
	

}
