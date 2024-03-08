package com.survey.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.survey.bean.Questions;
import com.survey.bean.Survey;

public interface SurveyRepo extends CrudRepository<Survey, Long> {

	public List<Survey> findBySurveyName(String surveyName);
	
	
	public List<Questions> findBySurveyId(long surveyId);
}
