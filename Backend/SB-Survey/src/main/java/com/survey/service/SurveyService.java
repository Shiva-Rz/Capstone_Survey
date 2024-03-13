package com.survey.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.bean.Survey;
import com.survey.repo.SurveyRepo;

@Service
public class SurveyService {
	
	@Autowired
	SurveyRepo srRepo;
	
	public boolean insert(Survey survey) {
		srRepo.save(survey);
		return true;
   }
	
	public boolean update(Survey survey) {
		srRepo.save(survey);
		return true;
	}
	
	public boolean delete(long surveyId) {
		srRepo.deleteById(surveyId);
		return true;
	}
	
	public List<Survey> getSurveyDetails(String surveyName) {
		Iterator<Survey> it1=srRepo.findBySurveyName(surveyName).iterator();
		ArrayList<Survey> surveyList=new ArrayList<>();
		while(it1.hasNext()) {
			surveyList.add(it1.next());
		}
		return surveyList;
	}
	
	public List<Survey> getAllSurveyDetails(){
		Iterator<Survey> it=srRepo.findAll().iterator();
		ArrayList<Survey> list=new ArrayList<>();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	

}
