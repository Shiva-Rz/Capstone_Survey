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
//		User user=urRepo.findById(responseDetailsDTO.getUserId()).get();
		Survey survey=srRepo.findById(responseDetailsDTO.getSurveyId()).get();
		Iterator<ResponseDetails> it=survey.getResponseDetails().iterator();
		ArrayList<ResponseDetails> resList=new ArrayList<ResponseDetails>();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		System.out.println(dateFormat.format(date));
//		responseDetails.setUsers(user);
//		responseDetails.setStartTime(dateFormat.format(date));
		responseDetails.setResponseDetailId(rdRepo.count()+2);
		responseDetails.setStartTime(responseDetailsDTO.getStartTime());
		responseDetails.setEndTime(responseDetailsDTO.getEndTime());
//		responseDetails.setUsers(user);
//		responseDetails.setUserEmailId(user.getUserEmailId());
		while(it.hasNext()) {
			resList.add(it.next());
		}
		resList.add(responseDetails);
		survey.setResponseDetails(resList);
//		rdRepo.save(responseDetails);
		srRepo.save(survey);
		return true;
   }

	public boolean update(ResponseDetails reponseDetails) {
		rdRepo.save(reponseDetails);
		return true;
	}

	public boolean delete(long reponseDetailId) {
		rdRepo.deleteById(reponseDetailId);
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
		Iterator<ResponseDetails> it = rdRepo.findBySruveyId(surveyId).iterator();
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
