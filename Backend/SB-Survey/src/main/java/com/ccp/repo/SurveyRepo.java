package com.ccp.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ccp.bean.Questions;
import com.ccp.bean.Survey;

@Repository
public interface SurveyRepo extends CrudRepository<Survey, Long> {

	public List<Survey> findBySurveyName(String surveyName);
	
	
	public List<Questions> findBySurveyId(long surveyId);
}
