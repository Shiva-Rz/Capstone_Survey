package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.PagesDTO;
import com.relevantz.ccp.dto.SurveyDTO;
import com.relevantz.ccp.model.Department;
import com.relevantz.ccp.model.Pages;
import com.relevantz.ccp.model.Project;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.model.Survey;
import com.relevantz.ccp.repository.DepartmentRepo;
import com.relevantz.ccp.repository.PagesRepo;
import com.relevantz.ccp.repository.ProjectRepo;
import com.relevantz.ccp.repository.RegionRepo;
import com.relevantz.ccp.repository.SurveyRepo;

@Service
public class SurveyService {

	@Autowired
	SurveyRepo srRepo;

	@Autowired
	RegionRepo rgRepo;

	@Autowired
	DepartmentRepo dtRepo;

	@Autowired
	ProjectRepo ptRepo;

	@Autowired
	Survey survey;
	
	@Autowired
	Pages pages;
	
	@Autowired
	PagesRepo pagesRepo;

	@Autowired
	Region region;

	@Autowired
	Department department;

	@Autowired
	Project project;

	public boolean insert(SurveyDTO surveydto) {

		survey.setSurveyId(srRepo.count() + 2);
		survey.setSurveyName(surveydto.getSurveyName());
		survey.setEndDate(surveydto.getEndDate());

		region = rgRepo.findById(surveydto.getRegion()).get();
		survey.setRegion(region);

		department = dtRepo.findById(surveydto.getDepartment()).get();
		survey.setDepartment(department);

		project = ptRepo.findById(surveydto.getProject()).get();
		survey.setProject(project);

		survey.setStatus("open");
		srRepo.save(survey);
		return true;
	}
	
	public boolean insertPages(PagesDTO pagesDTO) {
//
		survey=srRepo.findById(pagesDTO.getSurveyId()).get();
//		survey.setPage();
		ArrayList<Pages> pagesList=new ArrayList<>();
		Iterator<Pages> itPage=survey.getPage().iterator();
		while(itPage.hasNext()) {
//		   pagesList.add(itPage.next()); 
		   Pages pages=itPage.next(); 
		   pagesList.add(pages);
		}
		   pages.setPageId(pagesRepo.count()+1);
		   pages.setPageNo(pagesDTO.getPageNo());
		   pages.setPageTitle(pagesDTO.getPageTitle());
//		   pages.setQuestion();
		   pagesList.add(pages);
//		   survey.setSurveyId(pagesDTO.getSurveyId());
		   survey.setPage(pagesList);
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
		Iterator<Survey> it1 = srRepo.findBySurveyName(surveyName).iterator();
		ArrayList<Survey> surveyList = new ArrayList<>();
		while (it1.hasNext()) {
			surveyList.add(it1.next());
		}
		return surveyList;
	}
	
	public List<Survey> getSurvey(long regionId) {
		Iterator<Survey> it1 = srRepo.findByRegionId(regionId).iterator();
		ArrayList<Survey> surveyList = new ArrayList<>();
		while (it1.hasNext()) {
			surveyList.add(it1.next());
		}
		return surveyList;
	}

	public List<Survey> getAllSurveyDetails() {
		Iterator<Survey> it = srRepo.findAll().iterator();
		ArrayList<Survey> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public SurveyDTO getSurveyById(long surveyId) {
		Survey survey=srRepo.findById(surveyId).get();
		SurveyDTO surveyDto=new SurveyDTO();
		surveyDto.setSurveyName(survey.getSurveyName());
		surveyDto.setStatus(survey.getStatus());
		surveyDto.setEndDate(survey.getEndDate());
		return surveyDto;
	}

}
