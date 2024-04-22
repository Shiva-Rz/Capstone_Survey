package com.relevantz.ccp.service;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relevantz.ccp.dto.ReactionDTO;
import com.relevantz.ccp.dto.ResponsesDTO;
import com.relevantz.ccp.model.Reaction;
import com.relevantz.ccp.model.Region;
import com.relevantz.ccp.model.Responses;
import com.relevantz.ccp.model.Survey;
import com.relevantz.ccp.model.User;
import com.relevantz.ccp.repository.ReactionRepo;
import com.relevantz.ccp.repository.SurveyRepo;
import com.relevantz.ccp.repository.UserRepo;

@Service
public class ReactionService {

	@Autowired
	ReactionRepo rnRepo;
	
	@Autowired
	SurveyRepo srRepo;
	
	@Autowired
	UserRepo urRepo;

	public boolean insert(Reaction reaction) {
		rnRepo.save(reaction);
		return true;
	}

	public boolean update(Reaction reaction) {
		rnRepo.save(reaction);
		return true;
	}

	public boolean delete(long reactionId) {
		rnRepo.deleteById(reactionId);
		return true;
	}
	
	public long getReactionCount(long surveyId){
        return rnRepo.getReactionCount(surveyId);
    }
	
	public List<ReactionDTO> getReactionCountByRegion(long userId){
		
		User user=urRepo.findById(userId).get();
		Region reg=user.getRegion();
		Iterator<Survey> it=srRepo.findByRegionId(reg.getRegionId()).iterator();
		ArrayList<ReactionDTO> list=new ArrayList<ReactionDTO>();
		while(it.hasNext()) {
			Survey survey=it.next();
			ReactionDTO resp=new ReactionDTO();
			resp.setSurveyId(survey.getSurveyId());
			resp.setReactionCount(rnRepo.getReactionCount(survey.getSurveyId()));
	        list.add(resp);
		}
        return list;
    }
	
	public boolean deleteReactionById() {
		rnRepo.deletebylastId();
		return true;
	}
	
	public boolean insertReaction(ReactionDTO reaction) {
		Survey survey = srRepo.findById(reaction.getSurveyId()).get();
		User user = urRepo.findById(reaction.getUserId()).get();
		
		Reaction reactions= new Reaction();
		reactions.setSurveyId(survey);
		reactions.setUserId(user);
		
		rnRepo.save(reactions);
		return true;
	}

	public List<Reaction> getAllReactionDetails() {
		Iterator<Reaction> it = rnRepo.findAll().iterator();
		ArrayList<Reaction> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

	public List<Reaction> DepartmentDetails() {
		Iterator<Reaction> it = rnRepo.getReaction().iterator();
		ArrayList<Reaction> list = new ArrayList<>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}

}
