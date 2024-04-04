package com.relevantz.ccp.service;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.ResponseDetailsDTO;
import com.relevantz.ccp.model.ResponseDetails;
import com.relevantz.ccp.model.Survey;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.ResponseDetailsRepo;
import com.relevantz.ccp.repository.SurveyRepo;
import com.relevantz.ccp.repository.UserRepo;

@Service
public class ResponseDetailsService {

	@Autowired
	ResponseDetailsRepo rdRepo;
	
	@Autowired
	ResponseDetails responseDetails;
	
	@Autowired
	SurveyRepo srRepo;
	
	@Autowired
	UserRepo urRepo;

	public boolean insert(ResponseDetailsDTO responseDetailsDTO) {
		System.out.println("a");
		Survey survey=srRepo.findById(responseDetailsDTO.getSurveyId()).get();
		User user=urRepo.findById(responseDetailsDTO.getUserId()).get();
		responseDetails.setResponseDetailId(rdRepo.count()+1);
//		responseDetails.setResponse(responseDetailsDTO.getResponse());
		responseDetails.setStartTime(responseDetailsDTO.getStartTime());
		responseDetails.setEndTime(responseDetailsDTO.getEndTime());
		responseDetails.setSurvey(survey);
		responseDetails.setUsers(user);
		rdRepo.save(responseDetails);
		return true;
   }

	public boolean update(ResponseDetails responseDetails) {
		rdRepo.save(responseDetails);
		return true;
	}

	public boolean delete(long responseDetailId) {
		rdRepo.deleteById(responseDetailId);
		return true;
	}

	public List<ResponseDetails> getAllResponseDetails() {
		Iterator<ResponseDetails> it = rdRepo.findAll().iterator();
		ArrayList<ResponseDetails> list = new ArrayList<>();
		while (it.hasNext()) {
//			ResponseDetails responseDetailss=it.next();
//			ResponseDetailsDTO responsedetailsDTO=new ResponseDetailsDTO();
//		    User user=responseDetailss.getUsers();
//			responsedetailsDTO.setUserName(user.getUserFirstName());
//			responsedetailsDTO.setStartTime(responseDetailss.getStartTime());
//			responsedetailsDTO.setEndTime(responseDetailss.getEndTime());
//			list.add(responsedetailsDTO);
			list.add(it.next());
		}
		return list;
	}
	
	public List<ResponseDetailsDTO> getResponseDetails(long surveyId) {
		Iterator<ResponseDetails> it = rdRepo.findBySurveyId(surveyId).iterator();
		ArrayList<ResponseDetailsDTO> list = new ArrayList<>();
		while (it.hasNext()) {
			ResponseDetails responseDetailss=it.next();
			ResponseDetailsDTO responsedetailsDTO=new ResponseDetailsDTO();
		    User user=responseDetailss.getUsers();
			responsedetailsDTO.setUserName(user.getUserFirstName());
			responsedetailsDTO.setResponseDetailId(responseDetailss.getResponseDetailId());
			responsedetailsDTO.setStartTime(responseDetailss.getStartTime());
			responsedetailsDTO.setEndTime(responseDetailss.getEndTime());
			list.add(responsedetailsDTO);
		}
		return list;
	}

	public long getResponseDetailCount(long surveyId) {
		long value = rdRepo.getResponseDetailCount(surveyId);
		return value;
	}

}
