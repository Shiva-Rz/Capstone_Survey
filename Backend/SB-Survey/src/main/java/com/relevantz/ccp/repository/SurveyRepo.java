package com.relevantz.ccp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.relevantz.ccp.model.Questions;
import com.relevantz.ccp.model.Survey;

public interface SurveyRepo extends CrudRepository<Survey, Long> {

	public List<Survey> findBySurveyName(String surveyName);
	
	
	public List<Questions> findBySurveyId(long surveyId);

}
