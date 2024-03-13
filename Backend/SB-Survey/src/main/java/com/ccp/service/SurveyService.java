package com.ccp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccp.bean.Department;
import com.ccp.bean.Project;
import com.ccp.bean.Region;
import com.ccp.bean.Survey;
import com.ccp.bean.SurveyDTO;
import com.ccp.repo.SurveyRepo;

@Service
public class SurveyService {
	
	@Autowired
	SurveyRepo srRepo;

	Survey survey=new Survey();
	Region region=new Region();
	Department department=new Department();
	Project project=new Project();
	
	public boolean insert(SurveyDTO surveydto) {
		
		survey.setSurveyName(surveydto.getSurveyName());
		survey.setEndDate(surveydto.getEndDate());
	    region.setRegionId(surveydto.getRegion());
		survey.setRegion(region);
		department.setDepartmentId(surveydto.getDepartment());
		survey.setDepartment(department);
		project.setProjectId(surveydto.getProject());
		survey.setProject(project);
		survey.setStatus("open");
		srRepo.save(survey);
		return true;
   }
	
	public boolean update(Survey sur) {
		srRepo.save(sur);
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
