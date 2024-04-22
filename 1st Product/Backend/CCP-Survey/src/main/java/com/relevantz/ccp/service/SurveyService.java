package com.relevantz.ccp.service;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import com.relevantz.ccp.model.Response;
import com.relevantz.ccp.model.ResponseDetails;
import com.relevantz.ccp.model.Survey;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.DepartmentRepo;
import com.relevantz.ccp.repository.PagesRepo;
import com.relevantz.ccp.repository.ProjectRepo;
import com.relevantz.ccp.repository.RegionRepo;
import com.relevantz.ccp.repository.ResponseDetailsRepo;
import com.relevantz.ccp.repository.SurveyRepo;
import com.relevantz.ccp.repository.UserRepo;

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
	UserRepo urRepo;


	@Autowired
	Survey survey;
	
	@Autowired
	User user;
	
	@Autowired
	Pages pages;
	
	@Autowired
	PagesRepo pagesRepo;

	@Autowired
	Region region;

	@Autowired
	Department department;
	
	@Autowired
	ResponseDetailsRepo resDetRepo;

	@Autowired
	Project project;

	public Response insert(SurveyDTO surveydto) {

		survey.setSurveyId(srRepo.count() + 1);
		survey.setSurveyName(surveydto.getSurveyName());
		survey.setEndDate(surveydto.getEndDate());

		region = rgRepo.findById(surveydto.getRegion()).get();
		survey.setRegion(region);

		department = dtRepo.findById(surveydto.getDepartment()).get();
		survey.setDepartment(department);
		
		user=urRepo.findById(surveydto.getUser()).get();
		survey.setUser(user);

		project = ptRepo.findById(surveydto.getProject()).get();
		survey.setProject(project);

		survey.setStatus("Open");
		srRepo.save(survey);
		
		Iterator<Survey> it=srRepo.findAll().iterator();
		ArrayList<Survey> surveyList=new ArrayList<Survey>();
		while(it.hasNext()) {
			surveyList.add(it.next());
		}
		int b=surveyList.size();
		Survey sur=surveyList.get(b-1);
		Long value=sur.getSurveyId();
		Response response=new Response();
		response.setMessage(value.toString());
		return response;
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
	
	public List<SurveyDTO> getSurvey(long userId) {
		User user=urRepo.findById(userId).get();
		Region reg=user.getRegion();
		Iterator<Survey> it1 = srRepo.findByRegionId(reg.getRegionId()).iterator();
		ArrayList<SurveyDTO> surveyList = new ArrayList<>();
		while (it1.hasNext()) {
			SurveyDTO surDTO=new SurveyDTO();
			Survey sur=it1.next();
			surDTO.setSurveyId(sur.getSurveyId());
			surDTO.setSurveyName(sur.getSurveyName());
			surDTO.setEndDate(sur.getEndDate());
			surDTO.setStatus(sur.getStatus());
			User usr=sur.getUser();
			surDTO.setUser(usr.getUserId());
			surDTO.setUserName(usr.getUserFirstName());
			Region rg=sur.getRegion();
			surDTO.setRegion(rg.getRegionId());
			Department dt=sur.getDepartment();
			surDTO.setDepartment(dt.getDepartmentId());
			Project pr=sur.getProject();
			surDTO.setProject(pr.getProjectId());
			Iterator<ResponseDetails> itResDet=resDetRepo.findByUserId(userId).iterator();
			while(itResDet.hasNext()) {
				ResponseDetails responseDetails=itResDet.next();
				Survey survey=responseDetails.getSurvey();
				if(survey.getSurveyId()==sur.getSurveyId()) {
					surDTO.setResponse(true);
				}
			}
			surveyList.add(surDTO);
		}
		return surveyList;
	}
	
	public List<SurveyDTO> getSurveyByUser(long userId) {
		Iterator<Survey> it1 = srRepo.findByUserId(userId).iterator();
		ArrayList<SurveyDTO> surveyList = new ArrayList<>();
		while (it1.hasNext()) {
			SurveyDTO surDTO=new SurveyDTO();
			Survey sur=it1.next();
			surDTO.setSurveyId(sur.getSurveyId());
			surDTO.setSurveyName(sur.getSurveyName());
			surDTO.setEndDate(sur.getEndDate());
			surDTO.setStatus(sur.getStatus());
			surDTO.setPage(sur.getPage());
			surDTO.setResponseDetails(sur.getResponseDetails());
			surDTO.setReaction(sur.getReaction());
			User user=sur.getUser();
			surDTO.setUser(user.getUserId());
			surDTO.setUserName(user.getUserFirstName());
			Region region=sur.getRegion();
			surDTO.setRegion(region.getRegionId());
			Iterator<ResponseDetails> itResDet=resDetRepo.findByUserId(userId).iterator();
			while(itResDet.hasNext()) {
				ResponseDetails responseDetails=itResDet.next();
				Survey survey=responseDetails.getSurvey();
				if(survey.getSurveyId()==sur.getSurveyId()) {
					surDTO.setResponse(true);
				}
			}
			surveyList.add(surDTO);
		}
		return surveyList;
	}
	
	public List<SurveyDTO> getSurveyRegionUser(long userId) {
		User user=urRepo.getByUserId(userId);
		Region reg=user.getRegion();
		Iterator<Survey> it1 = srRepo.findByRegionUser(reg.getRegionId(),userId).iterator();
		ArrayList<SurveyDTO> surveyList = new ArrayList<>();
		while (it1.hasNext()) {
//			surveyList.add(it1.next());
			SurveyDTO surDTO=new SurveyDTO();
			Survey sur=it1.next();
			surDTO.setSurveyId(sur.getSurveyId());
			surDTO.setSurveyName(sur.getSurveyName());
			surDTO.setEndDate(sur.getEndDate());
			surDTO.setStatus(sur.getStatus());
			surDTO.setPage(sur.getPage());
			surDTO.setResponseDetails(sur.getResponseDetails());
			surDTO.setReaction(sur.getReaction());
			User usr=sur.getUser();
			surDTO.setUser(usr.getUserId());
			surDTO.setUserName(usr.getUserFirstName());
			Region region=sur.getRegion();
			surDTO.setRegion(region.getRegionId());
			Iterator<ResponseDetails> itResDet=resDetRepo.findByUserId(userId).iterator();
			while(itResDet.hasNext()) {
				ResponseDetails responseDetails=itResDet.next();
				Survey survey=responseDetails.getSurvey();
				if(survey.getSurveyId()==sur.getSurveyId()) {
					surDTO.setResponse(true);
				}
			}
			surveyList.add(surDTO);
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
	
	public boolean compareDate() {
		Iterator<Survey> it=srRepo.findAll().iterator();
		while(it.hasNext()) {
		Survey sur=it.next();
		LocalDate today=LocalDate.now();
		String date=sur.getEndDate().toString();
		LocalDate givenDate=LocalDate.parse(date);
		 System.out.println(sur.getEndDate());
//		 Survey survey1=new Survey();
		if(today.isAfter(givenDate)) {
			sur.setSurveyId(sur.getSurveyId());
			sur.setStatus("Closed");
		}
		srRepo.save(sur);
		}
		return true;
	}

}
